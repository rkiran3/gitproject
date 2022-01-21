package com.sandbox.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 */
public class ConsumerExercise01 {
    private void sayHello(String userName) {
        System.out.println("Hello " + userName);
    }

    public static void main(String [] args) {
        System.out.println("Hello");
        ConsumerExercise01 consumerExercise01 = new ConsumerExercise01();
        String [] cities = { "New York", "Chicago"};
        List <String> citiesList = Arrays.asList(cities);


        final Consumer<String> sayHello = (userName) ->
                consumerExercise01.sayHello(userName);
        sayHello.accept("Bill");

        citiesList.forEach(sayHello);

    }
}
