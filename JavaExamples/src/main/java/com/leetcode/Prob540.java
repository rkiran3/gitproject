package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/#/solutions
 Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

 Example 1:

 Input: [1,1,2,3,3,4,4,8,8]
 Output: 2

 Example 2:

 Input: [3,3,7,7,10,11,11]
 Output: 10

 Note: Your solution should run in O(log n) time and O(1) space.
 */
public class Prob540 {

    public static int getUniqueElement(int [] inarray) {
        int uniqueElement = -1;

        for (int i=0 ; i <= inarray.length; i++) {
            if (((i < inarray.length - 2) && inarray[i] != inarray[i+1])) {
                uniqueElement = inarray[i];
            } else {
                i++;
            }
        }

        return uniqueElement;
    }

    public static int singleNonDuplicate(int[] nums) {
        List list = new ArrayList() {
            public int size() {
                return nums.length;
            }
            public Integer get(int index) {
                if ((index ^ 1) < size()
                        && nums[index] == nums[index ^ 1])
                    return -1;
                if ((index == 0) || (index % 2 == 0)
                        && (nums[index - 1] != nums[index]))
                    return 0;
                return 1;
            }
        };

        return nums[Collections.binarySearch(list, 0)];
    }

    public static void main(String [] args) {
        int [] elements = {3,3,7,7,10,11,11};

        System.out.print("Input Array: ");
        Arrays.stream(elements).forEach(n -> System.out.printf("%d ", n));
        System.out.printf("\nUniqueElement: %d\n", singleNonDuplicate(elements));

        int [] newelements = {1,1,2,3,3,4,4,8,8};

        assert(2 == getUniqueElement(newelements));

        System.out.println("Printing XOR");
        for (int i=0; i< 10; i++) {
            System.out.printf("%d:  %d \n", i, i ^ 1);
        }


    }
}
