package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Prob17LetterCombination {
    private static Map <Integer, String>phoneRepresentation = new HashMap<Integer, String>();
    static {
        phoneRepresentation.put(1, "--");
        phoneRepresentation.put(2, "abc");
        phoneRepresentation.put(3, "def");
    }
    public static void main(String[]args){
        String val1 = phoneRepresentation.get(2);
        String val2 = phoneRepresentation.get(3);
        char [] val1chars = val1.toCharArray();
        char [] val2chars = val2.toCharArray();

        for (int i=0; i<val1chars.length; i++) {
            for (int j=0; j<val2chars.length; j++) {
                System.out.printf("%2s%-2s\n", val1chars[i], val2chars[j]);
            }
        }
    }
}
