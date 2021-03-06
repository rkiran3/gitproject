package com.sandbox;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Convert Array of primitive integers to List of Integer Objects
 */

public class ItemPriceList {

    class ItemP {
        private Integer id;
        private String name;
        
        public ItemP (Integer id, String name) {
			this.id = id;
			this.name = name;
		}

		public String toString() {
			return this.name;
		}
	}

	public static void main(String[] args) {
		ItemPriceList itemPriceList = new ItemPriceList();

		// Array of primitives
		int[] priceArray = { 0, 100, 200, 300 };

		// Convert from Array of primitive integers to List of Integers
		List<Integer> intList = Arrays.stream(priceArray).boxed().collect(Collectors.toList());

		assert (Arrays.asList(new Integer[] { 0, 100, 200, 300 }).equals(intList));

		// Construct a List of Objects, pass constructor parameters to each Object
		List<ItemP> itemPList = intList.stream().map(i -> itemPriceList.new ItemP(i, i.toString()))
				.collect(Collectors.toList());

		String outString = itemPList.stream()
				// .forEach(System.out::println);
				.map(Object::toString).collect(Collectors.joining(","));

		System.out.println("output: " + outString);

		if (!outString.equals("0,100,200,300")) {
			System.out.println("Error");

		}
    }
}
