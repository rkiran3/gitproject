package com.codewars;

import java.util.regex.Pattern;

/**
 * Write a function that accepts an array of 10 integers
 * (between 0 and 9), that returns a string of those numbers
 * in the form of a phone number.
 * 
 * Input:
 * new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
 * Output:
 * (123) 456-7890
 *
 */
public class Kata {

	/**
	 * Write a function that accepts a string, and returns true if it is in the
	 * form of a phone number.
	 * Assume that any integer from 0-9 in any of the spots will produce a valid
	 * phone number.
	 * 
	 * Only worry about the following format:
	 * (123) 456-7890 (don't forget the space after the close parentheses)
	 * 
	 * Examples:
	 * 
	 * validPhoneNumber("(123) 456-7890") => returns true
	 * validPhoneNumber("(1111)555 2345") => returns false
	 * validPhoneNumber("(098) 123 4567") => returns false
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static boolean validPhoneNumber(String phoneNumber) {

		boolean retVal = Pattern.matches("\\(\\d{3}\\) \\d{3}-\\d{4}", phoneNumber);

		return retVal;
	}

	/* Using StringBuffer */
	public static String createPhoneNumber(int[] numbers) {

		StringBuffer sb = new StringBuffer();
		sb.append("(");
		for (int i = 0; i < 3; i++) {
			sb.append(numbers[i]);
		}
		sb.append(") ");

		for (int i = 3; i < 6; i++) {
			sb.append(numbers[i]);
		}
		sb.append("-");

		for (int i = 6; i < numbers.length; i++) {
			sb.append(numbers[i]);
		}

		return sb.toString();
	}

	/* Using String format specifiers */
	public static String createPhoneNumberV2(int[] numbers) {

		String output = String.format("(%d%d%d) %d%d%d-%d%d%d%d", numbers[0], numbers[1], numbers[2],
				numbers[3], numbers[4], numbers[5],
				numbers[6], numbers[7], numbers[8], numbers[9]);

		return output;
	}

	public static void main(String[] args) {

		System.out.println(Kata.createPhoneNumber(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }));

		System.out.println(Kata.createPhoneNumberV2(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }));

		System.out.println(Kata.validPhoneNumber("(123) 456-7890"));
		System.out.println(Kata.validPhoneNumber("(1111)555 2345"));
		System.out.println(Kata.validPhoneNumber("(098) 123 4567"));

	}

}
