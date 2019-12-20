package com.sandbox.java8p2;

import java.util.function.Predicate;

public class PredicateExercise01 {

    public static void main(String[] args) {

        final Predicate <String> isCACompany = (s) -> s.contains("CA");
        
        System.out.println(isCACompany.test("BOSTON"));
            
    }


}
