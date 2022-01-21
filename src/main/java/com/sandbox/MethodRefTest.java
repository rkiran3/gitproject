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

class ItemConstant {
    public static final String ITEM_NAME="Default";
    public static final String ITEM_RED="RED";
}

class Item {
    String name;
    Integer Id;
    Item (String name, Integer id) { this.name = name; this.Id = id; }
    Item() { name = ItemConstant.ITEM_NAME ; Id = Integer.valueOf(99); }
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
        itemList.add(new Item(ItemConstant.ITEM_RED, Integer.valueOf(11)));
        itemList.add(new Item()); // will set to name="Default" and Id=99
    
        // get all items that contain ITEM_NAME 
        Stream <Item> filtered = itemList.stream()
            .filter(a -> !a.getName().equals(ItemConstant.ITEM_NAME));
        
        // Get first entry in list, 
        // when there are no matches - return null
        // else return first Item that matches
        Item firstItem = itemList.stream()
            .filter(a -> !a.getName().equals(ItemConstant.ITEM_NAME))
            .findFirst()
            .orElse(null);
        assert(firstItem != null);
        
        // Get selected Item that matches the ID
        Item selectedItem = itemList.stream()
            .filter(a -> a.getId() == 11)
            .findFirst()
            .orElse(null);
        System.out.println("Testing 1");
        assert(selectedItem.getName().equals(ItemConstant.ITEM_RED));

        // Return first item in the list, if there are no items - return a null
        List <Item> itemList2 = new ArrayList<Item>();
        Item dummyItem = itemList2.stream()
                            .findFirst()
                            .orElse(null);
        System.out.println("Testing 2");
        assert(dummyItem == null);
        
        // Return first item in the list, if there are no items - return default Item
        // In this case we construct a new Item and return object.
        List <Item> itemList3 = new ArrayList<Item>();
        Item dummyItem3 = itemList3.stream()
                            .findFirst()
                            .orElse(new Item());
        System.out.println("Testing 3");
        assert(dummyItem3.getName().equals(ItemConstant.ITEM_NAME));
    }
}
