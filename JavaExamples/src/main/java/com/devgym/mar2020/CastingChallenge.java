package com.devgym.mar2020;

/**
java.lang.ClassCastException will be thrown.

9.0

java.lang.ArithmeticException will be thrown

*/

public class CastingChallenge {

    public static void main(String... doYourBest) {
        int number1 = (int)(long)1.0D;
        short number2 = 1;
        Short number3 = (Short)(short)(float) 1.0D;
        Object number4 = (int)(Number) (Double)(Object)(double) 2.0D;
        Double number5 = (double)(int) (char) 2.0D;
        Short number6 = getNumber(Short.valueOf("2"));

        System.out.println(number1 + number2 + number3.doubleValue()
                + Integer.valueOf(number4.toString()) + number5.doubleValue()
                + number6.doubleValue());
    }
    static<T> T getNumber(T number) {
        return number;
    }
}

/*
What will be the output when the main method is executed as follows:

javac CastingChallenge.java
java CastingChallenge

*/