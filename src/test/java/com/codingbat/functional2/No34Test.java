package com.codingbat.functional2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class No34Test {
    @Test
    public void testFilterInput() {
        
        String[] input = {"a", "bb", "ccc"};
        String[] expected = {"a", "bb"};
        String[] output = No34.filterInput(input);

        assertEquals(Arrays.asList(output), Arrays.asList(expected));
    }

    @Test
    public void testFilterInput2() {
        
        String[] input = {"a", "bb", "ccc", "dddd"};
        String[] expected = {"a", "bb"};
        String[] output = No34.filterInput(input);
        assertEquals(Arrays.asList(output), Arrays.asList(expected));
    }
}
