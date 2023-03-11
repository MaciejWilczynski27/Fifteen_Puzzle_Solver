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
    }

    public void findSolution() {
        this.explore(gameNode);
    }

    public void explore(GameNode childNode) {
        if(solutionLength == - 1) {
            if (childNode.isCorrect()) {
                this.setSolution(childNode.getMoveOrder());
                this.setSolutionLength();
                return;
            }
            for (GameNode child : childNode.getChildren()) {
                if (child.isCorrect()) {
                    this.setSolution(child.getMoveOrder());
                    this.setSolutionLength();
                }
                explore(child);
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
