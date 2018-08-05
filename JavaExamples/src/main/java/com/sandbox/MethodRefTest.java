package com.sandbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * Exercise to add entries to List, Map and modify Map
 */
 
class Item {
    String name;
    Integer Id;
    Item (String name, Integer id) { this.name = name; this.Id = id; }
    Item() { name = "Default" ; Id = new Integer(99); }
    public String toString() { return name + " " + Id; }
    public Integer getId() { return Id; }
    public void setId(Integer id) { this.Id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}


public class MethodRefTest {

    public static void main( String [] args) {
        List <Item> itemList = new ArrayList<Item>();
        // Add an Item with a name
        itemList.add(new Item("Blue", new Integer(11)));
        itemList.add(new Item());
    
        // get all items with explicit name
        Stream <Item> filtered = itemList.stream()
            .filter(a -> !a.getName().equals("Default"));
        
        // Get first entry in list
        Item firstItem = itemList.stream()
            .filter(a -> !a.getName().equals("Default"))
            .findFirst()
            .orElse(null);
        if (firstItem != null){ 
            System.out.println("found entry ");
        } else {
            System.out.println("No entries found");
        }
        
        // Get selectedItem 
        Item selectedItem = itemList.stream()
            .filter(a -> a.getId() == 11)
            .findFirst()
            .orElse(null);
            
        if (selectedItem != null) { 
            System.out.println ("Selected Item" + selectedItem);
        }
        

        List <Item> filteredList = filtered.collect(Collectors.toList());
        filteredList.stream()
            .forEach(System.out::println);
    }
}
