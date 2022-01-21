package com.sandbox.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Example to show Grouping By using attributes of an Object, 
 * Given an Item - use Collectors and grouping by to get the total amounts grouped by their variants.
 * 
 * Items = list of Items	[redShirt, greenShirt]
 * Each Item: name     Map<String, Integer>  
 * 		"red"	{ 	"small": 11,	"medium": 22,	"large": 33 }
 * 		"red"	{	"small": 11,	"medium": 22,	"large": 33 }
 * 		"green"	{	"small": 44,	"medium": 55,	"large": 66 }
 *
 *	Expected:
 *		red: 	{	"small": 22,	"medium"=44,	"large"=66}
 *		green:	{	"small": 44,	"medium"=55,	"large"=66}
 */

public class MapExercise06 {
	class Item {
		private String name;
		private Map <String, Integer> variants = new HashMap<>();
		
		public Item(String name, Map<String, Integer> variants) {
			this.setName(name);
			this.setVariants(variants);
		}
		
		public String toString() { return getName(); }

		public String getName() { return name; }

		public void setName(String name) { this.name = name; }

		public Map <String, Integer> getVariants() { return variants; }

		public void setVariants(Map <String, Integer> variants) { this.variants = variants; };
	}

	public static void main(String[] args) {
		List <Item> itemsList = new ArrayList<>();
		
		Map <String, Integer> redShirtVariantsMap = new HashMap<>();
		redShirtVariantsMap.put("small", 11);
		redShirtVariantsMap.put("medium", 22);
		redShirtVariantsMap.put("large", 33);
		Item redShirt = new MapExercise06(). new Item("red", redShirtVariantsMap);

		Map <String, Integer> anotherRedShirtVariantsMap = new HashMap<>();
		anotherRedShirtVariantsMap.put("small", 11);
		anotherRedShirtVariantsMap.put("medium", 22);
		anotherRedShirtVariantsMap.put("large", 33);
		Item anotherRedShirt = new MapExercise06(). new Item("red", redShirtVariantsMap);

		
		Map <String, Integer> greenShirtVariantsMap = new HashMap<>();
		greenShirtVariantsMap.put("small", 44);
		greenShirtVariantsMap.put("medium", 55);
		greenShirtVariantsMap.put("large", 66);
		Item greenShirt = new MapExercise06(). new Item("green", greenShirtVariantsMap);

		itemsList.add(redShirt);
		itemsList.add(anotherRedShirt);
		itemsList.add(greenShirt);
		
		Map<String, Map<String, Integer>> resultMap = itemsList.stream()
			.collect(Collectors.toMap(Item::getName, Item::getVariants,
						(a, b) -> Stream.concat(a.entrySet().stream(), b.entrySet().stream())
							.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum))
							));
		
		System.out.println(resultMap);
		
	}

}
