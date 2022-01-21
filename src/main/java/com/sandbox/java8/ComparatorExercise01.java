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
    private int age;

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
        this.name = theName;
        this.age  = theAge;
    }

    public int ageDifference(final Person other) {
        return age - other.age;
    }

    public String toString() { return String.format("%s - %d", name, age);}
}
public class ComparatorExercise01 {

    public static void main(String [] args) {
        Person john = new Person("John", 20);
        Person sara = new Person("Sara", 21);
        Person jane = new Person("Jane", 21);
        Person greg = new Person("Greg", 35);
        final List<Person> personList = Arrays.asList(
                john, sara, jane, greg
        );

        // Compare by Name
        // specify pre-sorted list to compare after sorting
        Person [] sortedPersonByName = new Person [] {
                greg, jane, john, sara 
                }; 
        
        // Define comparator for Names, sort and validate
        Comparator <Person> personNameComparator = Comparator.comparing(Person::getName);
        Person [] personArray = personList.toArray(new Person[personList.size()]);
        Arrays.sort(personArray, personNameComparator);
        //assertArrayEquals(personArray, sortedPersonByName);
        
        
        // Define Comparator by Age, sort and validate
        Comparator<Person> compareAgeAscending =
                (person1, person2) -> person1.ageDifference(person2);
        Comparator<Person> compareAgeDescending = compareAgeAscending.reversed();
        Arrays.sort(personArray, compareAgeAscending);
        Person [] sortedPersonByAgeAsc = new Person [] {
                john, jane,  sara, greg // john=20, jane=21, sara=21, greg=35
                }; 
        //assertArrayEquals(personArray, sortedPersonByAgeAsc);
        
        List <Person> ascendingAge = personList
                .stream()
                .sorted((person1, person2) -> person1.ageDifference(person2))
                .collect(Collectors.toList());
        ascendingAge.forEach(System.out::println);

        List <Person> ascendingAge2 = personList
                .stream()
                .sorted(compareAgeAscending)
                .collect(Collectors.toList());
        ascendingAge2.forEach(System.out::println);

        Arrays.sort(personArray, compareAgeDescending);
        Person [] sortedPersonByAgeDesc = new Person [] {
                greg, jane, sara, john // john=20, jane=21, sara=21, greg=35
                };         
        //assertArrayEquals(personArray, sortedPersonByAgeDesc);


        List <Person> descendingAge = personList
                .stream()
                .sorted(compareAgeDescending)
                .collect(Collectors.toList());
        descendingAge.forEach(System.out::println);

        //System.out.println("Print persons older than 20");
        List <Person> olderThan20 = new ArrayList<>();
        personList
                .stream()
                .filter(person -> person.getAge() > 20)
                .forEach(person -> olderThan20.add(person));
        olderThan20.forEach(System.out::println);

        //System.out.println("Older than 20 using collect");
        ArrayList<Person> personListFromStream = personList
                .stream()
                .filter(person -> person.getAge() > 20)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        olderThan20.forEach(System.out::println);
    }
}
