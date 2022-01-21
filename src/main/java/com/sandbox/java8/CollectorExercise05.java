package com.sandbox.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Get a new HashMap with keys excluded
 *
 * KeysToInclude: "Chicago", "Phoenix"
 * Before
 *		{Chicago=60612, Phoenix=76543, Boston=12345}
 * After
 *		{Chicago=60612, Phoenix=76543}
 */
public class CollectorExercise05 {
    final static Logger log = Logger.getLogger(CollectorExercise05.class.getName());
    
    public static void main(String[] args) {
        log.info("Begin");
        String [] reqKeys = {"Chicago", "Phoenix"};
        List<String> reqKeysList = Arrays.asList(reqKeys);
        
        Map <String, String> hashMap = new HashMap<>();
        hashMap.put("Chicago", "60612");
        hashMap.put("Boston", "12345");
        hashMap.put("Phoenix", "76543");
        
        // referenced in doc
        // Approach to create new HashMap
        System.out.println(hashMap);	// {Chicago=60612, Phoenix=76543, Boston=12345}

        Map <String, String >newMap = 
                reqKeysList.stream()
            .filter(hashMap::containsKey)
            .collect(Collectors.toMap(Function.identity(), hashMap::get));
        System.out.println(newMap);        // {Chicago=60612, Phoenix=76543}

        // referenced in doc
        // Approach: remove keys from existing map
        hashMap.entrySet()
        	.removeIf(e -> !reqKeysList.contains(e.getKey()));
        System.out.println(hashMap);	// {Chicago=60612, Phoenix=76543}
    }
}
