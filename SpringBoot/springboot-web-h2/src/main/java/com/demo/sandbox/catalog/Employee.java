package com.demo.sandbox.catalog;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
*
*
create table Production.Employee (
    EmployeeId int,
    Name	varchar(50),
    Salary	decimal(10,2)
)
*/
@Entity
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
