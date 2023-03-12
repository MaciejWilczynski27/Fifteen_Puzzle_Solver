package org.example;

public class DFS {

    private String solution;
    private Integer solutionLength = -1;
    private GameNode gameNode;
    private int dfsVisited = 0;
    private int dfsProcessed = 0;
    private int dfsMaxDepth = 0;

    public DFS(int maxDepth, FifteenPuzzle fifteenPuzzle, String permutation) {
        int x = fifteenPuzzle.findValue(0)[0];
        int y = fifteenPuzzle.findValue(0)[1];
        gameNode = new GameNode(0,maxDepth,"",x,y,fifteenPuzzle,permutation,true);
        if(gameNode.isSolvedFlag()) {
            solution = gameNode.getSolution();
            solutionLength = solution.length();
        }
        dfsVisited = gameNode.getVisited();
        dfsProcessed = gameNode.getProcessed();
        dfsMaxDepth = gameNode.getMaxDepth();
        gameNode.reset();
    }



    public String getSolution() {
        return solution;
    }


    public int getSolutionLength() {
        return solutionLength;
    }


    public int getDfsVisited() {
        return dfsVisited;
    }

    public int getDfsProcessed() {
        return dfsProcessed;
    }

    public int getDfsMaxDepth() {
        return dfsMaxDepth;
    }
}
