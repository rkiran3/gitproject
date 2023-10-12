package com.codewars;

import junit.framework.TestCase;

/** Test class. */
public class HumanReadableTimeTest extends TestCase {
  
  /** Test Function. */
  public void testHuman() throws Exception {
    String secs1 = HumanReadableTime.makeReadable(0);
    assertEquals(secs1, "00:00:00");
  }

}
