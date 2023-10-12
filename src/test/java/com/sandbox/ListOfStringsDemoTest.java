package com.sandbox;

import java.util.Arrays;
import java.util.Optional;

import junit.framework.TestCase;

public class ListOfStringsDemoTest extends TestCase {

	public void testZeroLengthStringArray() throws Exception {
	
        // Check for empty List
        String[] months = {};
        long count = Arrays.asList(months).stream()
        	.count();
        assert(0 == count);
        
	}
	
	public void testZeroLengthWithOptional() throws Exception {
        // Check for null value and return default empty array
        String[] cities = null;
        long cityCount = Arrays.asList(
        		Optional.ofNullable(cities)
        			.orElseGet(() -> { 
        				String[] empty = new String[] {};	
        				return empty;
        				}
        			)
        		).stream()
        	.count();
        assert(0 == cityCount);
	}
	
	public void testZeroLengthWithOptional2() throws Exception {
        
        // Check for null value and return default empty array
        String[] buses = null;
        long busCount = Arrays.asList(
        		Optional.ofNullable(buses)
        			.orElseGet( () -> { return new String[0]; } 
        			)
        		).stream()
        	.count();
        assert(0 == busCount);
	}
}
