package com.codewars;

import org.junit.Assert;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class FindOddTest extends TestCase {

    public void testFindOdd() throws Exception {
        int[] numsArray = {20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5};
        int oddNum = FindOdd.findIt(numsArray);
        assertEquals(oddNum, 5);
    }

    public void testFindOdd2() throws Exception {
        int[] numsArray = {1,1,2,-2,5,2,4,4,-1,-2,5};
        int oddNum = FindOdd.findIt(numsArray);
        assertEquals(oddNum, -1);
    }
    
    public void testFindOddStreams() throws Exception {
        int[] numsArray = {20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5};
        int oddNum = FindOdd.findItStreams(numsArray);
        assertEquals(oddNum, 5);
    }

    public void testFindOddStreams2() throws Exception {
        int[] numsArray = {1,1,2,-2,5,2,4,4,-1,-2,5};
        int oddNum = FindOdd.findItStreams(numsArray);
        assertEquals(oddNum, -1);
    }


}