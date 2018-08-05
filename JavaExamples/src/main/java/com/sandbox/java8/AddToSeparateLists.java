package com.sandbox.java8;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class AddToSeparateLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <String> allowedWords = new LinkedList<String>();
		
		Stream.of("AA", "BB", "CCCC", "DDD")
			///    .peek(w -> System.out.println(w))
			.filter(w -> w.length() > 2)			
			.forEach(allowedWords::add);
		
        allowedWords.stream()
            .forEach(System.out::println);
        
		System.out.println(allowedWords);
	}

}
