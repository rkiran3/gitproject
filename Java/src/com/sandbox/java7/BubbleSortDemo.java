package com.sandbox.java7;

// This program will sort an array of ints and prints output array
//
public class BubbleSortDemo {
    // input array
    static int [] elements = { 15, 4, 2, 6, 10 };   // after sorting: 4 2 6 10 15

    // Print array
    public static void printArray() {
        //
        for (int i=0; i< elements.length; i++ ){
            System.out.print("[ " + elements[i] + " ] ");
        }
    }

    public static void swap (int index, int index2) {
        int temp = elements[index];
        elements[index] = elements[index+1];
        elements[index+1] = temp;
    }

    public static void main(String []args) {
        int n=5;
        do {
            int newn=0;
            BubbleSortDemo.printArray();
            for (int i = 0; i < elements.length - 1; i++) {
                if (elements[i] > elements[i + 1]) {
                    swap(i, i + 1);
                    newn = i;
                }
            }
            System.out.println("");
            n = newn;

        } while (n !=0 );
    }
}
