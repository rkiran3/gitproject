package com.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Check for existence of Integer in an Array.
 */ 
public class AnyMatchInListDemo {
  static Logger log = Logger.getLogger(AnyMatchInListDemo.class.getName());

  // class to use for testing
  class Employee {
    int age;
    String name;

    public Employee(int age, String name) {
      this.age = age; 
      this.name = name;
    }
    
    public int getAge() {
      return age; 
    }
    
    public String getName() {
      return name;
    }
    
    public String toString() {
      return "Age: " + age ;
    }
  }

  /**
   * Main Program.
   */
  public static void main(String [] args) {
    log.info("Begin");
        
    AnyMatchInListDemo demo = new AnyMatchInListDemo();

    // Sample values for testing - we will check if array contains a specific value
    Integer[]types = {Integer.valueOf(22), Integer.valueOf(33)};
           
    // Convert to integer value and check if number exists in Array [22, 33]
    boolean contains24 = Arrays.asList(types).stream()
        .mapToInt(Integer::valueOf) // convert from Integer to primitive
        .anyMatch(i -> i == 24);
    assert (!contains24); // 24 does not exist in array
        
    boolean contains33 = Arrays.asList(new Integer [] {11, 22, 33}).stream()
        .mapToInt(Integer::valueOf)
        .anyMatch(i -> i == 33);    // will find 33 in List
    assert (contains33);  // found specific value
        
    // Now, test by adding an Employee Object with different attributes
    List<Employee> employeeList = new ArrayList<>();
    // add Employee whose name is not defined yet
    Employee emp1 = 
        demo.new Employee(22, null);
    Employee emp2 = demo.new Employee(44, "Smith");

    // Add to Employee List
    employeeList.add(emp1);
    employeeList.add(emp2);
    
    boolean containsUnder30Age = employeeList.stream()
        .anyMatch(e -> e.getAge() < 30); // we have one employee under 30 years of age

    assert (containsUnder30Age);
        
    boolean containsUnder10Age = employeeList.stream()
        .anyMatch(e -> e.getAge() < 10); // we do not have any employees under 30 years of age
    
    assert (!containsUnder10Age);
        
    // Get all employees with No Name
    List<Employee> empWithNameList = employeeList.stream()
            .filter(e -> e.getName() != null)
            .collect(Collectors.toList());
    assert (empWithNameList.size() > 0);
        
    // Find all employees under age 30
    // employeeList has one entry with 22
    List<Employee> under30EmployeeList = employeeList.stream()
            .filter(e -> e.getAge() < 30)
            .collect(Collectors.toList());
    assert (under30EmployeeList.size() > 0);
        
    // Now add a check for an employee having a name value (i.e filter before using)
    List<Employee> under30WithNameEmployeeList = employeeList.stream()
        .filter(e -> Objects.nonNull(e.getName()))
        .filter(e -> e.getAge() < 30)
        .collect(Collectors.toList());
    assert (under30WithNameEmployeeList.size() == 0); 

    log.info("End");
    }
}
