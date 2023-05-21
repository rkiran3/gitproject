package com.codewars;

import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
 * Your task is to make a function that can take any non-negative integer as an
 argument and return it with its digits in descending order. Essentially,
 rearrange the digits to create the highest possible number.  Examples:

 Input: 42145 Output: 54421

 Input: 145263 Output: 654321

 Input: 123456789 Output: 987654321
*/

/**
 * Program to sort input number string.
 */
public class DescendingOrder {

  /**
   * Function to sort number string.
   *
   * @param numString input string
   * @return converted string
   */
  public static String sortDesc(final String numString) {

    // Define Comparator for reverse order
    class IntComparator implements Comparator<Integer> {
      @Override
      public int compare(Integer val1, Integer val2) {
        return val2.compareTo(val1);
      }
    }

    Comparator<Integer> intComparator = new IntComparator();

    String outString = Pattern.compile("").splitAsStream(numString)
        .map(Integer::valueOf) // convert String token to Integer
        .sorted(intComparator::compare) // compare to store in reverse
        .map(String::valueOf) // convert back to String
        .collect(Collectors.joining("")); // combine all tokens to form String

    return outString;
  }

  /**
   * Main Program.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    System.out.println(sortDesc("42145"));
    System.out.println(sortDesc("145263"));
    System.out.println(sortDesc("123456789"));
  }
}
