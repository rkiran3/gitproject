package com.leetcode;

/*
You are given an array of positive and negative integers.
If a number n at an index is positive, then move forward n steps.
Conversely, if it's negative (-n), move backward n steps.
Assume the first element of the array is forward next to
the last element, and the last element is backward next to
the first element.
Determine if there is a loop in this array.
A loop starts and ends at a particular index with more
than 1 element along the loop.
The loop must be "forward" or "backward'.

Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0 -> 2 -> 3 -> 0.

Example 2: Given the array [-1, 2], there is no loop.

Note: The given array is guaranteed to contain no element "0".
 */
public class Prob457CircularArray {

    public static void main(String[] args) {
        int [] intArray = { 2, -1, 1, 2, 2 };

        boolean overflow = false;  // flag to indicate if loop overflows
        int index = 0;

        // loop while within range.
        while (index < intArray.length && !overflow) {
            System.out.printf("[%d] = says Jump %d indices \n",
                    index, intArray[index]);
            int jumpIndex = intArray[index];
            index = index + jumpIndex;
            // print the array after rotating once
            if (index >= intArray.length) {
                // reset the index to start again
                index = 0;

                System.out.printf("Overflow [%d] = %d  \n",
                        index, intArray[index]);
                overflow = true;
            }
        }
    }
}
