package com.sandbox;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

/**
 * Convert Array of primitive integers to List of Integer Objects
 */

public class ItemPriceList {
	@AllArgsConstructor
	class ItemP {
		private Integer id;
		private String name;

		public String toString() {
			return this.id + " " + this.name;
		}
	}

	public static void main(String[] args) {
		SalesAggregateDemo itemPriceList = new SalesAggregateDemo();

		// Array of primitives
		int[] priceArray = { 0, 100, 200, 300 };

		// Convert from Array of primitive integers to List of Integers
		List<Integer> intList = Arrays.stream(priceArray)
				.boxed()
				.collect(Collectors.toList());

		// Construct a List of Objects, pass constructor parameters to each Object
		List<ItemP> itemPList = intList.stream()
				.map(i -> itemPriceList.new ItemP(i, i.toString()))
				.collect(Collectors.toList());

		String outString = itemPList.stream()
				.map(ItemP::toString)
				.collect(Collectors.joining(","));

		System.out.println("output: " + outString);

		if (!outString.equals("0 0,100 100,200 200,300 300")) {
			System.out.println("Error");
		}
	}
}
