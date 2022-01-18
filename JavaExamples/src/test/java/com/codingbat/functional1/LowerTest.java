package com.codingbat.functional1;

import org.junit.Assert;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class LowerTest extends TestCase {

    public void testLower() throws Exception {
        List<String> expectedList = Arrays.asList("hello", "hi");
        List <String> actualList =Lower.lower(Arrays.asList("Hello", "Hi"));
        Assert.assertEquals(actualList, expectedList);
    }

    public void testLower02() throws Exception {
        List<String> expectedList = Arrays.asList("kitten", "chocolate");
        List <String> actualList =Lower.lower(Arrays.asList("KitteN", "ChocolaTE"));
        Assert.assertEquals(actualList, expectedList);
    }
}