package com.sandbox;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class HashMapDemo {
    public static void main(String [] args) {
        Map <String, Integer>testMap = new HashMap();
        testMap.put("January", 31);
        testMap.put("February", 28);

        for (Map.Entry entry : testMap.entrySet()) {
            System.out.printf("%s:%d\n", entry.getKey(), entry.getValue());
        }
    }
}
