package com.devgym.mar2020;

/*
    what is answer
option: 0
option: java.lang.ArithmeticException 
option: 1   <-- correct Answer
*/
import java.util.function.Function;

public class FunctionChallenge {

    public static void main(String... doYourBest) {
        Function<Integer, Integer> add = x -> x + 2;
        Function<Integer, Integer> sub = x -> x - 2;
        Function<Integer, Integer> div = x -> x / 2;

        Function<Integer, Integer> func = add.andThen(sub).andThen(div);
        
        System.out.println(func.apply(2));
    }
}
