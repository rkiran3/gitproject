package com.sandbox.java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This program will show how to collect items that are in each individual item
 * For example, if there were two buyers each buying different items (list of Items)
 * then we can combine all those items into a single List that shows all the items.
 *   
 * Input 
 * BuyersList:   [	
 * 		"Tim", ["beans", "carrots"],
 * 		"Tom", ["apples", "oranges"]
 * ]
 *
 * Output:
 *		["beans", "carrots", "apples", "oranges"]
 *
 */
public class FlatMapExercise01 {

	class Buyer {
	    String name;
	    private List<String> productsList;

	    public String getName() { return name; }

	    public void setName(String name) { this.name = name; }

	    public Buyer(String name, List<String> list) { 
	    	this.name = name;
	    	this.setProductsList(list);    
	    }

		public List<String> getProductsList() {
			return productsList;
		}

		public void setProductsList(List<String> productsList) {
			this.productsList = productsList;
		}
	}

    public static void main(String [] args) {
    	FlatMapExercise01 flatMapExercise = new FlatMapExercise01();
    	
    	List <String> produceList = Arrays.asList("beans", "carrots");
    	List <String> fruitsList = Arrays.asList("apples", "oranges");

    	Buyer[] buyersArray = {
    			flatMapExercise.new Buyer ("Tim", produceList),
    			flatMapExercise.new Buyer ("Tom", fruitsList)
        };

        // Convert array to List of Items
        List<Buyer> buyersList = new ArrayList<>(Arrays.asList(buyersArray));    	
        
    	List<String> itemsList = buyersList.stream()
    		.flatMap(b -> b.getProductsList().stream())
    		.collect(Collectors.toList());
    	
    	String allItems = itemsList.stream()
    		.collect(Collectors.joining(", "));

    	if (!allItems.equals("beans, carrots, apples, oranges")) {
    		System.out.println ("Test fails");
    	}
    	
    }
}
