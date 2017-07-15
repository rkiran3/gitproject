package com.sandbox;

import java.util.Scanner;

/**
 *
 */
public class ScannerDemo {
    /* throws a NumberFormatException */
    public static int doublePrice(String number) throws NumberFormatException {
        int doubledPrice = 0;
        try {
            doubledPrice = Integer.parseInt(number) * 2;
        } catch (NumberFormatException nfException) {
            throw nfException;
        }
        return doubledPrice;
    }

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in); // so that we can close in finally if there is an exception.
        try {
            System.out.print("Enter Input: ");
            while (scanner.hasNext()) {
                String input = scanner.next();
                if (input.equals("exit")) {
                    break;
                }

                System.out.println("Doubled Price: " + doublePrice(input));
                System.out.print("Enter Input:");
            }

            // closing the scanner object, any object that implements
            // closeable, must invoke close() method.
            // scanner.close(); will be called in finally.
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            scanner.close();
        }

    }
}
