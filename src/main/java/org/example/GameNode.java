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
        for (int i = 0; i < permutation.length(); i++) {
            switch (permutation.charAt(i)) {
                case 'L':
                    if(this.moveLeft()) {
                        this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "L", this.getX(), this.getY(), fifteenPuzzle, permutation));
                    }
                    break;
                case 'R':
                    if(this.moveRight()) {
                        this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "R", this.getX(), this.getY(), fifteenPuzzle, permutation));
                    }
                    break;
                case 'U':
                    if(this.moveUp()) {
                        this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "U", this.getX(), this.getY(), fifteenPuzzle, permutation));
                    }
                case 'D':
                    if(this.moveDown()) {
                        this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "D", this.getX(), this.getY(), fifteenPuzzle, permutation));
                    }
            }
        }
    }
    //children and the following parents constructor
    public GameNode(int followingDepth,int maxDepth,String order,int x,int y,FifteenPuzzle fifteenPuzzle,String permutation) {
        FifteenPuzzle puzzleCopy = (FifteenPuzzle) fifteenPuzzle.clone();
        this.x = x;
        this.y = y;
        this.maxDepth = maxDepth;
        this.currentDepth = followingDepth;
        this.currentBoard = puzzleCopy;
        this.moveOrder = order;
        System.out.println(this.currentDepth);
        System.out.println(this.getMoveOrder());
        if(getCurrentDepth() < getMaxDepth()) {
            for (int i = 0; i < permutation.length(); i++) {
                switch (permutation.charAt(i)) {
                    case 'L':
                        if(this.moveLeft()) {
                            this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "L", this.getX(), this.getY(), puzzleCopy, permutation));
                        }
                        break;
                    case 'R':
                        if(this.moveRight()) {
                        this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "R", this.getX(), this.getY(), puzzleCopy, permutation));
                        }
                        break;
                    case 'U':
                        if(this.moveUp()) {
                            this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "U", this.getX(), this.getY(), puzzleCopy, permutation));
                        }
                    case 'D':
                        if(this.moveDown()) {
                            this.children.add(new GameNode(this.getCurrentDepth() + 1, this.getMaxDepth(), this.getMoveOrder() + "D", this.getX(), this.getY(), puzzleCopy, permutation));
                        }
                }
            }

        }


    }


    public boolean moveLeft(){
        if (getX() > 0) {
            int buffer = this.getCurrentBoard().getFieldValue(getX() - 1 , getY());
            this.getCurrentBoard().setFieldValue(getX() - 1, getY(),buffer);
            this.getCurrentBoard().setFieldValue(getX(),getY(),0);
            this.setX(getX() - 1);
            return true;
        }
        return false;
    }
    public boolean moveRight(){
        if (getX() < this.getCurrentBoard().getBoardWidth() - 1) {
            int buffer = this.getCurrentBoard().getFieldValue(getX() + 1 , getY());
            this.getCurrentBoard().setFieldValue(getX() + 1, getY(),buffer);
            this.getCurrentBoard().setFieldValue(getX(),getY(),0);
            this.setX(getX() + 1);
            return true;
        }
        return false;
    }
    public boolean moveUp(){
        if (getY() < 0) {
            int buffer = this.getCurrentBoard().getFieldValue(getX() , getY() - 1);
            this.getCurrentBoard().setFieldValue(getX(), getY() - 1,buffer);
            this.getCurrentBoard().setFieldValue(getX(),getY(),0);
            this.setY(getY() - 1);
            return true;
        }
        return false;
    }
    public boolean moveDown(){
        if (getY() < this.getCurrentBoard().getBoardHeight() - 1) {
            int buffer = this.getCurrentBoard().getFieldValue(getX() , getY() + 1);
            this.getCurrentBoard().setFieldValue(getX(), getY() + 1,buffer);
            this.getCurrentBoard().setFieldValue(getX(),getY(),0);
            this.setY(getY() + 1);
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
