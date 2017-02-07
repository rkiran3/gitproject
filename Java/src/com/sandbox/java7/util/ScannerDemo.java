package com.sandbox.java7.util;

import java.util.Scanner;

/*
    Program to read input using Scanner
*/
public class ScannerDemo {

    public static void main(String [] args) {

        /*******************************************************/
        // Read user input from console
        //        Enter Count: 2
        //        Enter Input: One
        //        Record: One
        //        Enter Input: Two
        //        Record: Two
        /*******************************************************/
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Count: ");
        int count = scanner.nextInt();

        while (count-- > 0) {
            System.out.print("Enter Input: ");
            String record = scanner.next();
            System.out.println("Record: " + record);
        }
    }
}
