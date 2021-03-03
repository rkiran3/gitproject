package com.leetcode;

public class Prob771JewelsAndStones {

	/**
	 * Calculate number of Jewels in Stones
	 * 
	 * @param J
	 * @param S
	 * @return
	 */
    public int numJewelsInStones(String J, String S) {
        int counter = 0;
        for(Character c : S.toCharArray()){
            if(J.contains(String.valueOf(c))){
                counter++;
            }
        }
        
        // Java 8 implementation
        long count = S.chars()
                .mapToObj(Character::toChars)
                //.peek(c -> System.out.printf("%s%n", String.valueOf(c)))
                .filter(c -> J.contains(String.valueOf(c)))
                .count();
        
        System.out.println("Count: " + count);
        return counter;
    }
    
    public static void main(String[] args) {
        Prob771JewelsAndStones prob = new Prob771JewelsAndStones();
        // find how many a's and A's are in the target string "aAAbbbb"
        //System.out.println(prob.numJewelsInStones("aA", "aAAbbbb"));
        assert (3 == prob.numJewelsInStones("aA", "aAAbbbb"));
        
        // "z", "ZZ" will not contain any occurrences, since there is no z in ZZ
    }
}
