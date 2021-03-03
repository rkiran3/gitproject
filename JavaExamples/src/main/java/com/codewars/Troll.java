package com.codewars;

/*
 * 
 * Trolls are attacking your comment section!

A common way to deal with this situation is to remove all of the vowels from the trolls' comments, neutralizing the threat.

Your task is to write a function that takes a string and return a new string with all vowels removed.

For example, the string "This website is for losers LOL!" would become "Ths wbst s fr lsrs LL!".


 */

public class Troll {

	public static String disemvowel(String str) {
		String vowels = "aeiou";
		
		StringBuilder sb = new StringBuilder();
		if (str != null) {
			for (int index = 0; index < str.length(); index++) {
				String initToken = String.valueOf(str.charAt(index)); 
				String token = initToken.toLowerCase();
				if (!vowels.contains(token)) {
					sb.append(initToken);
				}
			}
		}
		
		return sb.toString();
    }
	
	
	public static void main(String[] args) {
		
		String input = "Ths wbst s fr lsrs L[O]L!";
		System.out.println(Troll.disemvowel(input));
	}

}
