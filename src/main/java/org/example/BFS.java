package org.example;


public class BFS {
    private String solution;

    private int solutionLength = -1;
    private int bfsVisited = 0;
    private int bfsProcessed = 0;
    private int bfsMaxDepth = 0;
    private GameNode gameNode;

    public BFS(int maxDepth, FifteenPuzzle fifteenPuzzle, String permutation) {
        int x = fifteenPuzzle.findValue(0)[0];
        int y = fifteenPuzzle.findValue(0)[1];
        for (int i = 0; i <=maxDepth; i++){
            gameNode = new GameNode(0, i, "", x, y, fifteenPuzzle, permutation,false);
           // System.out.println(i);
           // System.out.println(gameNode.getMaxDepth());
            if (gameNode.isSolvedFlag()) {
                this.solution = gameNode.getSolution();
                solutionLength = solution.length();
                break;
        }
            bfsVisited = gameNode.getVisited();
            bfsProcessed = gameNode.getProcessed();
            bfsMaxDepth = gameNode.getMaxDepth();
            gameNode.reset();
    }
    }




    public String getSolution() {
        return solution;
    }


    public int getSolutionLength() {
        return solutionLength;
    }


    public int getBfsVisited() {
        return bfsVisited;
    }

    public int getBfsProcessed() {
        return bfsProcessed;
    }

    public int getBfsMaxDepth() {
        return bfsMaxDepth;
    }
}

