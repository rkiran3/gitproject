package com.sandbox;

import junit.framework.TestCase;

public class RegexDemoTest extends TestCase {

    public void testPrependLeadingZeros() throws Exception {
        String pattern = "(\\p{Alpha}+)(\\d+)";
        // Split the input word into Alpha and Numeric characters,
        // then prepend 000's to the numeric and make it total of 10 characters.
        String input = "AAA567";
        String output = RegexDemo.prependLeadingZeros(pattern, input);
        assert(output.equals("AAA0000567"));
    }



}