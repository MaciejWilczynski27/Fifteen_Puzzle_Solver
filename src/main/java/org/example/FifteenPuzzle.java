package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FifteenPuzzle implements Cloneable{
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
    public int getFieldValue(int x, int y) {
        return board[x][y];
    }
    public void setFieldValue(int x, int y, int value) {
        board[x][y] = value;
    }

    public int[][] getBoard() {
        return board;
    }

    public FifteenPuzzle(FifteenPuzzle fifteenPuzzle) {
        this.boardWidth = fifteenPuzzle.getBoardWidth();
        this.boardHeight = fifteenPuzzle.getBoardHeight();
        this.board = new int[boardWidth][boardHeight];
        for (int y = 0; y < this.getBoardHeight(); y++) {
            for (int x = 0; x < this.getBoardWidth(); x++ ) {
                this.board[x][y] = fifteenPuzzle.getBoard()[x][y];
                }
            }
    }

    @Override
    protected Object clone() {
        return new FifteenPuzzle(this);
    }

    public int[] findZero() {
        int [] cord = new int[2];
        for (int y = 0; y < boardHeight; y++) {
            for (int x = 0; x < boardWidth; x++ ) {
                if(board[x][y] == 0 ) {
                    cord[0] = x;
                    cord[1] = y;
                    return cord;
                }
            }
        }
        return cord;
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

    public boolean checkBoard(){
        if(board[getBoardWidth()-1][getBoardHeight()-1] != 0) {
            return false;
        }
        for(int i = 0; i < getBoardHeight(); i++) {
            for (int j = 0; j < getBoardWidth(); j++) {
                    if(board[j][i] != 1 + j +getBoardWidth() * i) {
                        if(j != getBoardWidth() - 1 && i != getBoardHeight() - 1) {
                            return false;
                        }
                    }

            }
        }
        return true;
    }

    public boolean isNotLeftEdge(int xpos) {
        if(xpos>0) return true;
        return false;
    }

    public boolean isNotRightEdge(int xpos) {
        if(xpos<boardWidth-1) return true;
        return false;
    }

    public boolean isNotUpperEdge(int ypos) {
        if(ypos>0) return true;
        return false;
    }

    public boolean isNotBottomEdge(int ypos) {
        if(ypos<boardHeight-1) return true;
        return false;
    }
    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }
/*
    private void order(String letter) {
        int x = 0;
        int y = 0;

        for(int i=0;i<boardHeight;i++) {
            for(int j=0;j<boardWidth;j++) {
                if(board[j][i]==0) {
                    x=j;
                    y=i;
                }
            }
        }

        switch(letter) {
            case "L":
                //x kolumny ; y wiersze
                if(isNotLeftEdge(x)) {
                    if(isNotRightEdge(x)) {
                        if (board[x - 1][y] > board[x + 1][y]) {
                            board[x][y] = board[x - 1][y];
                            board[x - 1][y] = 0;
                            x--;
                            solution += "L";
                        }
                    } else {
                        board[x][y] = board[x-1][y];
                        board[x-1][y] = 0;
                    }
                }
                break;
            case "R":
                if(isNotRightEdge(x)) {
                    if(isNotLeftEdge(x)) {
                        if (board[x + 1][y] > board[x - 1][y]) {
                            board[x][y] = board[x + 1][y];
                            board[x + 1][y] = 0;
                            x++;
                            solution += "R";
                        }

                    } else {
                        board[x][y] = board[x+1][y];
                        board[x+1][y] = 0;
                    }
                }
                break;
            case "U":
                if(isNotUpperEdge(y)) {
                    if(isNotBottomEdge(y)) {
                        if (board[x][y-1] > board[x][y+1]) {
                            board[x][y] = board[x][y-1];
                            board[x][y-1] = 0;
                            solution += "U";
                        }
                    } else {
                        board[x][y] = board[x][y-1];
                        board[x][y-1] = 0;
                    }
                }
                break;
            case "D":
                if(isNotBottomEdge(y)) {
                    if(isNotUpperEdge(y)) {
                        if (board[x][y+1] > board[x][y-1]) {
                            board[x][y] = board[x][y+1];
                            board[x][y+1] = 0;
                            solution += "D";
                        }
                    } else {
                        board[x][y] = board[x][y+1];
                        board[x][y+1] = 0;
                    }
                }
                break;
        }
        if(solution.length()!= 0) {
            solutionLength = solution.length();
        }

    }


    public void breadthFirstSearch(String condition) {
        print();
        while (!checkBoard()) {
            for (int i = 0; i < condition.length(); i++) {
                switch (condition.charAt(i)) {

                    case 'L':
                        order("L");
                        break;
                    case 'R':
                        order("R");
                        break;
                    case 'U':
                        order("U");
                        break;
                    case 'D':
                        order("D");
                        break;
                }
                print();
            }

        }
    }


    }*/
}
