package com.leetcode;

import junit.framework.TestCase;

public class Prob540Test extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void testGetUniqueElement() throws Exception {
        int [] elements = {3,3,7,7,10,11,11};

        assert(10 == Prob540.getUniqueElement(elements));

        int [] newelements = {1,1,2,3,3,4,4,8,8};

        assert(2 == Prob540.getUniqueElement(newelements));

    }
}