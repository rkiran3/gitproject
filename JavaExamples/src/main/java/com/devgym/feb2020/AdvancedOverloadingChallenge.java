package com.devgym.feb2020;
/*
 * Which option gives 
 * efce 
 */
public class AdvancedOverloadingChallenge {
	static String x = "";
	static void executeAction(int ... var) { x += "a"; }
	static void executeAction(Integer var) { x += "b"; }
	static void executeAction(Object var)  { x += "c"; }
	static void executeAction(short var)   { x += "d"; }
	static void executeAction(float var)   { x += "e"; }
	static void executeAction(double var)  { x += "f"; }

	public static void main(String... doYourBest) {
		// 1
		executeAction(1); 	// <-- notice which method is called based on the method signature, it will call executeAction(float var) 
		executeAction(1.0);
		executeAction(Double.valueOf("5"));
		executeAction(1L);
		System.out.println(x);

		// 2
		x="";
		executeAction(Float.valueOf(1));
		executeAction(Double.valueOf(1));
		System.out.println(x);
      
		// 3 
		x= "";
		executeAction(1F); 
		executeAction(1.0D);	
		executeAction();	
		executeAction(1D);
		System.out.println(x);
      
		// 4
		x="";
		executeAction(1F);
		executeAction(1.0);
		executeAction(new StackOverflowError());
		executeAction(1);
		System.out.println(x);
   }

}

/**
 * efce // Option 4 is correct 
 * notice executeAction() results in calling executeAction(int ... var) 
 *
 */
