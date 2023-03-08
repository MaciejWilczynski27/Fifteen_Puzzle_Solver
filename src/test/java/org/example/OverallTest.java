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
        GameNode gameNode = new GameNode(5,fifteenPuzzle1,"RUDL");
        System.out.println(gameNode.getMoveOrder());
    }
}
