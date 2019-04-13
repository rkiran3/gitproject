package com.codingbat.ap1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Start with two arrays of strings, A and B, each with its elements in 
alphabetical order and without duplicates. Return a new array containing 
the first N elements from the two arrays. The result array should be 
in alphabetical order and without duplicates. 
A and B will both have a length which is N or more. 
The best "linear" solution makes a single pass over A and B, 
taking advantage of the fact that they are in alphabetical order, 
copying elements directly to the new array.

mergeTwo(["a", "c", "z"], ["b", "f", "z"], 3) => ["a", "b", "c"]
mergeTwo(["a", "c", "z"], ["c", "f", "z"], 3) => ["a", "c", "f"]
mergeTwo(["f", "g", "z"], ["c", "f", "g"], 3) => ["c", "f", "g"]

*/


public class MatchUp {

    private class MPair {
        private String a;
        private String b;
        public MPair(String a, String b) {
            this.setA(a);
            this.setB(b);
        }
        public String getA() {
            return a;
        }
        public void setA(String a) {
            this.a = a;
        }
        public String getB() {
            return b;
        }
        public void setB(String b) {
            this.b = b;
        }
    }

    
    public static String validate(String []a, String []b, int count) {
        Stream <String>aStream = Stream.of(a);
        Stream <String>bStream = Stream.of(b);
        
        // combine two streams sort and and eliminate duplicates 
        Stream <String>out = Stream.concat(aStream, bStream)    // join the two Streams
                .sorted()       // and sort them alphabetically
                .distinct();    // get only distinct
        
        return out
                .limit(3)
                .collect(Collectors.joining(", "));
    }
    
    public static void main(String[] args) {
        
        final String [] a1 = new String [] { "jan", "feb", "mar", "may"};
        final String [] b1 = new String [] { "jan", "apr", "nov", "dec"}; 

        long count = IntStream.range(0, a1.length)                    // iterate 
            .mapToObj(i ->  new MatchUp().new MPair (a1[i], b1[i]))        // construct a pair using string from both pair
            .filter(p -> (p.getA().length() >= 0 && p.getB().length() >= 0) )
            //.peek( p -> System.out.println(p.getA().charAt(0) + "  " + p.getB().charAt(0)) )
            .filter( p -> {
                //System.out.println(p.getA().charAt(0) == p.getB().charAt(0));
                return (p.getA().charAt(0) == p.getB().charAt(0));  // do the first chars match
                })
            .count();   // keep count of matches
        
        System.out.println("Count: " + count);
    }

}
