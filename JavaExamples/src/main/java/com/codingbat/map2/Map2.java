package com.codingbat.map2;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*Given an array of non-empty strings, create and return a Map<String, String> as follows: 
 * for each string add its first character as a key with its last character as the value.
    pairs(["code", "bug"]) =>{"b": "g", "c": "e"}
    pairs(["man", "moon", "main"]) =>{"m": "n"}
    pairs(["man", "moon", "good", "night"]) =>{"g": "d", "m": "n", "n": "t"}
 * 
 * 
 */

public class Map2 {

    // function to create a new hashmap of key values and return
    // takes each word, 
    // creates key with first character
    // value is last character
    public static Map<String, String> pairs(String [] inputArray) {
        Stream<String> strStream = Stream.of(inputArray);
        
        Map <String, String> strMap = strStream.collect(
                Collectors.toMap(s -> 
                    String.valueOf(s.charAt(0)),  // key 
                    s -> String.valueOf(s.charAt(s.length() - 1)),    // value
                    (k, v) -> { // merge function which handles duplicate key
                            System.out.println("duplicate key found");
                            return k;
                    } ) // value
                );
        return strMap;
    }
    
    public static void main(String[] args) {
        
        String [] strArray1 = {"code", "bug" };
        // expected Map  "c" : "e"     ,   "b" : "g"
        Map <String, String> strMap = pairs(strArray1);
       
        strMap.entrySet()
            .forEach(m -> System.out.println(m.getKey() + ":" + m.getValue()));
        // b:g
        // c:e

        ////////////////////////////////////////
        String [] strArray2 = {"man", "main", "moon"}; // notice there are multiple words with same key
        // expected Map  "m" : "n"
        strMap = pairs(strArray2);
        strMap.entrySet()
        .forEach(m -> System.out.println(m.getKey() + ":" + m.getValue()));
        // m:n
        
    }

}
