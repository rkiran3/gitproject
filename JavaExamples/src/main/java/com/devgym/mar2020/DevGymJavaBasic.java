package com.devgym.mar2020;

public class DevGymJavaBasic {
    public static void main(String[] args) {
        double d = 1.0 / 0;
        System.out.println(d);
    }
}

/*
 * What will be displayed on the screen after the main method is executed as follows?
 * Option 1
 * 		java.lang.ArithmeticException / by zero
 * 
 * Option 2
 * 		0
 * 
 * Option 3:
 * 		Infinity <--- Correct answer
 * Option 3
 */
