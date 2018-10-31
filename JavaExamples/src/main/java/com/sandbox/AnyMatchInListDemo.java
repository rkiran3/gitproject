package com.sandbox;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * Check for existence of Integer in an Array
 */ 
class Employee {
    int age;
    String name;
    public Employee(int age, String name ) { this.age = age; this.name = name; }
    public int getAge() { return age; }
    public String getName() { return name; }
    public String toString() { return "Age: " + age ; }
}
 
public class AnyMatchInListDemo {


    public static void main( String [] args) {
        
        Integer []types = {new Integer(22), new Integer (33)};
           
        // Convert to int value and check if number exists
        boolean contains = Arrays.asList(types).stream()            
            .mapToInt(Integer::valueOf)            
            .anyMatch(i -> i == 24);
        // contains will be false
        assert(!contains);
        
        contains = Arrays.asList(new Integer [] {11, 22, 33}).stream()            
            .mapToInt(Integer::valueOf)
            .anyMatch(i -> i == 33);
        // contains will be true
        assert(contains);
        
        // Test to filter entries with no name (i.e. null values)
        List <Employee> empList = new ArrayList<>();
        empList.add(new Employee(22, null ));
        empList.add(new Employee(44, "Chicago"));    // populate with no value
        
        List <Employee> filteredEmpList = empList.stream()
            .filter(e -> e.getAge() < 30 )
            .collect(Collectors.toList());
                    
        System.out.println(filteredEmpList); // will print Emp with 22
        
        // Now add a check for an employee having a name value (i.e filter before using)
        filteredEmpList = empList.stream()
            .filter(e -> e.getName() != null)
            .filter(e -> e.getAge() < 30 )
            .collect(Collectors.toList());
            
        System.out.println(filteredEmpList); // should print empty list

    }
}
