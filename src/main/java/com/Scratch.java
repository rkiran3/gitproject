    package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Employee {
    String name;
    boolean mgr;

    public Employee(String name, boolean mgr){
        this.name = name;
        this.mgr = mgr;
    }

    public Employee(String name){
        this.name = name;
    }

    // returns concise representation of this object
    public String toString() {
        return this.name + " " + (isMgr() ? "is Manager" : "is not a Manager");
    }
}

// Class to show Stream AnyMatch
public class Scratch {
    public static void main(String []args) {
        Employee emp = new Employee("Pam");
        System.out.println(emp); // will print "Pam is not a Manager"

        String numString = "4532745";

        Pattern.compile("").splitAsStream(numString)
            .forEach(System.out::println);

        List<Integer> intList = Pattern.compile("").splitAsStream(numString)
            .map(Integer::valueOf)
            .collect(Collectors.toList());

        // get the max in instream.
        Integer maxInt = Pattern.compile("").splitAsStream(numString)
        .map(Integer::valueOf)
        .max(Integer::compare)
        .get();

        System.out.println(maxInt.intValue());

        Collections.sort(intList);

        intList.stream()
            .forEach(System.out::println);

        String sentence = "A quick fox jumped over the dog";
        Pattern.compile("\\s+").splitAsStream(sentence)
            .forEach(System.out::println);

        // Initialize this employee to be a Manager
        Employee emp2 = new Employee("Sam", true);
        System.out.println(emp2); // will print "Sam is not a Manager"

        // Create a list to store employees
        List<Employee> empList = new ArrayList<>();
        empList.add(emp);
        empList.add(emp2);

        // Use Streams to find any matching Employee who is a Manager.
        // Notice we can use "Employee::isMgr".
        boolean anyMgr = empList.stream()
            .anyMatch(Employee::isMgr);

        // Will print "Manager found in list"
        System.out.println(anyMgr ? "Manager found in list." : "No Managers in list.");
    }
}
