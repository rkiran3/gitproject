package com.codewars;

/** Construct a human readable time using seconds. */
public class HumanReadableTime {

  /** Given seconds, return a string that depicts the seconds. */
  public static String makeReadable2(int input) {

    long secs = (input % 60);
    long mins = (input / 60);
    long hrs = input / (60 * 60);
    long mmins = mins % 60;

    String timestr = String.format("%02d:%02d:%02d", hrs, mmins, secs);
    return timestr;
  }

  /** Given seconds, return a string that depicts the seconds. */
  public static String makeReadable(int input) {

    int secs = 60;
    long mins = 59 * 59;
    
    long ssecs = (input % secs);
    long mmins = (input / mins);
    // long minsMod = (input % MINS);
    long hhrs = 0;
    String timestr = "";

    if (mmins <= 60) {
      timestr = String.format("%02d:%02d:%02d", hhrs, mmins, ssecs);
    } else {
      // secs = mins % SECS;
      mmins = mins % secs;
      hhrs = mins % 60;
      timestr = String.format("%02d:%02d:%02d", hhrs, mins, ssecs);
    }

    return timestr;
  }

  /** Main Program. */
  public static void main(String[] args) {

    for (int i = 0; i <= 60; i++) {
      makeReadable2(i);
    }
  }
}
