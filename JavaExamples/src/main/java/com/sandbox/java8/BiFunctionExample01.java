package com.sandbox.java8;

import java.util.function.BiFunction;

/**
 *
 */
public class BiFunctionExample01 {
    public static void main(String []args) {
        BiFunction<Integer, Integer, String> biFunction =
                (num1, num2) -> "Result: " + (num1+num2);

        System.out.println(biFunction.apply(10, 30)); // prints "Result: 40"

        BiFunction<Integer, Double, Double> biFunctionCalculate =
                (num1, num2) ->  num1 * (num2/100) ;

        Integer cost = 12;
        Double tax = biFunctionCalculate.apply(cost, 8.0);
        System.out.println("Tax: " + tax);  // prints "Tax: 0.96"

        Double tip = biFunctionCalculate.apply(cost, 20.0);
        System.out.println("Tip: " + tip); // prints "Tip: 2.40000"

        Double total = cost + tax + tip; // 12 + 0.96 + 2.4000 = 15.36

        System.out.println("Total: " + total);  // "Total: 15.36000"
    }
}
