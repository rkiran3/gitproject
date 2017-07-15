package com.leetcode;

import java.util.function.Consumer;

/**
 *
 */
public class Prob461HammingDistance {

    // Find the number of digits that are different between two integers;
    public static int findDifferingCount(int x, int y) {
        String firstStr = Integer.toBinaryString(x);
        String secondStr = Integer.toBinaryString(y);

        if (firstStr.length() < secondStr.length()) {
            String formatSpecifier = "%0" + secondStr.length() + "d";
            firstStr = String.format(formatSpecifier, Integer.parseInt(firstStr));
            System.out.println(firstStr);
        }

        if (secondStr.length() > firstStr.length()) {
            String formatSpecifier = "%0" + firstStr.length() + "d";
            secondStr = String.format(formatSpecifier, Integer.parseInt(secondStr));
            System.out.println(secondStr);
        }
        System.out.println("FirstStr: " + firstStr + " SecondStr: " + secondStr);

        int differCount = 0;
        for (int i=0; i < firstStr.length(); i++ ) {
            if (firstStr.charAt(i) != secondStr.charAt(i)) {
                differCount++;
            }
        }

        System.out.println("DifferCount = " + differCount);
        return differCount;
    }

    public static void main(String [] args) {
        System.out.println(findDifferingCount(1, 22));
    }
}
