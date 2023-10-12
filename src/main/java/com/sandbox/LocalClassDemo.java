package com.sandbox;

import java.util.stream.Stream;
import java.util.Arrays;

/**
 */
public class LocalClassDemo {

    public static void display() {
        System.out.println("Display");

        class Demo {
            public void displayInDemo() {
                String[] months = { "January", "February", "March" };
                Stream<String> streamString = Arrays.asList(months).stream()
                        .filter(w -> w.endsWith("y"))
                        .limit(1); // Stream<String>

                System.out.println(streamString.count());
                String first = Arrays.asList(months).stream()
                        .filter(w -> w.endsWith("y")) // Stream <String>
                        .findFirst() // return first entry found
                        .orElse(null); // handle if no entry found

                System.out.println(first); // will print any entry

            }
        }

        Demo demo = new Demo();
        demo.displayInDemo();
    }

    public static void main(String[] args) {
        LocalClassDemo.display();
    }
}
