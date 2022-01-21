package com.spoj;

import junit.framework.TestCase;

public class PALINTest extends TestCase {

    public void testSmallestPalindrome() throws Exception {

        PALIN palin = new PALIN();
        assert(818 == palin.smallestPalindrome(808));

        assert(2222 == palin.smallestPalindrome(2133));
    }
}