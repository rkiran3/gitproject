package com.sandbox.java8;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class LambdaExample01 {
    public static void main(String [] args) {
        /* printing random integers in a range */
        System.out.println("Printing Random Integers: " + 
        		new Random()
            	.ints(1, 25)
            	.limit(4)
            	.mapToObj(i -> String.valueOf(i))	// Convert ints to String
            	.collect(Collectors.joining(" ")));        
        // Initialize a list of names to use in tests
        final List<String> friends = Arrays.asList(
                "Brian", "Nate", "cate", "bob"
        );

        // store uppercased names into another array
        final List <String> upperCaseNames = new ArrayList<String>();
        System.out.println("\nCreating list of upper case names");
        friends.forEach(name -> upperCaseNames.add(name.toUpperCase()));
        // prints {BRIAN, NATE, CATE, BOB}
        System.out.println("\nPrinting upper case names: " + 
                upperCaseNames
                        .stream()
                        .collect(Collectors.joining(", ", "{", "}")));
        
        // Print the original list of names
        System.out.println("\nOriginal list: " + 
	        friends
	        	.stream()
	        	.collect(Collectors.joining(", ", "{", "}"))
	        	);
        
        System.out.println("\nCapitalize First Character of each word " +
        	friends
        	.stream()
        	.map(w -> 
        		new Character(w.charAt(0)).toString().toUpperCase() + w.substring(1).toLowerCase()
        		)
        	.collect(Collectors.joining(", ", "{", "}"))
        ); // prints {Brian, Nate, Cate, Bob};
        
        // another way of getting first character
        System.out.println("\nCapitalize First Character of each word " +
            	friends
            	.stream()
            	.map(w -> 
            		String.valueOf(w.charAt(0)).toUpperCase() + w.substring(1).toLowerCase()
            		)
            	.collect(Collectors.joining(", ", "{", "}"))
            ); // prints {Brian, Nate, Cate, Bob};
        
        System.out.println("\nIterate and print uppercase names");
        System.out.println(upperCaseNames
        	.stream()
        	.collect(Collectors.joining(" ")));

        List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("20"), new BigDecimal("15"),
                new BigDecimal("32")
        );
        /*
        In this example we’re sending a function, price -> price.multiply(BigDecimal.valueOf(0.9)),
as an argument to map. The function being passed is created just in time, at
the point of call to the higher-order function map. Generally a function has a
body, a name, a parameter list, and a return type. The just-in-time function
created here has a parameter list followed by an arrow (->), and then the short
body.

This function is anonymous; it has no name.
Rather than referring to them as anonymous functions, we call them lambda
expressions.
         */
        BigDecimal finalPrices = prices.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0 )
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("finalPrices = " + finalPrices);

        //System.out.println("Random UUID: " + UUID.randomUUID().toString().replace("[^a-z]", ""));

        String rawUUID = UUID.randomUUID().toString();
        String convertedUUID = rawUUID.replaceAll("[\\p{Digit}-]", "");
        System.out.println(rawUUID);
        System.out.println(convertedUUID);
    }
}
