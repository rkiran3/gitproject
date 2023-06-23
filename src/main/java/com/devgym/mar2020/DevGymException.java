package com.devgym.mar2020;

/**
 * What is the output being printed.
 * @author rkiran
 *
 */
public class DevGymException {
	  private static IllegalArgumentException illegalArgument;

	    public static void main(String... doYourBest) {
	        try {
	            double exceptionNumber = 2 / 0.0;
                if (exceptionNumber > 0) {
                    System.out.println("Valid");
                }
	            System.out.println("exceptionNumber");

	            throw illegalArgument;
	        } catch (NullPointerException nullPointer) {
	            System.out.println("NullPointer");
	        } catch (IllegalArgumentException illegalArgument) {
	            System.out.println("IllegalArgument");
	        } catch (Exception e) {
	            System.out.println("Exception");
	        } finally {
	            System.out.println("Finally");
	        }
	    }
}

/*
	This deals with exceptions thrown as a result of an operation, 
	- the division happens without any error even thought it appears to cause exception to be thrown.
		this prints "exceptionNumber"
	- then an illegalArgument exception is thrown
		the exceptions are "NullPointerException and IllegalArgumentException 
			- both derived from RuntimeException
	- we end up in NullPointerException 
			thus printing "NullPointer"
	- after all exceptions complete we find ourselves in finally block
	 	printing "Finally"
	 	
	final answer:
		exceptionNumber
		NullPointer
		Finally

*/