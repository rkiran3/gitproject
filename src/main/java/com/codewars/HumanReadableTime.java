package com.codewars;

/** Construct a human readable time using seconds. */
public class HumanReadableTime {

  /** Given seconds, return a string that depicts the seconds. */
  public static String makeReadable2(int input) {

    long secs = (input % 60);
    long mins = (input / 60);
    long hrs = input / (60 * 60);
    long mmins = mins % 60;

    String message = String.format("Secs: %03d  %02d:%02d:%02d", input, hrs, mmins, secs);

    System.out.println(message);

    return Integer.toString(input);
  }

  /** Given seconds, return a string that depicts the seconds. */
  public static String makeReadable(int input) {

    int secs = 60;
    long mins = 59 * 59;
    
    long ssecs = (input % secs);
    long mmins = (input / mins);
    // long minsMod = (input % MINS);
    long hhrs = 0;

    if (mmins <= 60) {
      String message = String.format("Secs: %2d  %02d:%02d:%02d", input, hhrs, mmins, ssecs);
      System.out.println(message);
    } else {
      // secs = mins % SECS;
      mmins = mins % secs;
      hhrs = mins % 60;
      String message = String.format("Secs: %2d  %02d:%02d:%02d", input, hhrs, mins, ssecs);
      System.out.println(message);
    }

    return Integer.toString(input);
  }

  /** Main Program. */
  public static void main(String[] args) {

    for (int i = 0; i <= 60; i++) {
      makeReadable2(i);
    }
  }
}
