package com.sandbox.java8;

import java.util.LinkedHashMap;
import java.util.logging.Logger;

/**
 * Find the first non repeating character in a String
 * 
 *
 */
public class HashMapLinkedHashMapExercise01 {
	public static Logger logger = Logger.getLogger(HashMapLinkedHashMapExercise01.class.getName());
	
	public static void main(String[] args) {
		String bigSentence = "refer a reference";
		LinkedHashMap<Character, Integer> charOccurMap = new LinkedHashMap<>();
		
		for (int i=0; i< bigSentence.length(); i++) {
			Character charKey = bigSentence.charAt(i);
		
//			int count = 1;
//			if (charOccurMap.containsKey(charKey)) {
//				count = charOccurMap.get(charKey);
//				count++;
//			}
			charOccurMap.compute(charKey, (k,v) -> v == null ? 1 : v + 1);
			//logger.info(String.format("char %c count %d", charKey, count));
//			charOccurMap.put(charKey, count);
			
		}
		
		for (Character key : charOccurMap.keySet()) {
			Integer value = charOccurMap.get(key);
			
			if (value.equals(1)) {
				logger.info("Found character: " + key + " " + value);
				break;
			}
		}
	}
}
