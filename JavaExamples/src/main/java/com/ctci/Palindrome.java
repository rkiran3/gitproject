package com.ctci;

/**
 *
 */
public class Palindrome {
    public static void main(String []args) {
        String words [] = { "Anna","Civic",
                "Kayak",
                "Level",
                "Madam",
                "Mom",                "Noon",
                "Racecar",
                "Radar",
                "Redder",
                "Refer",
                "Repaper",
                "Rotator",
                "Rotor",
                "Sagas",
                "Solos",
                "Stats",
                "Tenet",
                "Wow"};
        for (String word : words) {
            char[] charArray = word.toLowerCase().toCharArray();
            int lI = 0, rI = word.length() - 1;
            boolean isPalindrome = true;
            while (lI <= rI) {
                if (charArray[lI] != charArray[rI]) {
                    isPalindrome = false;
                    break;
                }
                lI++;
                --rI;
            }
            System.out.println(String.format("String: %s is a Palindrome %s", word, isPalindrome));
        }
    }
}
