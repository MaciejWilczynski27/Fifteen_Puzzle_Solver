package org.example;

import java.util.Vector;

public class GameNode {
    private final int currentDepth;
    private int maxDepth;

    private int x;

    private int y;

    private FifteenPuzzle currentBoard;
    private Vector<GameNode> children = new Vector<>();

    private String moveOrder = "";

    //first parent node constructor
    public GameNode(int maxDepth,FifteenPuzzle fifteenPuzzle,String permutation) {
        this.x = fifteenPuzzle.findZero()[0];
        this.y = fifteenPuzzle.findZero()[1];
        this.maxDepth = maxDepth;
        this.currentDepth = 0;
        this.currentBoard = fifteenPuzzle;
        System.out.println(this.currentDepth);
        System.out.println(this.getMoveOrder());
        this.currentBoard.print();
        for (int i = 0; i < permutation.length(); i++) {
            switch (permutation.charAt(i)) {
                case 'L':
                    if(this.moveLeft() && !this.getMoveOrder().endsWith("R")) {
                        FifteenPuzzle puzzleCopy = (FifteenPuzzle) fifteenPuzzle.clone();
                        int buffer = puzzleCopy.getFieldValue(getX() - 1 , getY());
                        puzzleCopy.setFieldValue(getX() , getY(),buffer);
                        puzzleCopy.setFieldValue(getX() - 1,getY(),0);
                        this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "L", this.getX() -  1, this.getY(), puzzleCopy, permutation));
                    }
                    break;
                case 'R':
                    if(this.moveRight() && !this.getMoveOrder().endsWith("L")) {
                        FifteenPuzzle puzzleCopy = (FifteenPuzzle) fifteenPuzzle.clone();
                        int buffer = puzzleCopy.getFieldValue(getX() + 1 , getY());
                        puzzleCopy.setFieldValue(getX() , getY(),buffer);
                        puzzleCopy.setFieldValue(getX() + 1,getY(),0);
                        this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "R", this.getX() + 1, this.getY(), puzzleCopy, permutation));
                    }
                    break;
                case 'U':
                    if(this.moveUp() && !this.getMoveOrder().endsWith("D")) {
                        FifteenPuzzle puzzleCopy = (FifteenPuzzle) fifteenPuzzle.clone();
                        int buffer = puzzleCopy.getFieldValue(getX() , getY() - 1);
                        puzzleCopy.setFieldValue(getX() , getY(),buffer);
                        puzzleCopy.setFieldValue(getX(),getY() - 1,0);
                        this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "U", this.getX(), this.getY() - 1, puzzleCopy, permutation));
                    }
                case 'D':
                    if(this.moveDown()&& !this.getMoveOrder().endsWith("U")) {
                        FifteenPuzzle puzzleCopy = (FifteenPuzzle) fifteenPuzzle.clone();
                        int buffer = puzzleCopy.getFieldValue(getX() , getY() + 1);
                        puzzleCopy.setFieldValue(getX() , getY(),buffer);
                        puzzleCopy.setFieldValue(getX(),getY() + 1,0);
                        this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "D", this.getX(), this.getY() + 1, puzzleCopy, permutation));
                    }
            }
        }
    }
    //children and the following parents constructor
    public GameNode(int followingDepth,int maxDepth,String order,int x,int y,FifteenPuzzle fifteenPuzzle,String permutation) {
        this.x = x;
        this.y = y;
        this.maxDepth = maxDepth;
        this.currentDepth = followingDepth;
        this.currentBoard = fifteenPuzzle;
        this.moveOrder = order;
        System.out.println(this.currentDepth);
        System.out.println(this.getMoveOrder());
        System.out.println(this.getMoveOrder().endsWith("R"));
        this.getCurrentBoard().print();
        if(getCurrentDepth() < getMaxDepth()) {
            for (int i = 0; i < permutation.length(); i++) {
                switch (permutation.charAt(i)) {
                    case 'L':
                        if(this.moveLeft() && !this.getMoveOrder().endsWith("R")) {
                            FifteenPuzzle puzzleCopy = (FifteenPuzzle) fifteenPuzzle.clone();
                            int buffer = puzzleCopy.getFieldValue(getX() - 1 , getY());
                            puzzleCopy.setFieldValue(getX() , getY(),buffer);
                            puzzleCopy.setFieldValue(getX() - 1,getY(),0);
                            this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "L", this.getX() -  1, this.getY(), puzzleCopy, permutation));
                        }
                        break;
                    case 'R':
                        if(this.moveRight() && !this.getMoveOrder().endsWith("L")) {
                            FifteenPuzzle puzzleCopy = (FifteenPuzzle) fifteenPuzzle.clone();
                            int buffer = puzzleCopy.getFieldValue(getX() + 1 , getY());
                            puzzleCopy.setFieldValue(getX() , getY(),buffer);
                            puzzleCopy.setFieldValue(getX() + 1,getY(),0);
                        this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "R", this.getX() + 1, this.getY(), puzzleCopy, permutation));
                        }
                        break;
                    case 'U':
                        if(this.moveUp() && !this.getMoveOrder().endsWith("D")) {
                            FifteenPuzzle puzzleCopy = (FifteenPuzzle) fifteenPuzzle.clone();
                            int buffer = puzzleCopy.getFieldValue(getX() , getY() - 1);
                            puzzleCopy.setFieldValue(getX() , getY(),buffer);
                            puzzleCopy.setFieldValue(getX(),getY() - 1,0);
                            this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "U", this.getX(), this.getY() - 1, puzzleCopy, permutation));
                        }
                    case 'D':
                        if(this.moveDown()&& !this.getMoveOrder().endsWith("U")) {
                            FifteenPuzzle puzzleCopy = (FifteenPuzzle) fifteenPuzzle.clone();
                            int buffer = puzzleCopy.getFieldValue(getX() , getY() + 1);
                            puzzleCopy.setFieldValue(getX() , getY(),buffer);
                            puzzleCopy.setFieldValue(getX(),getY() + 1,0);
                            this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "D", this.getX(), this.getY() + 1, puzzleCopy, permutation));
                        }
                }
            }

        }


    }


    public boolean moveLeft(){
        if (getX() > 0) {
            return true;
        }
        return false;
    }
    public boolean moveRight(){
        if (getX() < this.getCurrentBoard().getBoardWidth() - 1) {
            return true;
        }
        return false;
    }
    public boolean moveUp(){
        if (getY() > 0) {
            return true;
        }
        return false;
    }
    public boolean moveDown(){
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
}
