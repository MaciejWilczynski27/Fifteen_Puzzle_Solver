package org.example;

public class DFS {
    private String solution;

    private int solutionLength = -1;
    private GameNode gameNode;

    public DFS(int maxDepth, FifteenPuzzle fifteenPuzzle, String permutation) {
        gameNode = new GameNode(maxDepth,fifteenPuzzle,permutation);
    }

    public void findSolution() {
        this.explore(gameNode);
    }

    public void explore(GameNode childNode) {
        if(solutionLength == - 1) {
            if (childNode.isCorrect()) {
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
