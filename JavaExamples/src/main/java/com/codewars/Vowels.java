package com.codewars;

public class Vowels {

	public static long getCountStreams(String str) {
		long vowelsCount = 0;
		String vowels = "aeiou";
		
		if (str != null) {			
			vowelsCount = str.chars()
				.mapToObj(Character::toChars)
				.map(String::valueOf)
				.filter(e -> vowels.contains(e.toLowerCase()))
				.count();	
		}
		return vowelsCount;
	}

	
	public static int getCount(String str) {
		int vowelsCount = 0;
		String vowels = "aeiou";
		
		if (str != null) {
			String[] tokens = str.toLowerCase().split("");
			for (String token : tokens) {
				if (vowels.contains(token)) {
					vowelsCount++;
				}
			}
		}
		return vowelsCount;
	}
	
	public static void main(String[] args) {
		String input = "A common way to deal with this situation is to remove all of the vowels from the trolls' comments, neutralizing the threat."; 
		System.out.println(getCount(input));	
		System.out.println(getCountStreams(input));
	}
}
