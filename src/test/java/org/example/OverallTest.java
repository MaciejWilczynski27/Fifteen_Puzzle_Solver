package org.example;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class OverallTest {
    @Test
    public void basicTest() throws IOException {
        FifteenPuzzle fifteenPuzzle1 = new FifteenPuzzle("testfile.txt");
        FifteenPuzzle fifteenPuzzle2 = new FifteenPuzzle("testfile.txt");
        FifteenPuzzle fifteenPuzzle3 = new FifteenPuzzle("testfile.txt");
        FifteenPuzzle fifteenPuzzle4 = new FifteenPuzzle("testfile.txt");
        AStar aStarHamming = new AStar(fifteenPuzzle1);
        System.out.println("START");
        aStarHamming.findSolution(true);
        System.out.println(aStarHamming.getSolutionLength());
        System.out.println(aStarHamming.getSolution());
        System.out.println("KONIEC H");
        System.out.println("START M");
        AStar aStarHamming2 = new AStar(fifteenPuzzle3);
        aStarHamming2.findSolution(false);
        System.out.println(aStarHamming2.getSolutionLength());
        System.out.println(aStarHamming2.getSolution());
        System.out.println("KONIEC");
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        DFS dfs = new DFS(20,fifteenPuzzle2,"ULRD");
        System.out.println(dfs.getSolution());
        System.out.println("PRZERWA");
        BFS bfs = new BFS(20,fifteenPuzzle4,"DURL");
        System.out.println(bfs.getSolution());
        System.out.println(bfs.getSolutionLength());
    FileManagement fileManagement = new FileManagement();
        System.out.println(stopwatch.stop());
        System.out.println(fileManagement.extraInfoFile(2,5,7,20, stopwatch.stop()));
        fileManagement.saveToFile("staty.txt",fileManagement.extraInfoFile(2,5,7,20, stopwatch.stop()));
       // System.out.println(dfs.getSolution());
        //System.out.println(dfs.getSolutionLength());
    }
}
