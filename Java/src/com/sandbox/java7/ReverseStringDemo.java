package com.sandbox.java7;

import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

/**
This program will reverse a string 

*/
public class ReverseStringDemo {

    public static void main(String [] args) {

    String message = "Hello, World";
    System.out.println("Processing String: " + message);
    char [] messageChars = message.toCharArray();
    //
    int begin=0;
    int end = messageChars.length-1;
    while (begin < end) {
        System.out.println("Processing: " + messageChars[begin]);
        char temp = messageChars[begin];
        messageChars[begin] = messageChars[end];
        messageChars[end] = temp;
        begin++;
        end--;
    }
    System.out.println(new String(messageChars));
    }
}
