package com.sandbox.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ravikir on 3/16/2017.
 */
public class LambdaExample01 {
    public static void main(String [] args) {
        final List<String> friends = Arrays.asList(
                "Brian", "Nate", "cate", "bob"
        );

        final List <String> upperCaseNames = new ArrayList<String>();

        friends.forEach(name -> upperCaseNames.add(name.toUpperCase()));

        upperCaseNames.forEach(System.out::println);

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
