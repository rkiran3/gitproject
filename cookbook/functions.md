# A Simple Consumer function that adds values to List 

A Consumer depicts an operation that accepts a single argument and returns no result.  
This interface has a method called **accept(Object)**

A simple Consumer can be created that will accept values to a List.  

This example also shows how to use the Consumer which does some operation and then uses **andThen** to do another operation.

A Consumer does not return any value, so we cannot use that to perform any computation that returns a value, but the operation has side effects.

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

Example [Code](../JavaExamples/src/main/java/com/sandbox/java8/Consumer01.java)



