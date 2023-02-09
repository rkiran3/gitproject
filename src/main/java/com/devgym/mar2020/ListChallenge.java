package com.devgym.mar2020;

import java.util.Arrays;
import java.util.List;

/**
 * Option 1
 * 		[Tyrion, Arya, John]
 * 
 * Option 2
 * 		[Tyrion, Arya, John, Bran]
 * 
 * Option 3
 * 		java.lang.UnsupportedOperationException will be thrown.
 * @author rkiran
 *
 *	Correct Answer is "java.lang.UnsupportedOperationException will be thrown.
 *		Arrays.asList() returns a fixed size list.
 *		Since the returned List is a fixed-size List, we can't add/remove elements.
 */
public class ListChallenge {
	public static void main(final String... doYourBest) {
		final List<String> soldiers = Arrays.asList("Tyrion", "Arya", "John");
		
		if (soldiers.size() > 3) {
			soldiers.add("Cersei");
		} else {
			soldiers.add("Bran");
		}
	
		System.out.println(soldiers);
	}
}
