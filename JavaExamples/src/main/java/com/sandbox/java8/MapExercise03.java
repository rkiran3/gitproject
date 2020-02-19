package com.sandbox.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create a Map of Default Key, Value pairs, 
 * Use that map to replace tokens
 */
public class MapExercise03 {
    public static void main(String [] args) {

    	// Data Map that will contain default values 
        Map<String, String> data = new HashMap<String, String>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
            put("name", "Middle");
            put("prefix", "Front");
            put("postfix", "Back");
        }};

        // Replace each of the tokens with the values found in the "data" Map template.
        String title = Stream.of("prefix", "name", "postfix")
                .filter(data::containsKey)
                .map(data::get)
                .collect(Collectors.joining());
        
        if (!title.equals("FrontMiddleBack")) {
        	System.out.println("Test fails");
        }
        System.out.println("Title: " + title); // prints Title: FrontMiddleBack
    }
}
