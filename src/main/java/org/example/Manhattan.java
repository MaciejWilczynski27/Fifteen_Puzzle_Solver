package org.example;

public class Manhattan implements Heuristic{
    @Override
    public int calculateHeuristic(FifteenPuzzle fifteenPuzzle) {
        int counter = 0;
        int correctPlace = 1;
        int[] coordinates;
        for (int y = 0 ; y< fifteenPuzzle.getBoardHeight(); y++) {
            for (int x = 0; x< fifteenPuzzle.getBoardWidth(); x++) {
                if(x == fifteenPuzzle.getBoardWidth() - 1 && y == fifteenPuzzle.getBoardHeight() - 1) {
                    coordinates = fifteenPuzzle.findValue(0);
                    counter += Math.abs(x - coordinates[0]) + Math.abs(y - coordinates[1]);
                } else {
                    coordinates = fifteenPuzzle.findValue(correctPlace);
                    counter += Math.abs(x - coordinates[0]) + Math.abs(y - coordinates[1]);
                    correctPlace++;
                }

            }
        }
        return counter;
    }
}
