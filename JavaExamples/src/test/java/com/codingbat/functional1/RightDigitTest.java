package com.codingbat.functional1;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class RightDigitTest extends TestCase {

    public void testRightDigit() throws Exception {
        Integer [] numsArray = { 16, 8, 886, 8, 1 };
        List<Integer> numsList = Arrays.asList(numsArray);
        List <Integer> outputList = RightDigit.rightDigit(numsList);

        Integer[] outArray = {6, 8, 6, 8, 1};
        List <Integer> expectedList = Arrays.asList(outArray);
        Assert.assertEquals(outputList, expectedList);
    }

    public void testRightDigit02() throws Exception {
        Integer [] numsArray = {1, 22, 93 };
        List<Integer> numsList = Arrays.asList(numsArray);
        List <Integer> outputList = RightDigit.rightDigit(numsList);

        Integer[] outArray = {1, 2, 3};
        List <Integer> expectedList = Arrays.asList(outArray);
        Assert.assertEquals(outputList, expectedList);
    }
}