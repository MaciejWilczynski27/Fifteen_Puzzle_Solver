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
    public GameNode(int maxDepth,FifteenPuzzle fifteenPuzzle) {
        this.x = fifteenPuzzle.findZero()[0];
        this.y = fifteenPuzzle.findZero()[1];
        this.maxDepth = maxDepth;
        this.currentDepth = 0;
        this.currentBoard = fifteenPuzzle;
        new GameNode(getCurrentDepth() + 1,getMaxDepth(),getMoveOrder(),getX(),getY(),fifteenPuzzle);
    }
    //children and the following parents constructor
    public GameNode(int followingDepth,int maxDepth,String order,int x,int y,FifteenPuzzle fifteenPuzzle) {
        FifteenPuzzle puzzleCopy = (FifteenPuzzle) fifteenPuzzle.clone();
        this.x = x;
        this.y = y;
        this.maxDepth = maxDepth;
        this.currentDepth = followingDepth;
        this.currentBoard = puzzleCopy;
        if(getCurrentDepth() < getMaxDepth()) {
            new GameNode(this.getCurrentDepth() + 1,getMaxDepth(),getMoveOrder(),getX(),getY(),puzzleCopy);
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

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
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
