package org.example;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class OverallTest {
    @Test
    public void basicTest() throws IOException {
       // FifteenPuzzle fifteenPuzzle1 = new FifteenPuzzle("testfile.txt");
        //assertFalse(fifteenPuzzle1.checkBoard());
        FifteenPuzzle fifteenPuzzle2 = new FifteenPuzzle("testfile.txt");
      //  assertFalse(fifteenPuzzle1.checkBoard());
       // assertTrue(fifteenPuzzle2.checkBoard());
       // GameNode gameNode = new GameNode(8,fifteenPuzzle1,"LDUR");
      //  AStar aStarHamming = new AStar(fifteenPuzzle1);
      //  System.out.println("START");
      //  aStarHamming.findSolution(true);
      //  System.out.println(aStarHamming.getSolutionLength());
       // System.out.println(aStarHamming.getSolution());
       // System.out.println("KONIEC");
       //Heuristic heuristic = new Hamming();
       //System.out.println(heuristic.calculateHeuristic(fifteenPuzzle1));
        //System.out.println(aStarHamming.calculateManhattan());
        //System.out.println(gameNode.getMoveOrder());
       // BFS bfs = new BFS(10,fifteenPuzzle2,"LRUD");
      //  bfs.findSolution();
       // System.out.println(bfs.getSolution());
       // System.out.println(bfs.getSolutionLength());
        System.out.println(fifteenPuzzle2.checkBoard());
        DFS dfs = new DFS(20,fifteenPuzzle2,"ULRD");
        System.out.println(dfs.getSolution());
        System.out.println("PRZERWA");
        BFS bfs = new BFS(20,fifteenPuzzle2,"LRUD");
        System.out.println(bfs.getSolution());
        System.out.println(bfs.getSolutionLength());
       // System.out.println(dfs.getSolution());
        //System.out.println(dfs.getSolutionLength());
    }
}
