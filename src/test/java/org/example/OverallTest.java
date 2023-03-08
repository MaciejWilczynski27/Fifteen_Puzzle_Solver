package org.example;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.*;
public class OverallTest {
    @Test
    public void basicTest() throws IOException {
        FifteenPuzzle fifteenPuzzle1 = new FifteenPuzzle("testfile.txt");
        assertFalse(fifteenPuzzle1.checkBoard());
        FifteenPuzzle fifteenPuzzle2 = new FifteenPuzzle("correctfile.txt");
        assertFalse(fifteenPuzzle1.checkBoard());
        assertTrue(fifteenPuzzle2.checkBoard());
       // GameNode gameNode = new GameNode(8,fifteenPuzzle1,"LDUR");
        //System.out.println(gameNode.getMoveOrder());
        BFS bfs = new BFS(16,fifteenPuzzle1,"LRUD");
        bfs.findSolution();
        System.out.println(bfs.getSolution());
        System.out.println(bfs.getSolutionLength());
        DFS dfs = new DFS(15,fifteenPuzzle1,"DURL");
        dfs.findSolution();
        System.out.println(dfs.getSolution());
        System.out.println(dfs.getSolutionLength());
    }
}
