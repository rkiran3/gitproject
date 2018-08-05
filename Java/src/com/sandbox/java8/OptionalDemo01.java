package com.sandbox.java8;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.*;
import java.util.Optional;

class User {
    String name;
    String type;
    
    public User(String name, String type) {
        this.name = name;
        this.type = type;
    }
    
    public String toString() {
        String message = this.name + "-" + this.type;
        return message;
    }
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
    
}

public class OptionalDemo01 {
    public static void main(String [] args) {
        // Create list of users that can be used in a Stream
       List <User> users = new LinkedList<User>();
       User one = new User("Employee", "employee");
       User two = new User("Manager", "manager");
       User three = new User("President", "president");
       users.add(one); 
       users.add(two);
       users.add(three);
       
       //users.stream()
       // .forEach(System.out::println);
       
       User defaultUser = users.get(0);
       Optional<User> optUser = users.stream()
            .filter(u -> u.getType().equals("manager"))
            .findFirst();
            //.orElse(defaultUser);
        
       User contact = optUser.isPresent() ? optUser.get() : users.get(0);
       
       System.out.println("contact User: " + contact);
    }
}