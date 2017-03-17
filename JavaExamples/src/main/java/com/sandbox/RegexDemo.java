package com.sandbox;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ravikir on 3/8/2017.
 */
public class RegexDemo {

    public static String replaceSpaces(String pattern, String input){
        String output = "";

        if ((pattern != null && pattern.length() > 0) &&
                (input != null && input.length() > 0)) {
            output = input.replaceAll(pattern, "");
        }

        return output;
    }

    public static String prependLeadingZeros(String pattern, String input){
        String output="";

        if ((pattern != null && pattern.length() >0) &&
                input != null && input.length() > 0) {
            Pattern patternObj = Pattern.compile(pattern);
            Matcher matcher = patternObj.matcher(input);
            if (matcher.matches()) {
                int alphalen = matcher.group(1).length();

                int padlen = 10 - alphalen;
                String formatPattern = "%s%0" + padlen + "d";
                output = String.format(formatPattern, matcher.group(1), Integer.valueOf(matcher.group(2)));
            }
        }
        return output;
    }

    public static void main(String[] args) {

        // Search for alpha characters and digits and split using regex
        String pattern = "(\\p{Alpha}+)(\\d+)";
        // Split the input word into Alpha and Numeric characters,
        // then prepend 000's to the numeric and make it total of 10 characters.
        String input = "AAA567";
        String output = RegexDemo.prependLeadingZeros(pattern, input);
        assert(output.equals("AAA0000567"));

        String spacePattern = "\\s+";  /* one or more spaces */
        String inputStr1 = " This is a sentence    ";
        String expectedStr1 = "Thisisasentence";
        String outputStr1 = replaceSpaces(spacePattern, inputStr1);
        System.out.println(String.format("Input:    [%s]", inputStr1));
        System.out.println(String.format("Output:   [%s]", outputStr1));
        System.out.println(String.format("Expected: [%s]", expectedStr1));
        System.out.println("Output matches expected: " +
                outputStr1.equals(expectedStr1));
    }
}
