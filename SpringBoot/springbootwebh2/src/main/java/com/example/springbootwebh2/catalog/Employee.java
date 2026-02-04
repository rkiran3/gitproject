package com.example.springbootwebh2.catalog;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;


/**
*
*
create table Production.Employee (
    EmployeeId int,
    Name	varchar(50),
    Salary	decimal(10,2)
)
*/
//@Entity
public class Employee {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long employeeId;

   private String name;

   private String surname;

   private BigDecimal salary;

   public Long getEmployeeId() {
       return employeeId;
   }

   public void setEmployeeId(Long employeeId) {
       this.employeeId = employeeId;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public String getSurname() {
       return surname;
   }

   public void setSurname(String surname) {
       this.surname = surname;
   }

   public BigDecimal getSalary() {
       return salary;
   }

   public void setSalary(BigDecimal salary) {
       this.salary = salary;
   }
}
