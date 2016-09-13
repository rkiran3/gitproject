package com.sandbox.java8.util;

import java.util.Arrays;
import java.util.stream.*;

public class StreamDemo {
	public static void main(String [] args) {
		try {
			// Create Array of Strings
			String [] months = { "Jan", "February", "March" };
			
			// Create a Stream of String from the Array 			
			Stream <String> monthsStream = Arrays.stream(months);
			
			// Count 
			assert months.length == monthsStream.count();
			
			int [] numbers = { 1, 2, 3, 4, 5};
			IntStream intStream = Arrays.stream(numbers);

			// A filter acts on each element and returns elements which
			// are divisible by 2
			intStream
				.filter(e -> e%2 == 0)
				.forEach(System.out::println);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // main ends
} // classTest ends
