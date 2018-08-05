package com.sandbox.java8;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class Item {
	private String name;
	private Integer days;
	public Item(String name, Integer days) {
		this.setName(name);
		this.setDays(days);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	
	public String toString() {
		return this.name + " " + this.days;
	}
}

public class PredicateExercise01 {

	// Define a Predicate that will check if a number is greater than specific number
    public static Predicate<Item> equalsDays(final Integer days) {
        return item -> item.getDays().equals(days);
    }

    /**
     * Prints the elements in list that are greater than the argument passed to it.
     */
    public static void printListGreaterThan(List<Item> monthList, int max) {
        monthList
                .stream()
                .filter(equalsDays(max))
                .forEach(System.out::println);

        return;
    }

    public static void main(String[] args) {
        List <Item> itemsList = new LinkedList<Item>();
        itemsList.add(new Item("January", new Integer(30)));
        itemsList.add(new Item("February", new Integer(28)));
        
        Function <Item, Boolean> funcEqDays = (Item i) -> { return i.getDays() > 30; } ;
        
        
        boolean equals31 = false;
			 
		// @formatter:on
        System.out.println("equals31 " + equals31);
        //printListGreaterThan(itemsList, 5);
        
        
        itemsList = null;
        Item first = itemsList.stream()
        	.limit(1)
        	.findFirst()
        	.orElse(null);
        
        System.out.println("First Item: " + first);
    }
}
