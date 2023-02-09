package com.euler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/** 
 * This program was based off some online exercise, since this reminds of Euler
 * type programs, this program sits here
 * 
 * Given an number - find the smallest possible integer that has K number of holes
 * 
 * numbers: 1, 2, 3, 5, 7   have no holes in them
 *  numbers: 4, 6, 9  have 1 hole 
 *  number: 8  has 2 holes
 *  
 *  
 *  Given K = 2     then smallest possible number that contains 2 holes would be 8
 *  K = 3	what positive number would contain 3 holes 
 *  
 * 
 * @param args
 */

public class SmallestPossible {

	public static Map<Integer, Integer> holesMap = new HashMap<>();
	
	static {
		holesMap.put(0, 1);
		holesMap.put(1, 0);
		holesMap.put(1, 0);
		holesMap.put(2, 0);
		holesMap.put(3, 0);
		holesMap.put(4, 1);
		holesMap.put(5, 0);
		holesMap.put(6, 1);
		holesMap.put(7, 0);
		holesMap.put(8, 2);
		holesMap.put(9, 1);
 	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	public static int getHolesInNumber(int number) {	
		int holesInNum = 0;
		
		if (number < 10) {
			holesInNum = holesMap.get(number);			
		} else {
			String target = String.valueOf(number);			
			// accumulate holes found in each digit in number
			holesInNum = Stream.of(target.split(""))
					.mapToInt(Integer::valueOf)
					.map(t -> holesMap.get(t))
					.sum();
		}

		return holesInNum;
	}
	
	public static String getValue(int k) {
		String retVal = "";
		
		// Check each number to see if it qualifies
		for (int i=0; i < Integer.MAX_VALUE; i++) {
			int holesInNum = getHolesInNumber(i);
			
			if (holesInNum == k) {
				retVal = String.valueOf(i);
				break;
			}
		}
		return retVal;
	}
	
	public static void main(String[] args) {
		for (int i=1; i < 10; i++) {
			String retVal = getValue(i);
			if (retVal.length() > 0) {
				System.out.println("Smallest positive number for " + i + " holes = " + retVal);
			}
		}
	}
}
