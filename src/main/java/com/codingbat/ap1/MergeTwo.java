package com.codingbat.ap1;

import java.util.ArrayList;
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

class Pair {
    private String a;
    private String b;
    public Pair(String a, String b) {
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


public class MergeTwo {

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
        
        // Test1 - join both and sort distinct
        String [] a = new String [] {"a", "c", "z"};
        String [] b = new String [] {"b", "f", "z"};
        
        String result = MergeTwo.validate(a, b, 3);

        String expected = "a, b, c";
        if (result.equals(expected)) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }
        
        // Test 2 with different data set
        a = new String [] { "a", "c", "z" };
        b = new String [] { "c", "f", "z" };
        expected = "a, c, f";
        
        result = MergeTwo.validate(a, b, 3);

        if (result.equals(expected)) {
            System.out.println("Test success");
        } else {
            System.out.println("error: expected [" + expected + "] got: [" + result + "]");
        }
        
        
        // Test 3 with different data set
        a = new String [] { "f", "g", "z" };
        b = new String [] { "c", "f", "g" };
        expected = "c, f, g";
        
        result = MergeTwo.validate(a, b, 3);

        if (result.equals(expected)) {
            System.out.println("Test success");
        } else {
            System.out.println("error: expected [" + expected + "] got: [" + result + "]");
        }

        final String [] a1 = new String [] { "jan", "feb", "mar", "may"};
        final String [] b1 = new String [] { "jan", "apr", "nov", "dec"}; 
        // println 
        IntStream.range(0, a1.length)                    // iterate 
            .mapToObj(i ->  new Pair (a1[i], b1[i]))
            .collect(ArrayList::new, (c, p) -> {
                    System.out.println("Processing: " + p.getA() + " " + p.getB());
                    c.add(p.getA());
                    c.add(p.getB());
                }, (c1, c2) -> {})
            //.stream()
            //.distinct()
            //.limit(4)
            .forEach(System.out::println);
    }

}
