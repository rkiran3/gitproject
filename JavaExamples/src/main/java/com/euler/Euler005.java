package com.euler;

import java.util.HashMap;
import java.util.Map;

/**
 *
 2520 is the smallest number that can be divided by each
 of the numbers from 1 to 10 without any remainder.
 What is the smallest positive number that is evenly
 divisible by all of the numbers from 1 to 20?
 */
public class Euler005 {
    public static void main(String [] args) {
        long max = 999999999;
        int maxIndex = 10;
        long startTime = System.currentTimeMillis();
        for (int i = 1; i< max; i++) {
            //System.out.println("Processing " + i);
            Map<Integer, Boolean> resultsMap = new HashMap<Integer, Boolean>();
            /* integer is divisible by all 1..10 */
            resultsMap.put(i, true);
            for (int y=1; y <= 20; y++){
                if ( i%y != 0 ) {
                    resultsMap.put(i, false);
                    break;
                }
            }
            if (resultsMap.get(i)) {
                System.out.println(i + " is Divisible by all numbers 1..10 ");
                break;
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }
}
