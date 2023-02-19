package com.codewars;

import junit.framework.TestCase;

public class FindOddTest extends TestCase {

    public void testFindOdd() throws Exception {
        int[] numsArray = { 20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5 };
        int oddNum = FindOdd.findIt(numsArray);
        assertEquals(oddNum, 5);

        oddNum = FindOdd.findItStreams(numsArray);
        assertEquals(oddNum, 5);
    }

    public void testFindOdd2() throws Exception {
        int[] numsArray = { 1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5 };
        int oddNum = FindOdd.findIt(numsArray);
        assertEquals(oddNum, -1);

        oddNum = FindOdd.findItStreams(numsArray);
        assertEquals(oddNum, -1);
    }

    public void testFindOddStreams() throws Exception {
        int[] numsArray = { 20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5 };
        int oddNum = FindOdd.findItStreams(numsArray);
        assertEquals(oddNum, 5);
    }

    public void testFindOddStreams2() throws Exception {
        assertEquals(5, FindOdd.findIt(new int[] { 20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5 }));
        assertEquals(-1, FindOdd.findIt(new int[] { 1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5 }));
        assertEquals(5, FindOdd.findIt(new int[] { 20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5 }));
        assertEquals(10, FindOdd.findIt(new int[] { 10 }));
        assertEquals(10, FindOdd.findIt(new int[] { 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1 }));
        assertEquals(1, FindOdd.findIt(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10 }));

        assertEquals(5, FindOdd.findItStreams(new int[] { 20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5 }));
        assertEquals(-1, FindOdd.findItStreams(new int[] { 1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5 }));
        assertEquals(5, FindOdd.findItStreams(new int[] { 20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5 }));
        assertEquals(10, FindOdd.findItStreams(new int[] { 10 }));
        assertEquals(10, FindOdd.findItStreams(new int[] { 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1 }));
        assertEquals(1, FindOdd.findItStreams(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10 }));

    }
}