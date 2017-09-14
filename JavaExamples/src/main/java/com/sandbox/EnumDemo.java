package com.sandbox;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

/**
 *
 */
enum Months {
    JANUARY, FEBRUARY, MARCH
}
public class EnumDemo {
    public static void main(String []args){
        Stream.of(Months.values())
                .forEach(System.out::println);

        String [] countries = Locale.getISOCountries();
        Arrays.asList(countries)
                .stream()
                .forEach(System.out::println);
        Locale.Category [] values = Locale.Category.values();
        Arrays.asList(values)
                .stream()
                .forEach(System.out::println);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.FRENCH);
        System.out.println(numberFormat.format(123.45));
    }
}
