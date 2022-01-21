package com.sandbox.java8;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CollectorExercise01Test extends TestCase {

    public void testGreaterThanN() throws Exception {
        Integer [] intArray = { 10, 20, 30};
        List<Integer> intList = new ArrayList<>(Arrays.asList(intArray));

        List <Integer> outList = intList
                .stream()
                .filter(CollectorExercise01.greaterThanN(10))
                .collect(toList());

        assert(outList.size() == 2);
        assert(outList.get(0) == 20);
    }

    public void testPrintListGreaterThan() throws Exception {

    }
}