package com.sandbox;

import lombok.extern.java.Log;

/**
 * Program will check if provided string has adjacent duplicates of a character.
 * 
 * Input: hasDuplicates(null, 'a')
 * Output: false
 * 
 * Input: hasDuplicates('a', 'a')
 * Output: false
 * 
 * Input: hasDuplicates('aa', 'a')
 * Output: true
 * 
 * Input: hasDuplicates('aa', 'b')
 * Output: true
 * 
 * Input: hasDuplicates('baa', 'b')
 * Output: false
 * 
 */
@Log
public class DuplicateChars {
    
    /**
     * Function to check if string has adjacent duplicates.
     * 
     * @param message
     * @param target character to find if contained in message
     * @return
     */
    public static boolean hasDuplicates(String message, char target) {
        boolean found = false;

        if (message != null && message.length() > 0) {
            char[] tokens = message.toCharArray();
            for (int i=1; i < tokens.length; i++) {
                // find target character and then see if adjacent char is identical.
                if (tokens[i-1] == target && tokens[i-1] == tokens[i]) {
                    log.info("Found adjacent duplicate " + tokens[i]);
                    found = true;
                }
            }
        }
        return found;
    }

    /* Main Driver program  */
    public static void main(String... args) {
        log.info("Begin");

        System.out.println(DuplicateChars.hasDuplicates(null, 'a')); // false
        System.out.println(DuplicateChars.hasDuplicates("", 'a')); // false
        System.out.println(DuplicateChars.hasDuplicates("aa", 'b')); // false
        System.out.println(DuplicateChars.hasDuplicates("baac", 'a')); // false
    }
}
