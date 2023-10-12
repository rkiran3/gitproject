package com.codewars;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Program to find odd number in array of elements. */
public class FindOddKata {

  /** Main Program. */
  public static void main(String[] args) {

    // Create a list of elements, there will be one odd number and all others
    // are in even number
    List<Integer> myList = Arrays.asList(1, 1, 2, 3, 3);

    Map<Integer, Long> m = myList.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    for (Map.Entry<Integer, Long> me : m.entrySet()) {
      System.out.println(me.getKey());
      if (me.getValue() % 2 == 1) {
        System.out.println("Found " + me.getKey());
      }
    }
  }
}