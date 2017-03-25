package com.sandbox.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 */
public class LambdaExample01 {
    public static void main(String [] args) {
        /* printing random integers in a range */
        Random random = new Random();
        random.ints(1, 25).limit(4).forEach(n -> System.out.print(n + " "));

        final List<String> friends = Arrays.asList(
                "Brian", "Nate", "cate", "bob"
        );

        final List <String> upperCaseNames = new ArrayList<String>();
        System.out.println("Creating list of upper case names");
        friends.forEach(name -> upperCaseNames.add(name.toUpperCase()));
        System.out.println("Printing upper case names");
        // prints {BRIAN, NATE, CATE, BOB}
        System.out.println(
                upperCaseNames
                        .stream()
                        .collect(Collectors.joining(", ", "{", "}")));

        System.out.println("Iterate and print uppercase names");
        upperCaseNames.forEach(System.out::print);
        upperCaseNames.forEach(name -> System.out.print(name + " "));

        List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("20"), new BigDecimal("15"),
                new BigDecimal("32")
        );
        /*
        In this example we’re sending a function, price -> price.multiply(BigDecimal.valueOf(0.9)),
as an argument to map. The function being passed is created just in time, at
the point of call to the higher-order function map. Generally a function has a
body, a name, a parameter list, and a return type. The just-in-time function
created here has a parameter list followed by an arrow (->), and then the short
body.

This function is anonymous; it has no name.
Rather than referring to them as anonymous functions, we call them lambda
expressions.
         */
        BigDecimal finalPrices = prices.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0 )
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("finalPrices = " + finalPrices);
    }
}
