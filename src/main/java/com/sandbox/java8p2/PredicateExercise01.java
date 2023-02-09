package com.sandbox.java8p2;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class PredicateExercise01 {

    public static void main(String[] args) {
        final Predicate<String> isCACompany = (s) -> s.contains("CA");
        
        System.out.println(isCACompany.test("BOSTON"));
            
        final Predicate<String> isStatus = (s) -> s.contains("CA");
        BiFunction<String, String, Boolean> isValidStatus = (val1, val2) -> {
        	Boolean retVal= false;
        	if (val1 != null) {
        		retVal = val1.equals(val2);
        	}
        	return retVal;
        };
        
        boolean value = isValidStatus.apply("END", "END2");
        System.out.println(value);
    }
}
