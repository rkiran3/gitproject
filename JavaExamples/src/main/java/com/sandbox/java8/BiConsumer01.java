package com.sandbox.java8;

import java.util.function.BiConsumer;

public class BiConsumer01 {

    public static void main(String[] args) {
        BiConsumer<Integer, Integer> demoPrint = 
                (a, b ) -> System.out.println(a + b) ;
                
        demoPrint.accept(new Integer(22), new Integer (44)); // prints 66
       
        printMessage("Hello", "World", (x, y) -> System.out.println(x + y));
        
    }

    static <T>void printMessage(T a, T b, BiConsumer<T, T> c) {
        c.accept(a, b);        
    }
}
