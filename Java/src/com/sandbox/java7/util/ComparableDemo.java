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
		
        // Create few Item objects
		Item perishableItem = new Item("APerishableItem");
		Item anotherItem = new Item("BPerishableItem");
		Item nonPerishableItem = new Item("NonPerishableItem");
		
        List <Item> itemsList = new ArrayList<Item>();
		itemsList.add(perishableItem);
		itemsList.add(anotherItem);
		itemsList.add(nonPerishableItem);

		Collections.sort(itemsList);
		
		for (Item item: itemsList){
			System.out.println(item);
		}
    }
}
