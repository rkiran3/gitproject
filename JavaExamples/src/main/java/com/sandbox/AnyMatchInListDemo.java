package com.sandbox;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
            .anyMatch(i -> i == 33);    // will find 33 in List
        // contains will be true
        assert(contains);
        
        // Test to filter entries with no name (i.e. null values)
        List <Employee> empList = new ArrayList<>();
        Employee emp1 = new Employee(22, null);     // emp with no name
        Employee emp2 = new Employee(44, "Smith");
                
        // Add to Employee List
        empList.add(emp1);
        empList.add(emp2);
        
        // Get all employees with No Name
        List <Employee> empWithNameList = empList.stream()
                .filter(e -> e.getName() != null)
                .collect(Collectors.toList());
        
        assertEquals(1, empWithNameList.size());    // only one Employee does not have name
        assertTrue(empWithNameList.get(0).getName().equals("Smith"));
        
        // Find all employees under age 30
        List <Employee> youngEmpList = empList.stream()
            .filter(e -> e.getAge() < 30 )
            .collect(Collectors.toList());
          
        assertEquals(1, youngEmpList.size()); // will show employees less than age 30 
        
        // Now add a check for an employee having a name value (i.e filter before using)
        youngEmpList = empList.stream()
            .filter(e -> e.getName() != null)
            .filter(e -> e.getAge() < 30 )
            .collect(Collectors.toList());
            
        assertEquals(0, youngEmpList.size()); 

    }
}
