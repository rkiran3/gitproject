package com.devgym.mar2020;


/**
 * https://nobugsproject.com/2017/06/20/java-challenge-5-logical-and-bitwise-operators/
 * javachallengers.com
 * 
 * @author rkiran
 *
 */
public class LogicalOperatorsChallenges {
	
	public static void main(String... args) {
		int spiderMan = 10;
	    int venom = 5;
	    int carnage = 50;

	    // spiderMan remains at 11
	    // & operator still tests for true or false
	    // in this case spiderMan is still 11, 
	    // venom is first checked for 5 and then increments to 6
	    // 10 == 11(false) 	&     5 == 5(true)
	    // (false & true)
	    /* The second condition will be checked,
	    even if the first condition is false,
	     this can be useful when you want to
	    execute a command in every situation on your conditions. */
	    if (spiderMan == 11 & venom++ == 5) {
	        venom++;
	    }
	    // sm = 10      v = 6
	    
	    
	    /*
	     * carnage increments to 51 prior to checking, spiderman 
	     */
	    // (carnage 51 == 50 | spiderman 10 == 11 | spiderMan 11 == 12
	    //						spiderMan 11 == 13 |  spiderMan 12 == 14
	    // (true	| false |	false | false | false)
	    if (++carnage == 50 | spiderMan++ == 11 | spiderMan++ == 12 | 
	                          spiderMan++ == 13 | spiderMan++ == 14) {
	        venom++;
	    }
	    // c=51 , sm=14,    v=6
	    
	    
	    /**
	     * spider
	     */
	    // (spiderMan 15 == 14 | spiderMain 16 == 15 & venom 6 == 6 & spiderMain 17 == 13)
	    // (false	|	(false & true)	| false)
	    // false	|	false 			| false
	    // false
	    if (++spiderMan == 14 | spiderMan++ == 15 & venom++ == 6 & spiderMan == 13) {
	        spiderMan++;
	    }
	    // sm=16,  v=7,  c=51
	    
	    System.out.println(spiderMan + venom + carnage);
				
	}
}

/*
	17 + 6 + 51 = 74	<-- correct answer
*/