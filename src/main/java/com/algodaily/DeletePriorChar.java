package com.algodaily;

import java.util.ArrayList;
import java.util.List;

/**
 * Delete prior character in a String if "$" is found
 * f$st  =>  st
 * rout$    => rout
 */
public class DeletePriorChar {

  public static void churn() {
    
    java.util.stream.IntStream.range(0, 57)
      .mapToObj(String::valueOf)
      .forEach(i -> new String(i));
    
    return;
  }
  
  /**
   * Function to detect duplicate chars and store them separately
   *
   * @param input
   * @return array of chars without consecutive-duplicate entries
   */
  public static String[] deleteChar(String[] input) {
    // List to hold all the non-$ characters
    List<String> output = new ArrayList<String>();
    int dIndex = 0; // length of result buffer
    
    for (int sIndex=0; sIndex < input.length; sIndex++) {
      // ignore consecutive entries that have a $ in them
      // identify eligible entries and store separately
      if (input[sIndex].equals("$") ||
          ((sIndex+1 < input.length) && input[sIndex+1].equals("$"))) {
        continue;
      }
      
      dIndex++;
      output.add(input[sIndex]);
    }
    
    // convert List to array
    return output.toArray(new String[dIndex]);
  }
  public static void main(String[] args) {
    String[] input = { "f", "$", "s", "t" };
    String[] output = deleteChar(input);

    //churn();
  }
}
