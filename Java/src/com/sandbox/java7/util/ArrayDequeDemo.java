package com.sandbox.java7.util;

import java.util.*;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        String [] cities = { "Albuquerque", "Boston", "Chicago"};

        List<String> cityList = Arrays.asList(cities);
        Deque<String> monthsDeque = new ArrayDeque<>();
        Deque<String> cityDeque = new ArrayDeque<>();

        // add Cities [A, B, C] to beginning of Queue
        for (String city : cityList) {            cityDeque.addFirst(city);        }

        // Iterate the queue and print entries, prints [C, B, A] in reverse
        for (Iterator <String> iterator = cityDeque.iterator(); iterator.hasNext();) {
            String entry = iterator.next();
            System.out.println(entry);
        }

        monthsDeque.addFirst("February");   // February
        monthsDeque.addFirst("January");    // January, February
        monthsDeque.addLast("December");    // January, February, December

        for (Iterator <String> iterator = monthsDeque.iterator(); iterator.hasNext();) {
            String entry = iterator.next();
            System.out.println(entry);
        }
    }
}
