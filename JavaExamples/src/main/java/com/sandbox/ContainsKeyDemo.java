package com.sandbox;

import java.util.Arrays;
//import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;

/**
 * Check for existence of Integer in an Array
 */
public class ContainsKeyDemo {

    public static Map <String, Integer> STATES_MAP = new HashMap<String, Integer>();
    static {
        STATES_MAP.put("AK", new Integer(31));
        STATES_MAP.put("FL", new Integer(28));
    }
    
    public static void main( String [] args) {

        if (STATES_MAP.keySet().contains("AK")) {
            System.out.println("Found key, value=" + STATES_MAP.get("AK"));
        }
    }
}
