package com.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DescendingOrderTest {

    @Test
    public void testSortDesc() {
        assertEquals("54421", DescendingOrder.sortDesc("42145"));
    }

    @Test
    public void testSortDesc2() {
        assertEquals("654321", DescendingOrder.sortDesc("145263"));
    }

    @Test
    public void testSortDesc3() {
        assertEquals("987654321", DescendingOrder.sortDesc("123456789"));
    }
}
