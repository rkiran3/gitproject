package com.sandbox.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ListOfIntegersMatchingNumber {
    
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Person {
        boolean admin;
        String name;

        public String toString() {
            return String.format("%s %s", name, admin);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        Person jane = new Person(true, "Jane");
        Person jill = new Person(true, "Jill");
        Person mike = new Person(false, "Mike");
        Person bob = new Person(false, "Bob");

        Person[] personsArr = {jane, jill, mike, bob};
        Map<Boolean, List<Person>> mymap =  Arrays.asList(personsArr)
            .stream()
            .collect(Collectors.partitioningBy(Person::isAdmin));

        // false=[Mike false, Bob false]
        // true=[Jane true, Jill true]
        mymap.entrySet().stream()
            .forEach(System.out::println);

        // [Mike false, Bob false]
        // [Jane true, Jill true]
        mymap.entrySet().stream()
            .map(e -> e.getValue())
            .forEach(System.out::println);
    }
}
