package com.spoj;

/**
 * Created by ravikir on 3/9/2017.
 */
public class PALIN {

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    /**
     * Given an input integer, find the next number which is a palindrome,
     * Example: input: 808  iterate to next number which is a palindrome 818
     * @param k
     * @return next number which is Palindrome.
     */
    public int smallestPalindrome(int k) {
        
        boolean found = false;  // initial flag

        if (k > 0) {
            while (!found) {
                k++;
                String numStr = String.valueOf(k);
                // reverse the string and compare with original string
                if (numStr.equals(reverse(numStr))) {
                    found=true;
                    break; // assign the found value
                }
            }
        }
        return k;
    }

    public static void main(String [] args) {
        PALIN palin = new PALIN();
        System.out.println(palin.smallestPalindrome(2133));
    }
}
