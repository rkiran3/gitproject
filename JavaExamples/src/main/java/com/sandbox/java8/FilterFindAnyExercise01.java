package com.sandbox.java8;

import java.util.Arrays;
import java.util.Optional;

/*
 * Find any entry that ends with 'y'

 * show 
 * 	a) getting entry if condition met
 * 	b) boolean if entry found
 * 
 * Input: [January, February, March, May, June, July]
	
	Output: 
		Any of the following months: January/February/May/July
 * 
 */

public class FilterFindAnyExercise01 {
    public static void main(String []args) {

        String[] monthsArray = { "January", "February", "March", "May", "June", "July" };
        System.out.println(Arrays.asList(monthsArray));
        
        String anyMonthEndsY = Arrays.asList(monthsArray).parallelStream()
                .filter(e -> e.toLowerCase().endsWith("y"))
                .findAny()
                .orElse("");
 
        System.out.println(anyMonthEndsY);
        
        boolean endsY = Arrays.asList(monthsArray).parallelStream()
        	.filter(e -> e.toLowerCase().endsWith("y"))
        	.findAny()
        	.isPresent();
        System.out.println(endsY);
    }
    
}
