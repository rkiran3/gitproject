package com.codewars;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Your task is to make a function that can take any non-negative integer as an
argument and return it with its digits in descending order. Essentially,
rearrange the digits to create the highest possible number.  Examples:

Input: 42145 Output: 54421

Input: 145263 Output: 654321

Input: 123456789 Output: 987654321
 */

public class DescendingOrder {

	/* Traditional approach using loops */
	public static int sortDesc(final int num) {
		
		String input = String.valueOf(num);
		String[] tokens = input.split("");
		SortedSet<Integer> intSet = new TreeSet<>();
		
		// sample to show strings sorted in ascending order
		Stream<String> stream = Stream.of("UK", "US", "India", "Australia", "Armenia", "Canada", "Poland");
		Set<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
	    set.forEach(val -> System.out.println(val));
	      
	    //	.collect(Collectors.toCollection(TreeSet::new));
		if (tokens != null && tokens.length > 0 ) {
			for (int i=0; i < tokens.length; i++) {
				intSet.add(Integer.valueOf(tokens[i]));
			}
		}
	
		// Convert String to Stream of Characters
		String message = "Hello World	this is long Sentence";
		System.out.println(message.length());
		
		Stream<Character> streamChars = message.chars()
			.mapToObj(c -> (char) c);
		
		Pattern pattern = Pattern.compile("\\s*");
		Stream<String> msgStream = pattern.splitAsStream(message);		
		msgStream.forEach(System.out::print);
		System.out.println();
		
		Pattern pattern2 = Pattern.compile("\\P{Alpha}*");		
		msgStream = pattern2.splitAsStream(message);
		msgStream.forEach(System.out::print);
		
		
		System.exit(-1);
		
		Set <String> strTree = input.chars()
			.mapToObj(Character::toString)
			.collect(Collectors.toCollection(TreeSet::new));
			
		SortedSet<Integer> descSet = new TreeSet<>(Collections.reverseOrder());
		descSet.addAll(intSet);
		
		List<Integer> descList = descSet.stream()
			.collect(Collectors.toList());
		
		String output = descList.parallelStream()
			.map(String::valueOf)
			.collect(Collectors.joining());
				
		return Integer.valueOf(output);
	}
	
	public static void main(String[] args) {
		String input = "42145";
		int num = Integer.valueOf(input);
		System.out.println(sortDesc(num));
	}
}
