package com.sandbox.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapMergeExercise01 {

	public static void main(String[] args) {

		Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
		
		String[] words = {"Fizz", "Bar", "Buzz", "Fizz" }; 
		for (String word : words) {
			Integer count = wordCountMap.containsKey(word) ? wordCountMap.get(word)+1 : 1;
			wordCountMap.put(word, count);
		}

		wordCountMap.entrySet()
			.stream()
			.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
		
		wordCountMap.clear();
		
		Arrays.asList(words)
			.stream()
			.forEach( word -> {
						wordCountMap.putIfAbsent(word, 0);
						wordCountMap.put(word, wordCountMap.get(word) + 1);
						}
					);
		
		wordCountMap.entrySet().stream()
			.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
		
		wordCountMap.clear();
		System.out.println("");

		Arrays.asList(words)
			.stream()
			.forEach( word -> {
						wordCountMap.compute(word, (entry, prev) -> prev != null ? prev + 1 : 1);
						}
					);

		
		wordCountMap.entrySet()
		.stream()
		.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

		wordCountMap.clear();
		System.out.println("");
		
		Arrays.asList(words).stream()
			.forEach( word -> {
					wordCountMap.merge(word, 1, (entry, prev) -> prev + 1 );
					}
				);

		wordCountMap.entrySet()
		.stream()
		.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

		wordCountMap.clear();
		System.out.println("merge demo");

		Arrays.asList(words)
		.stream()
		.forEach(word -> wordCountMap.merge(word, 1, (prev, curr) -> prev + curr));

		wordCountMap.entrySet()
		.stream()
		.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
	}
}
