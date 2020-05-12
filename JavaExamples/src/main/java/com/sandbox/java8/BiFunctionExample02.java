package com.sandbox.java8;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.logging.Logger;

/**
 *
 */
public class BiFunctionExample02 {

    static BiFunction<Integer, Integer, Integer> powerOf =
            (n1, n2) ->  (n2 == 1) ? 
            		n1 : 
            			n1 * BiFunctionExample02.powerOf.apply(n1, (n2-1));

	
	public static void main(String []args) {
    	Logger logger = Logger.getLogger(BiFunctionExample02.class.getName());
        logger.info(String.valueOf(powerOf.apply(8, 3)));
        
        Scanner scanner = new Scanner(System.in);
        int num = 153;
        System.out.println(num);
        System.out.println("End");
        int temp = num;
        int count = 1;
        long totalSum = 0;
        int totalDigits = (int) (Math.log10(num) + 1);
        while(temp > 0) {
        	int digit = temp % 10;
        	temp = temp / 10;
        	//logger.info("digit:[" + count + "] "  + digit);
        	count++;
        	
        	totalSum += powerOf.apply(digit, totalDigits);
        }
        
        logger.info("Total Sum: " + totalSum);
    }
}
