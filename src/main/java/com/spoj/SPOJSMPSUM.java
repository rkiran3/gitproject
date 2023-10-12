package com.spoj;

import java.util.stream.IntStream;
/**
 *
 *  Please compute the sum of squares for the given numbers: a, a+1, ..., b-1, b.
 *
 */
public class SPOJSMPSUM {

    public static int totalSum(int start, int end){
        /* Using Streams and Ranges */
        IntStream intStream = IntStream.rangeClosed(5, 6);
        int totalSum = intStream.map(i-> i*i).sum();

        return totalSum;
    }

    public static void main(String[] args) {
        int total=0;
        int start = 5;
        int end = 6;
        /* conventional accumulate of totals */
        for (int i=start; i <=end; i++) {
            total+= (i*i);
        }
        System.out.println("total: "+ total);

        /* Using Streams and Ranges */
        IntStream intStream = IntStream.rangeClosed(5, 6);
        int totalSum = intStream.map(i-> i*i).sum();
        System.out.println("total = " + totalSum);
    }
}
