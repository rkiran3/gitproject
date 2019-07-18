package com.ctci;

/**
 * Report if we find a duplicate character in String, 
 * Have a array to store flag at the character's index, if we come across duplicate
 * character, we can check that array index and stop processing.
 */
public class UniqueCharacters {
    public static boolean isUniqueChars(String input) {
        boolean[] charset = new boolean[256];

        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i);
            char charVal = input.charAt(i);
            if (charset[val]) {
                System.out.println("Found duplicate char " + charVal);
                return false;
            }
            charset[val] = true;
        }

        return false;
    }

    public static void main(String[] args) {
        isUniqueChars("testing");

    }
}
