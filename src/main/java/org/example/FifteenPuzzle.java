package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FifteenPuzzle {
    private final Integer boardWidth;

    private final Integer boardHeight;


    private int[][] board;

    //Najpierw liczba kolumn, potem wiersze
    public FifteenPuzzle(String fileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        String[] numbers = content.split("[\\s\\n]+");
        this.boardWidth = Integer.parseInt(numbers[0]);
        this.boardHeight = Integer.parseInt(numbers[1]);
        this.board = new int[boardWidth][boardHeight];
        for (Integer i = 0; i < boardHeight; i++) {
            for (Integer j = 0; j < boardWidth; j++) {
                board[j][i] = Integer.parseInt(numbers[2 + j + i * boardHeight]);
            }
        }
    }

    public Integer getFieldValue(Integer x, Integer y) {
        return board[x][y];
    }

    public void setFieldValue(Integer x, Integer y, Integer value) {
        board[x][y] = value;
    }

    public int[] findValue(int value) {
        int[] cord = new int[2];
        for (Integer y = 0; y < boardHeight; y++) {
            for (Integer x = 0; x < boardWidth; x++) {
                if (board[x][y] == value) {
                    cord[0] = x;
                    cord[1] = y;
                    return cord;
                }
            }
        }
        return cord;
    }

    public boolean checkBoard() {
        if (board[getBoardWidth() - 1][getBoardHeight() - 1] != 0) {
            return false;
        }
        int correctPlace = 1;
        for (int y = 0 ; y< getBoardHeight(); y++) {
            for (int x = 0; x < getBoardWidth(); x++) {
                if (correctPlace == 16) {
                    correctPlace = 0;
                }
                if (getFieldValue(x, y) != correctPlace) {
                    return false;
                }
                correctPlace++;
            }
        }
        return true;
    }

    public Integer getBoardWidth() {
        return boardWidth;
    }

    public Integer getBoardHeight() {
        return boardHeight;
    }
}
