package com.sandbox.java8;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RangeExample01 {
    public static void main(String[] args) {

        IntStream.rangeClosed(1, 10).forEach(System.out::print);

    }

}
