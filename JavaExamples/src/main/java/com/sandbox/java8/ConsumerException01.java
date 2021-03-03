package com.sandbox.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Example to handle Exceptions,
 * In this case we handle invalid entries 
 */
public class ConsumerException01 {
    static Consumer<String> process(Consumer<String> unhandled) {
    	return obj -> {
    		try {
    			unhandled.accept(obj);
    		} catch (NumberFormatException ex) {
    			System.err.println("error in token: " + obj);
    		}
    	};
    }
    public static void main(String [] args) {
        System.out.println("Hello");
        String[] numbers = { "11", "22", "xyz"};
        
        System.out.println("ConsumerException01.main()");
        
        Arrays.asList(numbers)
        	.forEach(process(token -> System.out.println(Integer.parseInt(token))));
    }
}
