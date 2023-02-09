package com.sandbox.java8;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Word Frequency: 
 * 
 * Input:   "Fizz", "Bar", "Buzz", "Fizz" ;
 * Output:  Fizz: 2   Bar: 1   Buzz: 1
 * 
 * Using the sample data, print the frequency of each word.
 *
 */
public class MapMergeExercise01 {

	/** Helper function */
	public static void print(String[] words) {
		// define a Consumer to print debug statements 
		final Consumer<String> printFormatted = e -> System.out.printf("%s\n", e);

		Arrays.stream(words)
			.forEach(printFormatted);		
	}

	/* Helper function */
	public static void printMapEntry(Map<String, Integer> wordCountMap) {
		// define Consumer to print debug statements;
		final Consumer<Map.Entry<String, Integer>> printKeyVal = 
				me -> System.out.printf("%s:%s\n", me.getKey(), me.getValue());
				
		// print each entry using Consumer function
		wordCountMap.entrySet()
			.stream()
			.forEach(printKeyVal);
	}

	public static void main(String[] args) {
		Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
		
		// Sample words to demo word count
		String[] words = {"Fizz", "Bar", "Buzz", "Fizz" }; 
		
		// Iterate each word and collect in a map
		for (String word : words) {
			Integer count = wordCountMap.containsKey(word) ? 
					wordCountMap.get(word)+1 : 1;
			wordCountMap.put(word, count);
		}

		print(words);	
		
		printMapEntry(wordCountMap);
		
		// clear map for next exercise
		wordCountMap.clear();
		
		// HashMap compute 
		HashMap<String, String> monthMap = new HashMap<>();
		monthMap.put("Jan", "January");
		// append to value
		monthMap.compute("Jan", (key, val) -> val.concat(" has 31 days"));
		assertEquals(monthMap.get("Jan"),  "January has 31 days");
		
		
		Arrays.asList(words)
			.stream()
			.forEach(word -> {
						wordCountMap.putIfAbsent(word, 0);
						wordCountMap.put(word, wordCountMap.get(word) + 1);
						}
					);
		printMapEntry(wordCountMap);	
		
		// clear map for next exercise
		wordCountMap.clear();

		// Frequency using Streams forEach and compute
		Arrays.asList(words)
			.stream()
			.forEach(word -> {
						wordCountMap.compute(word, (entry, prev) -> prev != null ? prev + 1 : 1);
						}
					);
		
		printMapEntry(wordCountMap);
		
		// clear map for next exercise
		wordCountMap.clear();
		
		// Frequency using forEach and merge
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
