package org.example;

import java.util.Vector;

public class GameNode {
    private final int currentDepth;
    private int maxDepth;

    private final int x;

    private final int y;
    private Vector<GameNode> children = new Vector<>();

    private String moveOrder = "";

    //first parent node constructor
    public GameNode(int maxDepth,FifteenPuzzle fifteenPuzzle) {
        this.x = fifteenPuzzle.findZero()[0];
        this.y = fifteenPuzzle.findZero()[1];
        this.maxDepth = maxDepth;
        this.currentDepth = 0;
        new GameNode(getCurrentDepth() + 1,getMaxDepth(),getMoveOrder(),getX(),getY(),fifteenPuzzle);
    }
    //children and the following parents constructor
    public GameNode(int followingDepth,int maxDepth,String order,int x,int y,FifteenPuzzle fifteenPuzzle) {
        FifteenPuzzle puzzleCopy = (FifteenPuzzle) fifteenPuzzle.clone();
        this.x = x;
        this.y = y;
        this.maxDepth = maxDepth;
        this.currentDepth = followingDepth;
        if(getCurrentDepth() < getMaxDepth()) {
            new GameNode(this.getCurrentDepth() + 1,getMaxDepth(),getMoveOrder(),getX(),getY(),puzzleCopy);
        }


    }


    public boolean moveLeft(){
        return true;
    }
    public boolean moveRight(){
        return true;
    }
    public boolean moveUp(){
        return true;
    }
    public boolean moveDown(){
        return true;
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
}
