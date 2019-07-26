package com.sandbox.java8p2;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;

public class DistinctDemo {

    public static void main(String[] args) {
        String [] citiesArr = { "Boston", "Chicago", "Phoenix", "Chicago" };
        String [] expectedCities = { "Boston", "Chicago", "Phoenix" };
        
        // Lets iterate List of Cities to get distinct entries  
        String [] distinctCities = Arrays.asList(citiesArr).stream()
                .distinct()
                .toArray(String[]::new);

        assertArrayEquals(expectedCities, distinctCities);
    }
}
