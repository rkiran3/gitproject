package com.sandbox;

/**
 *
 */
public class MaxSubarray {
    private static int max ( int x, int y) {
        int max = x > y ? x : y;

        return max;
    }

    public static void main(String [] args) {
        int [] numbers = { -1, 2, 4, -3, 5, 2, -5, 2};

        int best = 0, sum = 0;
        for (int k=0; k < numbers.length; k++) {

            sum = max(numbers[k], sum+numbers[k]);
            best = max(best, sum);
            System.out.println("best: " + best);
        }

        System.out.println("Best: " + best);
    }
}
