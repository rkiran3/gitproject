package com.codewars;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class KataTest {
    @Test
    public void testCreatePhoneNumber() {
        String output = Kata.createPhoneNumber(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 });
        assertEquals("(123) 456-7890", output);
    }

    @Test
    public void testCreatePhoneNumberV2() {
        String output = Kata.createPhoneNumberV2(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 });
        assertEquals("(123) 456-7890", output);
    }

    @Test
    public void testValidPhoneNumber1() {
        assertTrue(Kata.validPhoneNumber("(123) 456-7890"));
    }

    @Test
    public void testValidPhoneNumber2() {
        assertFalse(Kata.validPhoneNumber("(1111)555 2345"));
    }

    @Test
    public void testValidPhoneNumber3() {
        assertFalse(Kata.validPhoneNumber("(098) 123 4567"));
    }
}
