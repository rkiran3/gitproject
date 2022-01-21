package com.sandbox.java8;

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
        assert(3 == personArrayList.size());
        
        // Get Linkedlist
        List <Person> personLinkedList = personList.stream()
                .filter(p -> p.getAge() < 30)
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        assert(3 == personLinkedList.size());
        
        // if no type is specified, we get ArrayList
        List <Person> personTmpList = personList.stream()
                .filter(p -> p.getAge() < 30)
                .collect(Collectors.toList());
        assert(personTmpList instanceof ArrayList);

        // Collect names 
        List <String> names = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        
        assert(names.size() == 4);
        assert(names.contains("John"));
        assert(names.contains("Jane"));
        assert(names.contains("Sara"));
        assert(names.contains("Greg"));
    
    }

}
