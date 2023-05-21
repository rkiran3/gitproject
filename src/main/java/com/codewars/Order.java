package com.codewars;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Your task is to sort a given string. Each word in the string will contain a
 * single number. This number is the position the word should have in the result.
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 * If the input string is empty, return an empty string. The words in the input
 * String will only contain valid consecutive numbers.
 * Examples
 * "is2 Thi1s T4est 3a" --> "Thi1s is2 3a T4est"
 * "4of Fo1r pe6ople g3ood th5e the2" --> "Fo1r the2 g3ood 4of th5e pe6ople"
 * "" --> ""
 */

public class Order {

  /**
   * Function to convert input.
   *
   * @param words sentence to be converted.
   * 
   * @return converted string.
   */
  public static String convert(String words) {
    String outStr = "";

    // extract index contained in each word
    Pattern pattern = Pattern.compile("(\\d+)");

    if (words != null && words.length() > 0) {
      // split sentence to words
      String[] tokens = words.split("\\s");

      if (tokens != null && tokens.length > 0) {
        String[] outArr = new String[tokens.length];

        for (String token : tokens) {
          Matcher matcher = pattern.matcher(token);
          if (matcher.find()) {
            String index = matcher.group(0);
            outArr[Integer.valueOf(index) - 1] = token;
          }
        }

        outStr = Arrays.asList(outArr).stream()
            .collect(Collectors.joining(" "));
      }
    }
    return outStr;
  }

  /**
   * Main program.
   *
   */
  public static void main(String[] args) {
    System.out.println("[" + Order.convert("is2 Thi1s T4est 3a") + "]");
    System.out.println(Order.convert("4of Fo1r pe6ople g3ood th5e the2"));
    System.out.println("[" + Order.convert("") + "]");
  }
}
