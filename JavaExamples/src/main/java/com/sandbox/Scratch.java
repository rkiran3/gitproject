package com.sandbox;

/**
 *
 */
public class Scratch {
    public static void main(String []args) {
        int [] arr = {3,3,7,7,10,11,11 };

        for (int i=0; i < arr.length; i++) {
            if (arr[i] == arr[i+1]) {
                i++;
            } else {
                System.out.println("Found single element " + arr[i]);
            }
        }
    }
}
