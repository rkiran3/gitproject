package com.sandbox.java8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class Consumer01 {

	public static void main(String[] args) {

		List <String> plainList = new LinkedList<>();
		List <Integer> wordLengthList = new LinkedList<>();

		// Create a Consumer that accepts a String and adds to LinkedList
		// it does output any value
		Consumer <String> myConsumerAddToList =  c -> plainList.add(c);
		
		// This Consumer adds length of word to Linked List
		Consumer <String> myConsumerLength = c -> wordLengthList.add(c.length());
		
		// Example list of words to test Consumer
		List <String> wordsList = Arrays.asList("January", "February", "March");
		
		wordsList.stream()
			.forEach(e -> myConsumerAddToList
					.andThen(myConsumerLength)
					.accept(e));
		
		System.out.println(plainList); // [January, February, March]
		System.out.println(wordLengthList); // [7, 8, 5]
		
	}
}
