package com.ctci;

import java.util.ArrayList;

/**
 *
 */
public class PerformPermutation {

    public static ArrayList<String> getPerms(String s) {
        ArrayList <String> permutationsList = new ArrayList<String>();
        if (s == null) { // error case
            return null;
        } else if (s.length() == 0 ) {
            permutationsList.add("");
            return permutationsList;
        }

        char first = s.charAt(0); // get the first character
        String remainder = s.substring(1); // remove first character

        ArrayList <String> words = getPerms(remainder);

        for (String word : words) {
            for (int j=0; j <= word.length(); j++) {
                permutationsList.add(insertCharAt(word, first, j));
            }
        }
        return permutationsList;
    }

    public static String insertCharAt(String word, char c, int index) {
        String start = word.substring(0, index);
        String end  = word.substring(index);

        return start + c + end;
    }

    public static void main(String [] args){
        ArrayList <String> words = getPerms("ABC");

        words.forEach(token -> System.out.printf("%s ", token));
        System.out.println("");
        for (String word: words) {
            System.out.print(word + " ");
        }
    }
}
