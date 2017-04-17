package com.sandbox.java8;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class MapExerciseTest extends TestCase {

    public void testIncreasePrice() throws Exception {

        int percentage = 10;
        List<Integer> originalPrices = Arrays.asList(100, 200, 300);
        List <Double> increasedPrices = Arrays.asList(
                110.0, 220.0, 330.0);
        MapExercise.increasePrice(originalPrices, 10);

        for (int i=0; i< originalPrices.size(); i++) {
            Integer originalPrice = originalPrices.get(i);
            double expectedPrice = (originalPrice *(percentage/100.0)) +
                    originalPrice;
            assertEquals(increasedPrices.get(i), expectedPrice);
        }

    }
}