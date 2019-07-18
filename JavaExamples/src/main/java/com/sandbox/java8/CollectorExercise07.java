package com.sandbox.java8;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorExercise07 {

    public static void main(String[] args) {
        Person john = new Person("John", 20);
        Person sara = new Person("Sara", 21);
        Person jane = new Person("Jane", 21);
        Person greg = new Person("Greg", 35);
        final List<Person> personList = Arrays.asList(
                john, sara, jane, greg
        );

        // Get ArrayList
        List <Person> personArrayList = personList.stream()
            .filter(p -> p.getAge() < 30)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);        
        assertTrue(personArrayList.size() == 3);
        
        // Get Linkedlist
        List <Person> personLinkedList = personList.stream()
                .filter(p -> p.getAge() < 30)
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        assertTrue(personLinkedList.size() == 3);
        
        // if no type is specified, we get ArrayList
        List <Person> personTmpList = personList.stream()
                .filter(p -> p.getAge() < 30)
                .collect(Collectors.toList());
        assertTrue(personTmpList instanceof ArrayList);

        // Collect names 
        List <String> names = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        
        assertTrue(names.size() == 4);
        assertTrue(names.contains("John"));
        assertTrue(names.contains("Jane"));
        assertTrue(names.contains("Sara"));
        assertTrue(names.contains("Greg"));
        
    
    }

}
