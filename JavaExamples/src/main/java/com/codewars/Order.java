package com.codewars;

/**
 * 

Your task is to sort a given string. Each word in the string will contain a
single number. This number is the position the word should have in the result.

Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).

If the input string is empty, return an empty string. The words in the input
String will only contain valid consecutive numbers.

Examples

"is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"

"4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"

""  -->  ""
 * 
 */

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Order {

	 public static String order(String words) {
		 String outStr = "";
		 
		 // extract index contained in each word
		 Pattern pattern = Pattern.compile("(\\d+)");
		 
		 if (words != null && words.length() > 0) {
			 // split sentence to words
			 String[] tokens = words.split("\\s");
			 
			 if (tokens != null && tokens.length > 0) {
				 String[] outArr = new String[tokens.length];
				 
				 for (String token : tokens) {
					 Matcher matcher = pattern.matcher(token);
					 if (matcher.find()) {
						 String index = matcher.group(0);
						 outArr[Integer.valueOf(index)-1] = token;
					 }
				 }
				 
				 outStr = Arrays.asList(outArr).stream()
				 	.collect(Collectors.joining(" "));
			 }
		 }
		 
		 return outStr;
	 }
	
	public static void main(String[] args) {
		System.out.println("[" + Order.order("is2 Thi1s T4est 3a") + "]");		
		System.out.println(Order.order("4of Fo1r pe6ople g3ood th5e the2"));
		System.out.println("[" + Order.order("") + "]");
	}
}
