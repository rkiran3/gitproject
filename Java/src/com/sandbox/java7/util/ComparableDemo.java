package com.sandbox.java7.util;

import java.util.*;

// This class represents a simple Item Object
class Item implements Comparable <Item> {
    String name;

    public Item(String name) {	this.name = name;	}

    public String toString() {	return String.format("[%s]", this.name);    }

    public String getName() {	return name;    }

	@Override
    public int compareTo(Item otherItem) {
        int result = this.getName().compareTo(otherItem.getName());
			
        return result;
    }
}

// This class will construct few Item Objects and sort them
public class ComparableDemo {

    public static void main(String [] args) {
		
        // Create few Item objects and store them in a List
		Item perishableItem = new Item("BPerishableItem");
		Item anotherItem = new Item("APerishableItem");
		Item nonPerishableItem = new Item("NonPerishableItem");
		
        List <Item> itemsList = new ArrayList<Item>();
		itemsList.add(perishableItem);
		itemsList.add(anotherItem);
		itemsList.add(nonPerishableItem);

		Collections.sort(itemsList);
		
		// After sorting, the items are now sorted
		assert (itemsList.get(0)).getName().equals("APerishableItem");
		
		assert (itemsList.get(1)).getName().equals("BPerishableItem");
		
		assert (itemsList.get(2)).getName().equals("NonPerishableItem");
    }
}
