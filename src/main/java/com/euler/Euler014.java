package com.euler;

import java.util.ArrayList;
import java.util.List;

/**
 Longest Collatz sequence
 Problem 14

 The following iterative sequence is defined for the set of positive integers:

 n → n/2 (n is even)
 n → 3n + 1 (n is odd)

 Using the rule above and starting with 13, we generate the following sequence:
 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

 It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

 Which starting number, under one million, produces the longest chain?
 */
public class Euler014 {
    static List<Long> collatzList = new ArrayList<>();

    static void collatz(long num) {
        try {
            collatzList.clear();
            collatzList.add(num);
            while (num != 1) {
                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    num = (num * 3) + 1;
                }
                collatzList.add(num);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    } // collatz ends

    public static void main(String [] args){
        int maxLen = 0;
        long index = 1;
        long startTime = System.currentTimeMillis();
        for (long i=1; i< 9000000; i++) {
            collatz(i);
            if (collatzList.size() >= maxLen) {
                maxLen = collatzList.size();
                index = i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(index + " has longest chain: " + maxLen);
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }
}
