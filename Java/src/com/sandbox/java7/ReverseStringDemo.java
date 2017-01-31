package com.sandbox.java7;

import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

/**
This program will go through a range of years and find if it 
contains any duplicate digits.

Examples of years with duplicate digits: 
1900	0 is duplicated
1977 	7 is duplicated
*/
public class ReverseStringDemo {
	
	public static void main(String [] args) {

		String message = "Hello, World";
		
		char [] messageChars = message.toCharArray();
		// 
		int begin=0;
		int end = messageChars.length-1;
		while (begin < end) {
			System.out.println("char: " + messageChars[begin]);
			char temp = messageChars[begin];
			messageChars[begin] = messageChars[end];
			begin++;
			end--;
		}
		
		
		System.out.println(messageChars.toString());
	}
}
