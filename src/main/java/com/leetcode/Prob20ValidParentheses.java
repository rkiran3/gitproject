package com.leetcode;

import java.util.Stack;
import java.util.logging.Logger;

/**
 * Prob20ValidParentheses.
 */
public class Prob20ValidParentheses {

  public static final Logger logger = Logger.getLogger(Prob20ValidParentheses.class.getName());

  /**
   * Function to check is string is valid.
   *
   * @param s input string
   * 
   * @return boolean
   */
  public static boolean isValid(String s) {
    Stack<Character> charStack = new Stack<>();
    char[] tokens = s.toCharArray();

    for (char c : tokens) {
      if (c == '(') {
        charStack.push(')');
      } else if (c == '{') {
        charStack.push('}');
      } else if (c == '[') {
        charStack.push(']');
      } else if (charStack.isEmpty() || charStack.pop() != c) {
        return false;
      }
    }
    return charStack.isEmpty();
  }

  /**
   * Main Program to test input string.
   *
   * @param args input arguments
   */
  public static void main(String[] args) {
    logger.info("Start");

    String arr = "({[]})";
    System.out.println(Prob20ValidParentheses.isValid(arr)); // true

    arr = "({[]}))"; // mismatched parentheses
    System.out.println(Prob20ValidParentheses.isValid(arr)); // false

    arr = "[({[]})]"; // valid parentheses
    System.out.println(Prob20ValidParentheses.isValid(arr)); // true
  }
}
