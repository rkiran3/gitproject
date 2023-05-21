package com.codewars;

import junit.framework.TestCase;

/**
 * Test program.
 */
public class OrderTest extends TestCase {

  /**
   * Test Function.
   *
   * @throws Exception if unable to process.
   */
  public void testOrder() throws Exception {
    String output = Order.convert("is2 Thi1s T4est 3a");
    assertEquals("Thi1s is2 3a T4est", output);
  }
}
