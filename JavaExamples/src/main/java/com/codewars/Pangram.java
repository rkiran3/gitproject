package com.codewars;

import java.util.*;

public class Pangram {
  public boolean check(String sentence){
    boolean isPangram = false;
    String[] alphaArr = {"a", "b", "c", "d", "e", 
                         "f", "g", "h", "i", "j", 
                         "k", "l", "m", "n", "o", 
                         "p", "q", "r", "s", "t", 
                         "u", "v", "w", "x", "y", "z"};
    List<String> keysList = Arrays.asList(alphaArr) ;
   
    Map<String, Boolean> charCountMap = new HashMap<String, Boolean>();
    
    String[] tokens = sentence.toLowerCase().split("");

    for (String token : tokens) {
      if (keysList.contains(token)) {
        charCountMap.put(token, Boolean.TRUE);
      } 
    }
    
    isPangram = charCountMap.size() == keysList.size();
    
    return isPangram;
    //code
  }
  
  public static void main(String[] args) {
	  Pangram pangram = new Pangram();
      String sentence = "The quick brown fox jumps over the lazy dog.";

	  boolean isPangram = pangram.check(sentence);
	  
	  if (isPangram) {
		  System.out.println(sentence + " is Pangram");
	  } else {
		  System.out.println(sentence + " is not Pangram");
	  }
	  
	  
  }
  
}