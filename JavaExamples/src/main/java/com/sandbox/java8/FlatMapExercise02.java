package com.sandbox.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.logging.*;

/**
 * Input:
 * 	Months [ "Jan", "Feb" ]
 *  days: 2
 *  
 * Output:
 * 	[ "Jan-0", "Jan-1", "Feb-0", "Feb-1" ] 
 * 
 *
 */
public class FlatMapExercise02 {

	public static Logger logger = Logger.getLogger(FlatMapExercise02.class.getName());
	
	// Create a List of Strings given month and num of days
	// Input: Jan, 2
	// Output: Jan-1, Jan-2
	public static List<String> getDays(String month, int limit) {
		List<String> daysList = IntStream.range(0, limit)
			.mapToObj(i -> String.format("%s-%d", month, i))
			.collect(Collectors.toList());
		
		return daysList;
	}
	
	public static void main(String[] args) {
		logger.info("Begin");

		List<String> monthsList = Arrays.asList("Jan", "Feb");
				
		// Expected: Jan-0, Jan-1, Feb-0, Feb-1
		List<String> daysList = monthsList.stream()
			.flatMap(m -> getDays(m, 2).stream())
			.collect(Collectors.toList());
	
		logger.info(daysList.toString());
		
		logger.info("End");
	}
}
