package com.sandbox;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Check for existence of particular attribute in a List of Maps
 * 
 * Find if any month has 31 days. to show "anyMatch"
 *   
 */ 
 public class AnyMatchInListDemo2 {
	 final static Logger log = Logger.getLogger(AnyMatchInListDemo2.class.getName());

    public static void main( String [] args) {
    	
    	log.info("Create a simple List of Maps");
    	List<Map<String, Integer>>  monthsList = new ArrayList<Map<String, Integer>>();
    	    	
    	// create entries to add to list
    	Map<String, Integer> janMap = new HashMap<>();
    	janMap.put("days", Integer.valueOf(31));
    	Map<String, Integer> mayMap = new HashMap<>();
    	mayMap.put("days", Integer.valueOf(31));
    	Map<String, Integer> aprMap = new HashMap<>();
    	aprMap.put("days", Integer.valueOf(30));
    	monthsList.add(janMap); monthsList.add(mayMap); monthsList.add(aprMap);
    	
    	// check if any entry contains a value
    	boolean contains31 = monthsList.stream()
    		.anyMatch(e -> (e.get("days").intValue()) > 30);
    	log.info("contains 31 days " + contains31);
    	
    	boolean contains28 = monthsList.stream()
        		.anyMatch(e -> (e.get("days").intValue()) == 28);
    	log.info("contains 28 days " + contains28);
    }
}
