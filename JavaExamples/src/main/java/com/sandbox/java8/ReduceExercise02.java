package com.sandbox.java8;

import java.util.stream.IntStream;

import jdk.internal.jline.internal.Log;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.logging.*;

/**
 *
 */
public class ReduceExercise02 {
	
	public static Logger logger = Logger.getLogger(ReduceExercise02.class.getName());
	
	
    public static void main(String [] args) {

    	Supplier <String> msgSupplier = () -> String.format("%s", "Message"); 
    	
    	int grains[] = new int[4];
		int total = IntStream.of(1, 2, 3, 4, 5, 6)
                .reduce(0, (subtotal, element) -> subtotal + element);

		logger.info(new BigInteger("1").toString());
		logger.info(new BigInteger("1").shiftLeft(1).toString());
		
        // total sum
        //assert(10 == total);

        logger.fine("total: " + total);
        logger.log(Level.INFO, msgSupplier);
        System.out.println("This contains a single line of message");
    }
}
