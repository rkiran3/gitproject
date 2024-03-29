package com.sandbox;

import java.util.Map;
import java.util.HashMap;

/**
 * Check for existence of Key in a Map
 */
public class ContainsKeyInMapDemo {

    public static Map<String, Integer> STATES_MAP = new HashMap<String, Integer>();
    static {
        STATES_MAP.put("AK", Integer.valueOf(31));
        STATES_MAP.put("FL", Integer.valueOf(28));
    }
    
    public static void main( String [] args) {

        if (STATES_MAP.keySet().contains("AK")) {
            System.out.println("Found key, value=" + STATES_MAP.get("AK"));
        }
    }
}
