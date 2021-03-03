package com.codewars;

/**
 * 
Create a function taking a positive integer as its parameter and returning a
string containing the Roman Numeral representation of that integer.

Modern Roman numerals are written by expressing each digit separately starting
with the left most digit and skipping any digit with a value of zero. In Roman
numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is
written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending
order: MDCLXVI.

Example:

conversion.solution(1000); //should return "M"
 * 
 * @author kiran
 *
 */

public class Conversion {
	
	public static String solution(int n) {
		String one = "I";
		String five = "V";
		String ten = "X";
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < n; i++) {
			int m = n % 10;
			
		}

			
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(Conversion.solution(11));
	}
}
