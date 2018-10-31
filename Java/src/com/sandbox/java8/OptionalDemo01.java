package com.sandbox.java8;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.*;
import java.util.Optional;

class User {
    String name;
    String type;
    public User(String name, String type) { this.name = name; this.type = type; }
    
    public String toString() { return this.name + "-" + this.type; }
    public String getName() { return name; }
    public String getType() { return type; }
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

        // Assign a default User to use if desired user not found
        User defaultUser = users.get(0);
        Optional<User> optUser = users.stream()
            .filter(u -> u.getType().equals("guest"))  // search existent/nonexistent user
            .findFirst();
            //.orElse(defaultUser);
        
        // return user if found, otherwise return first user in list
        User contact = optUser.isPresent() ? optUser.get() : users.get(0);
        assert("Employee-employee".equals(contact.toString()));
       
        // Object is not null, print Object 
        User guest = new User("Guest", "guest");
        Optional<User> opt = Optional.of(guest); // will return User
        assert("Guest".equals(opt.get().getName()));
 
        // Object is null, use ifPresent() to print its value
        User neighbor = null;
        Optional<User> optNeighbor = Optional.ofNullable(neighbor);  // Object can be null
        optNeighbor.ifPresent(n -> System.out.println(n.toString()));

        // Object is null, get alternate value
        //User broker = new User("Broker", "broker");  
        User vendor = null;        // will print default value set in .orElse()
        String defaultVendor = Optional.ofNullable(vendor)
            .map(n->n.getName())
            .orElse("Default Vendor");        
        //System.out.println("default["+ defaultBroker+"]");
        assert("Default Vendor".equals(defaultVendor));
        
        // debug
        users.stream()
            .forEach(u -> System.out.println(u));
            
        boolean found = users.stream()
            .anyMatch(u->u.getName().equals("Manager"));
        System.out.println("Found Manager: " + found);
    }
}