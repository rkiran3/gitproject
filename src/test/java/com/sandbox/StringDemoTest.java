package com.sandbox;

import org.junit.Assert;

import org.junit.Test;

public class StringDemoTest {

    /** Test for null input which should return empty String */
    @Test
    public void testCustomFormat01() {
        Assert.assertEquals("", StringDemo.customFormat(null));
    }

    /** Test for input greater than 7 which should return empty String */
    @Test
    public void testCustomFormat02() {
        Assert.assertEquals("", StringDemo.customFormat("12345678"));
    }
    
    /** Test for input lesser than 7 which should return empty String */
    @Test
    public void testCustomFormat03() {
        Assert.assertEquals("", StringDemo.customFormat("123456"));
    }

    /** Test for input lesser than 7 which should return empty String */
    @Test
    public void testCustomFormat04() {
        Assert.assertEquals("123-4567", StringDemo.customFormat("1234567"));
    }
}
