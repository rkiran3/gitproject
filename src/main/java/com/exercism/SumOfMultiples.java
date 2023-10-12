package com.exercism;

import java.util.stream.IntStream;

/**
 * Given a number, find the sum of all the unique multiples of 
 * particular numbers up to but not including that number.
 * If we list all the natural numbers below 20 that are 
 * multiples of 3 or 5, we get 3, 5, 6, 9, 10, 12, 15, and 18.
 * The sum of these multiples is 78.
 */
public class SumOfMultiples {

	public static void main(String[] args) {

		int total = IntStream.range(1, 20)
			.filter(i -> (i % 3 == 0) || (i % 5 == 0))
			.sum();
			//.forEachOrdered( i -> System.out.println(i));
		
		System.out.println("Total: " + total);
		
	}

}
