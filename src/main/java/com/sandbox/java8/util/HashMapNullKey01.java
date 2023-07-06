package com.sandbox.java8.util;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 */
@AllArgsConstructor
@Getter
@Setter
public class HashMapNullKey01 {

    /**
     * Function to check if Key exists in HashMap, 
     * Null key can exist in HashMap
     * 
     * @param hm
     * @param key
     * 
     * @return boolean if key exists
     */
    public static boolean checkNullKey(HashMap<String, Integer> hm, String key) {
        boolean keyExists = hm.containsKey(key);
        return keyExists;
    }
    
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Population", Integer.valueOf(20));
        hm.put(null, Integer.valueOf(40));

        System.out.println(HashMapNullKey01.checkNullKey(hm, "Population")); // returns true
        System.out.println(HashMapNullKey01.checkNullKey(hm, null)); // returns true 
    }
}
