package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FifteenPuzzle {
    private final int boardWidth;

    private final int boardHeight;


    private int[][] board;
    //Najpierw liczba kolumn, potem wiersze
    public FifteenPuzzle(String fileName) throws IOException {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            String[] numbers = content.split("[\\s\\n]+");
            this.boardWidth = Integer.parseInt(numbers[0]);
            this.boardHeight = Integer.parseInt(numbers[1]);
            this.board = new int[boardWidth][boardHeight];
            for (int i = 0; i < boardHeight; i++) {
                for (int j = 0; j < boardWidth; j++ ) {
                    board[j][i] = Integer.parseInt(numbers[2 + j + i * boardHeight]);
                }
            }
    }
    public void print() {
        String git = "Kolumny: " + getBoardWidth() + " Wiersze " + getBoardHeight() + "\n";
        for (int i = 0; i < boardHeight; i++) {
            git+="\n";
            for (int j = 0; j < boardWidth; j++ ) {
                git+=board[j][i] + " ";
            }
        }
        System.out.println(git);
    }
    public void saveSolution(String fileName) {
        //tu sie potem zateguje
        String solutionString = " Test czy dziala to wgl";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(solutionString);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveStats(String fileName) {
        //tu sie potem zateguje
        String solutionString = " Tu sie te 5 roznych da";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(solutionString);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }
}
