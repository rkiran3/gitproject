package com.sandbox.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CollectorExercise05 {
    final static Logger log = Logger.getLogger(CollectorExercise05.class.getName());
    
    public static void main(String[] args) {

        log.info("Begin");
        String [] reqKeys = {"Chicago", "Phoenix"};
        List<String> reqKeysList = Arrays.asList(reqKeys);
        
        
        Map <String, String> hashMap = new HashMap<String, String>();
        hashMap.put("Chicago", "60612");
        hashMap.put("Boston", "12345");
        hashMap.put("Phoenix", "76543");
        
        Map <String, String >newMap = 
                reqKeysList.stream()
            .filter(hashMap::containsKey)
            .collect(Collectors.toMap(Function.identity(), hashMap::get));
        
        log.info("After filtering");
        newMap.entrySet().stream()
            .forEach(e -> log.info(e.getKey() + " " + e.getValue()));
    }

}
