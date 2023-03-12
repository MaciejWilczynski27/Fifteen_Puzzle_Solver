package org.example;

import java.util.Vector;

public class GameNode {

    private static boolean solvedFlag = false;
    public static int visited = 0;
    public static int processed = 0;

    public static int maxReachedDepth = 0;
    private static String solution;
    private int currentDepth;
    private int maxDepth;
    private int x;
    private int y;


    private FifteenPuzzle currentBoard;
    private Vector<GameNode> children = new Vector<>();


    private String moveOrder = "";


    //first parent node constructor
    //children and the following parents constructor
    public GameNode(int followingDepth,int maxDepth,String order,Integer x,Integer y,FifteenPuzzle fifteenPuzzle,String permutation,boolean repeat) {
        if (solvedFlag) {
            return;
        }
        processed++;
        visited++;
        this.x = x;
        this.y = y;
        this.maxDepth = maxDepth;
        this.currentDepth = followingDepth;
        this.currentBoard = fifteenPuzzle;
        if(maxReachedDepth < this.currentDepth) {
            maxReachedDepth = this.currentDepth;
        }
        this.moveOrder = order;
        if(!repeat) {
            if(currentDepth == maxDepth && getCurrentBoard().checkBoard()) {
                solvedFlag = true;
                solution = getMoveOrder();
                return;
            }
        } else {
            if(getCurrentBoard().checkBoard()) {
                solvedFlag = true;
                solution = getMoveOrder();
                return;
            }
        }
            if (getCurrentDepth() < getMaxDepth()) {
                for (Integer i = 0; i < permutation.length(); i++) {
                    switch (permutation.charAt(i)) {
                        case 'L':
                            if (this.canMoveLeft() && !this.getMoveOrder().endsWith("R")) {
                                Integer buffer = fifteenPuzzle.getFieldValue(getX() - 1, getY());
                                fifteenPuzzle.setFieldValue(getX(), getY(), buffer);
                                fifteenPuzzle.setFieldValue(getX() - 1, getY(), 0);
                                this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "L", this.getX() - 1, this.getY(), fifteenPuzzle, permutation,repeat));
                                this.children.clear();
                                fifteenPuzzle.setFieldValue(getX() - 1, getY(), buffer);
                                fifteenPuzzle.setFieldValue(getX(), getY(), 0);
                            }
                            break;
                        case 'R':
                            if (this.canMoveRight() && !this.getMoveOrder().endsWith("L")) {
                                Integer buffer = fifteenPuzzle.getFieldValue(getX() + 1, getY());
                                fifteenPuzzle.setFieldValue(getX(), getY(), buffer);
                                fifteenPuzzle.setFieldValue(getX() + 1, getY(), 0);
                                this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "R", this.getX() + 1, this.getY(), fifteenPuzzle, permutation,repeat));
                                this.children.clear();
                                fifteenPuzzle.setFieldValue(getX() + 1, getY(), buffer);
                                fifteenPuzzle.setFieldValue(getX(), getY(), 0);
                            }
                            break;
                        case 'U':
                            if (this.canMoveUp() && !this.getMoveOrder().endsWith("D")) {
                                Integer buffer = fifteenPuzzle.getFieldValue(getX(), getY() - 1);
                                fifteenPuzzle.setFieldValue(getX(), getY(), buffer);
                                fifteenPuzzle.setFieldValue(getX(), getY() - 1, 0);
                                this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "U", this.getX(), this.getY() - 1, fifteenPuzzle, permutation,repeat));
                                this.children.clear();
                                fifteenPuzzle.setFieldValue(getX(), getY() - 1, buffer);
                                fifteenPuzzle.setFieldValue(getX(), getY(), 0);
                            }
                        case 'D':
                            if (this.canMoveDown() && !this.getMoveOrder().endsWith("U")) {
                                Integer buffer = fifteenPuzzle.getFieldValue(getX(), getY() + 1);
                                fifteenPuzzle.setFieldValue(getX(), getY(), buffer);
                                fifteenPuzzle.setFieldValue(getX(), getY() + 1, 0);
                                this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "D", this.getX(), this.getY() + 1, fifteenPuzzle, permutation,repeat));
                                this.children.clear();
                                fifteenPuzzle.setFieldValue(getX(), getY() + 1, buffer);
                                fifteenPuzzle.setFieldValue(getX(), getY(), 0);
                            }
                    }
                }
        }

    }


    public boolean canMoveLeft(){
        if (getX() > 0) {
            return true;
        }
        return false;
    }
    public boolean canMoveRight(){
        if (getX() < this.getCurrentBoard().getBoardWidth() - 1) {
            return true;
        }
        return false;
    }
    public boolean canMoveUp(){
        if (getY() > 0) {
            return true;
        }
        return false;
    }
    public boolean canMoveDown(){
        if (getY() < this.getCurrentBoard().getBoardHeight() - 1) {
            return true;
        }
        return false;
    }

    public int getCurrentDepth() {

        return currentDepth;
    }

    public int getMaxDepth() {
        return maxDepth;
    }



    public String getMoveOrder() {
        return moveOrder;
    }

    public void addMove(String moveOrder,String direction) {
        this.moveOrder = moveOrder + direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public FifteenPuzzle getCurrentBoard() {
        return currentBoard;
    }

    public void setCurrentBoard(FifteenPuzzle currentBoard) {
        this.currentBoard = currentBoard;
    }

    public Vector<GameNode> getChildren() {
        return children;
    }

    public boolean isSolvedFlag() {
        return solvedFlag;
    }

    public String getSolution() {
        return solution;
    }
    public int getVisited() {
        return visited;
    }
    public int getProcessed() {
        return processed;
    }
    public void reset() {
        solution = null;
        solvedFlag = false;
        visited = 0;
        processed = 0;
        maxReachedDepth = 0;
    }
}
