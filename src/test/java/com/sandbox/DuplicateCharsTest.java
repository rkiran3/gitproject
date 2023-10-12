package com.sandbox;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DuplicateCharsTest {
    @Test
    public void testHasDuplicates() {
        assertEquals(false, DuplicateChars.hasDuplicates(null, 'a'));
    }
}
