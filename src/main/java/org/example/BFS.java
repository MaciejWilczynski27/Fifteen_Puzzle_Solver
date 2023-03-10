package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class BFS {
    private String solution;

    private Integer solutionLength = -1;
    private GameNode gameNode;

    public BFS(int maxDepth, FifteenPuzzle fifteenPuzzle, String permutation) {
        gameNode = new GameNode(maxDepth,fifteenPuzzle,permutation);
    }
    public void findSolution() {
       for (int i = 0; i <= gameNode.getMaxDepth(); i++) {
           this.explore(i,gameNode);
           }
       }

    public void explore(int i,GameNode childNode) {
        if(solutionLength == - 1) {
            if (childNode.getCurrentDepth() == 0 && childNode.isCorrect()) {
                this.setSolution(childNode.getMoveOrder());
                this.setSolutionLength();
                return;
            }
            for (GameNode child : childNode.getChildren()) {
                if (child.getCurrentDepth() >= i && child.isCorrect()) {
                    this.setSolution(child.getMoveOrder());
                    this.setSolutionLength();
                }
                explore(i, child);
            }
        }
        else return;
    }



    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public int getSolutionLength() {
        return solutionLength;
    }

    public void setSolutionLength() {
        this.solutionLength = solution.length();
    }
}
