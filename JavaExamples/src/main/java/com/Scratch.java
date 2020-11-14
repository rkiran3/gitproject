package com;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 */
public class Scratch {
    public static String[] combinations(String[] array) {
        String[] res = new String[(1 << array.length) - 1];
        int k = 0;
        int x = 1;
        for (int i = array.length - 1; i >= 0; --i) {
            res[k++] = array[i];
            for (int j = 1; j < x; ++j) {
                res[k++] = array[i] + res[j - 1];
            }
            x *= 2;
        }
        return res;
    }

    public static void main(String []args) {
    	String[] months = null;
    	java.util.Objects.requireNonNull(months);
    	
    	String[] cities = { "Chicago", "Austin", "Topeka"};
        String[] combination = combinations(cities);

        for (String city: combination) {
            System.out.println(city);
        }

        StringBuffer sb1 = new StringBuffer();
        sb1.append("012345678901234567890");
        
        Stream<String> singleStrs = java.util.regex.Pattern.compile("\\s*")
        	.splitAsStream("a bag sentence");
        
        Map<String, Long> occur = singleStrs.collect(
        		Collectors.groupingBy(
        				Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Map.Entry<String, Long> result = occur.entrySet()
        	.stream()
        	.filter(entry -> entry.getValue() == 1)
        	.findFirst()
        	.orElse(null);
        	
       if(result != null) {
    	   System.out.println("First entry: " + result.getKey());
       }
        
        
        Stream<Character> strChars = Integer.toBinaryString(15)
        	.chars()
        	.mapToObj(i -> (char) i);
        
        
        
        
        java.util.regex.Pattern.compile("\\s*").splitAsStream("wordx")
        	.map(c -> c.charAt(0))
        	.filter(c -> c == 'x')
        	.forEachOrdered(System.out::println);
        
        System.out.println("");
        String word = "wordx";
        IntStream.rangeClosed(0, word.length()-1)
        	.mapToObj(i -> new Character(word.charAt(i)))
        	.filter(c -> (c != 'x'))
        	.forEach(System.out::println);
        //java.util.stream.Stream demoStream = Stream(0, word.length())
        //	.forEach(i -> word[i]);
    }
}
