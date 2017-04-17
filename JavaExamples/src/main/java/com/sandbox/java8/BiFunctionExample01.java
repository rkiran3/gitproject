package com.sandbox.java8;

import java.util.function.BiFunction;

/**
 *
 */
public class BiFunctionExample01 {
    public static void main(String []args) {
        BiFunction<Integer, Integer, String> biFunction =
                (num1, num2) -> "Result: " + (num1+num2);

        System.out.println(biFunction.apply(10, 30));

        BiFunction<Integer, Double, Double> biFunctionCalculate =
                (num1, num2) ->  num1 * (num2/100) ;

        Integer cost = 12;
        Double tax = biFunctionCalculate.apply(cost, 8.0);
        System.out.println("Tax: " + tax);

        Double tip = biFunctionCalculate.apply(cost, 20.0);
        System.out.println("Tip: " + tip);

        Double total = cost + tax + tip;

        System.out.println("Total: " + total);
    }
}
