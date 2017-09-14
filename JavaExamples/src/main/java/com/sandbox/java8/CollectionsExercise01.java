package com.sandbox.java8;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class CollectionsExercise01 {
    public static void main(String[]args) {
        String [] cities = {"A", "B"};
        List<String> values = Collections.emptyList();
        for (Iterator<String> valuesIterator = values.iterator();
                valuesIterator.hasNext();) {
            System.out.println("Printing: " + valuesIterator.next());
        }
    }
}
