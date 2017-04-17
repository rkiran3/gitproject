package com.sandbox.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
class Person {
    private String  name;
    private int     age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(final String theName, final int theAge) {
        this.name   = theName;
        this.age    = theAge;
    }

    public int ageDifference(final Person other) {
        return age - other.age;
    }

    public String toString() { return String.format("%s - %d", name, age);}
}
public class ComparatorExercise01 {

    public static void main(String [] args) {
        final List<Person> peopleList = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35)
        );

        Comparator<Person> compareAscending =
                (person1, person2) -> person1.ageDifference(person2);
        Comparator<Person> compareDescending = compareAscending.reversed();

        List <Person> ascendingAge = peopleList
                .stream()
                .sorted((person1, person2) -> person1.ageDifference(person2))
                .collect(Collectors.toList());

        ascendingAge.forEach(System.out::println);

        List <Person> ascendingAge2 = peopleList
                .stream()
                .sorted(compareAscending)
                .collect(Collectors.toList());
        ascendingAge2.forEach(System.out::println);

        List <Person> descendingAge = peopleList
                .stream()
                .sorted(compareDescending)
                .collect(Collectors.toList());
        descendingAge.forEach(System.out::println);

        System.out.println("Print persons older than 20");
        List <Person> olderThan20 = new ArrayList<>();
        peopleList
                .stream()
                .filter(person -> person.getAge() > 20)
                .forEach(person -> olderThan20.add(person));
        olderThan20.forEach(System.out::println);

        System.out.println("Older than 20 using collect");
        peopleList
                .stream()
                .filter(person -> person.getAge() > 20)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        olderThan20.forEach(System.out::println);

    }
}
