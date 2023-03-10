package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //1 strategia, 2 parametr ,3 nazwa pliku z ktorego ma wczytac, 4 nazwa pliku z rozwiazaniem
        //5 nazwa pliku z dodatkowymi informacjami
        try {
            FifteenPuzzle fifteenPuzzle = new FifteenPuzzle(args[0]);
            DFS dfs = new DFS(17,fifteenPuzzle,"LUDR");
            dfs.findSolution();
            System.out.println(dfs.getSolution());
            fifteenPuzzle.saveSolution("rozwiazanieTest.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(args[0]);

    }
}