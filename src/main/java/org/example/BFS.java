package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class BFS {
    private String solution;

    private Integer solutionLength = -1;
    private GameNode gameNode;

    public BFS(int maxDepth, FifteenPuzzle fifteenPuzzle, String permutation) {
        int x = fifteenPuzzle.findValue(0)[0];
        int y = fifteenPuzzle.findValue(0)[1];
        for (int i = 0; i <=maxDepth; i++){
            gameNode = new GameNode(0, i, "", x, y, fifteenPuzzle, permutation,false);
            if (gameNode.isSolvedFlag()) {
                solution = gameNode.getSolution();
                solutionLength = solution.length();
                break;
        }
    }
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
