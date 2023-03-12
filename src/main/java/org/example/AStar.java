package org.example;

public class AStar {
    private String solution = "";
    private int solutionLength = -1;
    private int xposition;
    private int yposition;
    private int AStarVisited = 0;
    private int AStarProcessed = 0;
    private int AStarMaxDepth = 0;
    private FifteenPuzzle fifteenPuzzle;

    public AStar(FifteenPuzzle fifteenPuzzle) {
        this.fifteenPuzzle = fifteenPuzzle;
        xposition = fifteenPuzzle.findValue(0)[0];
        yposition = fifteenPuzzle.findValue(0)[1];
    }

//true to hamming, false to manhattan
    public boolean findSolution(boolean option) {
        boolean directionFlag = true;
        Heuristic heuristic;
        if(option) {
            heuristic = new Hamming();
       } else {
            heuristic = new Manhattan();
        }
        while (directionFlag) {
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            int up = Integer.MAX_VALUE;
            int down = Integer.MAX_VALUE;
            if(xposition > 0)
                left = this.explore(0,heuristic);
            if(xposition < this.fifteenPuzzle.getBoardWidth() - 1) {
                right = this.explore(1,heuristic);
            }
            if(yposition > 0)
                up = this.explore(2,heuristic);
            if(yposition < this.fifteenPuzzle.getBoardHeight() - 1) {
                down = this.explore(3,heuristic);
            }
            directionFlag = chooseDirection(left,right,up,down);
        }
        return false;
    }

    public boolean chooseDirection(int left,int right, int up, int down) {
        if(left < right && left < up && left < down) {
            this.moveLeft();
            solution += "L";
            this.AStarMaxDepth++;
            this.AStarVisited++;
            if (left == 0) {
                this.setSolutionLength(solution.length());
                return false;
            }
        }else if(right < left && right < up && right < down) {
           this.moveRight();
           solution +="R";
           this.AStarMaxDepth++;
            this.AStarVisited++;
           if(right == 0) {
               this.setSolutionLength(solution.length());
              return false;
           }
        }else if(up < left && up < right && up < down) {
            this.moveUp();
            solution +="U";
            this.AStarMaxDepth++;
            this.AStarVisited++;
            if(right == 0) {
                this.setSolutionLength(solution.length());
                return false;
            }
        }else if(down < left && down < up && down < up) {
            this.moveDown();
            solution +="D";
            this.AStarMaxDepth++;
            this.AStarVisited++;
            if(right == 0) {
                this.setSolutionLength(solution.length());
                return false;
            }
        } else {
            return false;
        }

        return true;
    }
    //lewo - 0
    //prawo - 1
    //gora - 2
    //dol - 3
    //remis(2 wartosci rowne) - 4
    public int explore(int direction,Heuristic heuristic) {
        int buffer = Integer.MAX_VALUE;
        this.AStarProcessed++;
        switch (direction){
            case 0:
                this.moveLeft();
                buffer = heuristic.calculateHeuristic(this.fifteenPuzzle);
                this.moveRight();
                return buffer;
            case 1:
                this.moveRight();
                buffer = heuristic.calculateHeuristic(this.fifteenPuzzle);
                this.moveLeft();
                return buffer;
            case 2:
                this.moveUp();
                buffer = heuristic.calculateHeuristic(this.fifteenPuzzle);
                this.moveDown();
                return buffer;
            case 3:
                this.moveDown();
                buffer = heuristic.calculateHeuristic(this.fifteenPuzzle);
                this.moveUp();
                return buffer;
        }
        return buffer;
    }

    public void moveLeft() {
        int buffer = this.fifteenPuzzle.getFieldValue(xposition - 1,yposition);
        this.fifteenPuzzle.setFieldValue(xposition,yposition,buffer);
        this.fifteenPuzzle.setFieldValue(xposition - 1,yposition,0);
        this.xposition = this.xposition - 1;

    }
    public void moveRight() {
        int buffer = this.fifteenPuzzle.getFieldValue(xposition + 1,yposition);
        this.fifteenPuzzle.setFieldValue(xposition,yposition,buffer);
        this.fifteenPuzzle.setFieldValue(xposition + 1,yposition,0);
        this.xposition = this.xposition + 1;

    }
    public void moveUp() {
        int buffer = this.fifteenPuzzle.getFieldValue(xposition,yposition - 1);
        this.fifteenPuzzle.setFieldValue(xposition,yposition,buffer);
        this.fifteenPuzzle.setFieldValue(xposition,yposition - 1,0);
        this.yposition = this.yposition - 1;

    }
    public void moveDown() {
        int buffer = this.fifteenPuzzle.getFieldValue(xposition,yposition + 1);
        this.fifteenPuzzle.setFieldValue(xposition,yposition,buffer);
        this.fifteenPuzzle.setFieldValue(xposition,yposition + 1,0);
        this.yposition = this.yposition + 1;

    }

    public void setSolutionLength(int solutionLength) {
        this.solutionLength = solutionLength;
    }

    public String getSolution() {
        return solution;
    }

    public int getSolutionLength() {
        return solutionLength;
    }

    public int getAStarVisited() {
        return AStarVisited;
    }

    public int getAStarProcessed() {
        return AStarProcessed;
    }

    public int getAStarMaxDepth() {
        return AStarMaxDepth;
    }
}
