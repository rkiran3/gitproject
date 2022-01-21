package com.codingbat.ap1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/*
 * Given two arrays, A and B, of non-negative int scores. A "special" score is one which is a multiple of 10, such as 40 or 90. Return the sum of largest special score in A and the largest special score in B. To practice decomposition, write a separate helper method which finds the largest special score in an array. Write your helper method after your scoresSpecial() method in the JavaBat text area.

scoresSpecial([12, 10, 4], [2, 20, 30]) => 40
scoresSpecial([20, 10, 4], [2, 20, 10]) => 40
scoresSpecial([12, 11, 4], [2, 20, 31]) => 20
 
 */
public class ScoresSpecial {

    public static Integer getMax(List <Integer> intList) {
        Integer max = intList.stream()
                .filter(i -> ((i % 10) == 0))   // continue only if value is divisible by 10          
                //.peek(i -> {
                //    System.out.println("Processing: " + i);
                //})
                .max(Comparator.comparing(Integer::valueOf))    // get the Max among the list of Integers
                .orElse(0); // return a default value
        
        return max;
    }
    
    public static void main(String[] args) {
        List <Integer> aList = Arrays.asList(20, 10, 4);
        List <Integer> bList = Arrays.asList(2, 20, 10);

        Integer aMax = getMax(aList);
        Integer bMax = getMax(bList);
        System.out.println("Sum of Max of two lists: " + (aMax + bMax));
        
    }

}
