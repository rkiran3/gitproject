package com.sandbox;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.math.BigDecimal;
import java.util.Random;

public class ProrationDemoTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ProrationDemoTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ProrationDemoTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testProrationDemo()
    {
        // Expect total discounts of 49.00
        BigDecimal bd = new BigDecimal(49).setScale(2);
        int [] intpool = new int [5];
        int max=50, min=1;
        for (int i=0; i<5; i++) {
            intpool[i] = new Random().nextInt((max - min) + 1) + min;
        }
        BigDecimal output = ProrationDemo.getDiscounts(intpool, 49.00);
        assertEquals(bd, output);

        // Expect total discounts of 69.00
        bd = new BigDecimal(69).setScale(2);
        for (int i=0; i<5; i++) {
            intpool[i] = new Random().nextInt((max - min) + 1) + min;
        }
        output = ProrationDemo.getDiscounts(intpool, 69.00);
        assertEquals(bd, output);
    }
}
