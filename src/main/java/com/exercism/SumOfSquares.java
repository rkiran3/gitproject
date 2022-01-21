package com.exercism;

import java.util.logging.Logger;
import java.util.stream.IntStream;

/*
 * Given two numbers n1 and n2 such that n2>n1, 
 * find sum of squares of all numbers 
 * from n1 to n2 (including n1 and n2).
 * 
 * n1 = 8   n2 = 10
 * total expected = 245
 */
public class SumOfSquares {

	public static void main(String[] args) {

		Logger logger = Logger.getLogger(SumOfSquares.class.getName());
		int n1 = 8;
		int n2 = 10;
		long total = IntStream.rangeClosed(n1, n2)
			.map(i -> i*i)
			.sum();
		
		logger.info("Total sum of squares " + n1 + " " + n2 + " = " + total);
	}

}
