package com.codingbat.warmup1;

/**
 * We'll say that a number is "teen" if it is in the 
 * range 13..19 inclusive. Given 2 int values, 
 * return true if one or the other is teen, but not both.
 *
 */
public class LoneTeen {

	public static boolean loneTeen(int a, int b) {
		boolean isTeen = false;
		boolean aTeen = false;
		boolean bTeen = false;
		
		if (a >= 13 && a <= 19 ) {
			aTeen = true;
		}

		if (b >= 13 && b <= 19 ) {
			bTeen = true;
		}

		isTeen = (aTeen || bTeen) && (aTeen != bTeen);
		
		return isTeen;  
	}
	
	public static void main(String[] args) {
		System.out.println(LoneTeen.loneTeen(13, 99)); // true
		System.out.println(LoneTeen.loneTeen(21, 19)); // true
		System.out.println(LoneTeen.loneTeen(13, 13));	// false
	}
}
