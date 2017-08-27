package com.codingbat.ap1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a positive int n, return true if it contains a 1 digit. Note: use % to get the rightmost digit, and / to discard the rightmost digit.

 hasOne(10) → true
 hasOne(22) → false
 hasOne(220) → false
 */
public class HasOne {
    public static boolean hasOne(int n) {
        boolean result = true;
        int val;
        if (n >= 0 && n < 10) {
            val = n;
            result = (val==1);
        } else {
            hasOne(n / 10);
        }
        //String [] frontWords = wordsList.toArray(new String[wordsList.size()]);

        return result;
    }

    public static void main(String [] args) {
        System.out.println(hasOne(110));
    }
}
