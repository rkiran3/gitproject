package com.codewars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Given an array of integers, find the one that appears an odd number of times.

There will always be only one integer that appears an odd number of times.

@Test
  public void findTest() {
   	assertEquals(5, FindOdd.findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5})); 
    assertEquals(-1, FindOdd.findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5})); 
  	assertEquals(5, FindOdd.findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
   	assertEquals(10, FindOdd.findIt(new int[]{10}));
   	assertEquals(10, FindOdd.findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
    assertEquals(1, FindOdd.findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
 	}

 */

public class FindOdd {

	/**
	 * Function returns array element that occurs odd number of times
	 * 
	 * @param a
	 * @return
	 */
	public static int findIt(int[] a) {
		int oddNum = a[0]; // 
		Map<Integer, Integer> occurMap = new HashMap<Integer, Integer>();
		
		// get the entries and store in Map 
		for (int i=0; i< a.length; i++) {
			int key = a[i];
			int count = 1; // initially set occurrence to 1
			
			if (occurMap.containsKey(key)) {			
				count = occurMap.get(key);
				count++;
			}
			// store value in Map to check later
			occurMap.put(key, count);			
		}
		
		// Iterate Map to find the odd entry
		Iterator <Map.Entry<Integer, Integer>>iterator = occurMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> entry = iterator.next();
			// find if that key occurs odd/even by using modulo
			if (entry.getValue() % 2 == 1) {
				oddNum = entry.getKey();
			}
		}
		
	  	return oddNum;
	  }

	public static int findItStreams(int[] a) {
		Integer oddNum = null; // 
		List<Integer> intList = Arrays.stream(a)
			.boxed()
			.collect(Collectors.toList());
		
		Map<Integer, Long> occurMap = 
				intList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		// Iterate Map to find the odd entry
		for (Entry <Integer, Long> entry: occurMap.entrySet()) {

			// find if that key occurs odd/even by using modulo
			if (entry.getValue() % 2 == 1) {
				oddNum = entry.getKey();
			}
		}
		
		return oddNum;
	  }

	public static void main(String[] args) {

		System.out.println(FindOdd.findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5})); 		
		System.out.println(FindOdd.findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5})); 
		System.out.println(FindOdd.findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
		System.out.println(FindOdd.findIt(new int[]{10}));
		System.out.println(FindOdd.findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
		System.out.println(FindOdd.findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
	}
}
