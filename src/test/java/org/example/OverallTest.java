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
        fifteenPuzzle1.breadthFirstSearch("LRUD");
        System.out.println(fifteenPuzzle1.getSolutionLength());
        System.out.println(fifteenPuzzle1.getSolution());
        assertTrue(fifteenPuzzle1.checkBoard());
        assertTrue(fifteenPuzzle2.checkBoard());
    }
}
