package com.sandbox.java7.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/*
    Program to read input using Scanner
*/
public class ScannerDemo {
    private static Logger logger = Logger.getLogger(ScannerDemo.class.getName());
    public static void main(String [] args) {

        /*******************************************************/
        // Read user input from console
        //        Enter Count: 2
        //        Enter Input: one
        //        Enter Input: two
        /*******************************************************/
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Count: ");
        int count = scanner.nextInt();

        List <String> lines = new ArrayList<>();
        while (count-- > 0) {
            System.out.print("Enter Input: ");
            String record = scanner.next();
            logger.info("Record: " + record);
            lines.add(record);
        }

        logger.info("Write Records to file prepended by record number");
        try {
            FileWriter writer = new FileWriter("C:\\tmp\\records.txt");

            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            int lineNumber=1;
            for (String record: lines) {
                bufferedWriter.write(String.format("%d %s\n", lineNumber++, record));
            }

            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
        logger.info("Program complete");
    }
}
