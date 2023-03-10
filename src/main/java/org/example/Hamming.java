package org.example;

public class Hamming implements Heuristic{
    @Override
    public int calculateHeuristic(FifteenPuzzle fifteenPuzzle) {
        int counter = 0;
        int correctPlace = 1;
        for (int y = 0 ; y< fifteenPuzzle.getBoardHeight(); y++) {
            for (int x = 0; x< fifteenPuzzle.getBoardWidth(); x++) {
                if(correctPlace == 16) {
                    correctPlace = 0;
                }
                if (fifteenPuzzle.getFieldValue(x,y) != correctPlace) {
                    counter++;
                }
                correctPlace++;
            }
        }
        return counter;
    }
}
