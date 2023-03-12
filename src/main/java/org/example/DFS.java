package org.example;

public class DFS {

    private String solution;
    private Integer solutionLength = -1;
    private GameNode gameNode;

    public DFS(int maxDepth, FifteenPuzzle fifteenPuzzle, String permutation) {
        int x = fifteenPuzzle.findValue(0)[0];
        int y = fifteenPuzzle.findValue(0)[1];
        gameNode = new GameNode(0,maxDepth,"",x,y,fifteenPuzzle,permutation,true);
        if(gameNode.isSolvedFlag()) {
            solution = gameNode.getSolution();
            solutionLength = solution.length();
        }
        gameNode.reset();
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
