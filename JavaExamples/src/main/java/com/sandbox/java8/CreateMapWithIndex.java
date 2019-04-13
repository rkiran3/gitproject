package com.sandbox.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 */
public class CreateMapWithIndex {
    public static void main(String [] args) {
        //IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
    	// Create a Map with index and value
        int [] numbersArray = { 21, 32, 34, 74, 58};
        IntStream.range(0, numbersArray.length)
                .collect(HashMap::new,
                        (hashMap, val) -> hashMap.put(hashMap.size(), numbersArray[val]),
                        (hashMap, val) -> {})
                .forEach((index, val) -> System.out.printf("%d => %d\n", index, val));
        /* Output:
        	0 => 21
        	1 => 32
        	2 => 34
        	3 => 74
        	4 => 58
         */
        
        // Create a Map  with Key: first letter of each token   Value = token
        // a => apple
        // b => banana
        // c => orange
        Stream<String> s = Stream.of("apple", "banana", "orange");
        Map<Character, String> m = s.collect(
                Collectors.toMap(s1 -> s1.charAt(0),
                        s1 -> s1));
        
        /* Prints the map
          	[a] => apple
			[b] => banana
			[o] => orange
        */
        String output = m.entrySet().stream()
        	.map(entry -> String.format("[%1$s] => %2$s", entry.getKey(), entry.getValue()))
        	.collect(Collectors.joining("\n"));
        
        System.out.println(output);
        Arrays.asList(numbersArray).stream();
                //.stream()
        //IntStream.range(0, numbersArray.length).asLongStream()
        //        .collect(
        //                Collectors.toMap(Function.identity(), v-> v));
        
        class Choice {
            public String name;
            public Choice(String name) {
                this.name = name;
            }
            
            public String getName() { return name; }
            
            public String toString() { return "[" + name + "]"; }
        }
        
        List <Choice> choiceList = Arrays.asList(
                new Choice("Red"), 
                new Choice("Black"),
                new Choice("Green")
                );
        
        Map <String, Choice> choiceMap = choiceList.stream()
            .collect(Collectors.toMap(Choice::getName, Function.identity()));
        
        choiceMap.entrySet()
            .forEach(System.out::println);
    }
}
