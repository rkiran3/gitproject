package com.sandbox.java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This program will show how to collect items that are in each individual item
 * For example, if there were two buyers each buying different items (list of Items)
 * then we can combine all those items into a single List that shows all the items.
 *   
 * @author rkiran
 *
 */
public class FlatMapExercise01 {

	class Buyer {
	    String name;
	    private List<String> product;

	    public String getName() { return name; }

	    public void setName(String name) { this.name = name; }

	    public Buyer(String name, List<String> list) { 
	    	this.name = name;
	    	this.setProduct(list);    
	    }

		public List<String> getProduct() {
			return product;
		}

		public void setProduct(List<String> product) {
			this.product = product;
		}
	}

    public static void main(String [] args) {
    	FlatMapExercise01 flat = new FlatMapExercise01();
    	
    	String [] produce = new String [] {"beans", "carrots"};
    	List <String> produceList = new ArrayList<String>(Arrays.asList(produce));

    	String [] fruits = new String [] {"apples", "oranges"};
    	List <String> fruitsList = new ArrayList<String>(Arrays.asList(fruits));

    	//FlatMapExercise01.Buyer buyer1 = flat.new Buyer("Tim", produceList);
    	
    	Buyer [] buyersArray = {
        		flat.new Buyer ("Tim", produceList),
        		flat.new Buyer ("Tom", fruitsList)
        };

        // Convert array to List of Items
        List <Buyer> buyersList = new ArrayList<Buyer>(Arrays.asList(buyersArray));
    	
//    	buyersList.stream()
//    		.forEach(b -> System.out.println(b.getName()));
        
    	List <String> itemsList = buyersList.stream()
    		.flatMap(b -> b.getProduct().stream())
    		.collect(Collectors.toList());
    	
    	// Print all the items that were bought by Tim and Tom
//    	itemsList.stream()
//    		.forEach(System.out::println);
    	
    	String allItems = itemsList.stream()
    		.collect(Collectors.joining(", "));

    	//System.out.println(allItems);
    	
    	if (!allItems.equals("beans, carrots, apples, oranges")) {
    		System.out.println ("Test fails");
    	}
    	
    }
}
