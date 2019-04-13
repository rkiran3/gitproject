package com.codingbat.functional1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Given a list of strings, return a list where each string has "y" added at its start and end.

moreY(["a", "b", "c"]) => ["yay", "yby", "ycy"]
moreY(["hello", "there"]) => ["yhelloy", "ytherey"]
moreY(["yay"]) =>["yyayy"]

 */
public class MoreY {

    public static List <String> moreY(String [] inputArr) {
        
        List <String> outputList = Stream.of(inputArr)
            .map(w -> String.format("y%sy", w))
            //.peek (System.out::println)
            .collect(Collectors.toList());
        
        return outputList;
    }
    public static void main(String[] args) {
        
        // moreY(["a", "b", "c"]) => ["yay", "yby", "ycy"]
        List <String> outList = moreY(new String [] {"a", "b", "c"});
        outList
            .forEach(w -> System.out.println(w));
        
        // moreY(["hello", "there"]) => ["yhelloy", "ytherey"]
        outList = moreY(new String [] {"hello", "there"});
        outList
            .forEach(w -> System.out.println(w));
        
        // moreY(["yay"]) =>["yyayy"]
        outList = moreY(new String [] {"yay"});
        outList
            .forEach(w -> System.out.println(w));
        
    }
}
