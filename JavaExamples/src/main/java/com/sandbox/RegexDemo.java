package com.sandbox;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ravikir on 3/8/2017.
 */
public class RegexDemo {

    public static void main(String[] args) {

        // Search for alpha characters and digits and split using regex
        String pattern = "(\\p{Alpha}+)(\\d+)";

        // Example: AA1234 will be split into AA and 1234
        String [] inputArray = { "AA1234", "BBBB22", "345AA"} ;

        Pattern patternObj = Pattern.compile(pattern);
        for (String token : inputArray) {
            Matcher matcher = patternObj.matcher(token);
            if (matcher.matches()) {
                int alphalen = matcher.group(1).length();

                int padlen = 10 - alphalen;
                String formatPattern = "%s%0" + padlen + "d";
                System.out.println(String.format("Input: %s  Output: ["+formatPattern+"]",
                        token, matcher.group(1), Integer.valueOf(matcher.group(2))));
            }
        }
    }
}
