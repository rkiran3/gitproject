package com.devgym.may2020;

import java.util.stream.Stream;

public class StreamWhileChallenge {
   
   public static void main(String... doYourBest) {
      String sopranos = "<Tony,Junior,Christopher>";
      
      Stream.of(sopranos)
      	.dropWhile(s -> !s.contains("<"))
        .takeWhile(s -> !s.contains(">"))
        .forEach(System.out::print);
   }
   
}

/*
What will happen after the main method is executed as follows?

javac StreamWhileChallenge.java
java StreamWhileChallenge

Choices - Select all that apply.

Choice 1
This will be displayed:
Tony,Junior,Christopher

Choice 2
Nothing will be displayed. <--correct answer

 
Choice 3
This will be displayed:
<Tony,Junior,Christopher

Choice 4
NullPointerException will be thrown.


At the following line of code, nothing will be dropped 
since the String does have "<". 
The condition !s.contains("<") will be false.

Stream.of(sopranos).dropWhile(s -> !s.contains("<"))


At the next line of code, we would take if the String 
does not contain ">" on which is not true because the 
String does contain ">". The condition will be false and nothing will be taken.

.takeWhile(s -> !s.contains(">"))

So nothing will be printed.


*/