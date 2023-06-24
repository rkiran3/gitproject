package com.sandbox.java8.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/*
 * Function to try BigDecimal samples
 */
public class BigDecimalSample {
    
	public static Logger logger = Logger.getLogger(BigDecimalSample.class.getName());
    /**
     * Function to print values.
     * @param args
     */
    public static void printValue(BigDecimal bdVal) {
        if (bdVal != null) {
            logger.info(bdVal.toString());
        }
    }

    /**
     * Add two BigDecimal and return a double
     * @return
     */
    public static BigDecimal sumBigDecimal(BigDecimal num1, BigDecimal num2) {
        BigDecimal result = BigDecimal.ZERO;
        if (num1 != null && num2 != null) {
            result = num1.add(num2);
        }
        return result;
    }

    /** Main program. */
    public static void main(String[] args) {

        BigDecimal one = BigDecimal.ONE;
        BigDecimalSample.printValue(one);

        DecimalFormat df = new DecimalFormat();
        df.applyPattern("$0.00");

        logger.info(df.format(one)); // print $1.00

        BigDecimal total = BigDecimalSample.sumBigDecimal(new BigDecimal("23"), new BigDecimal("33"));
        BigDecimalSample.printValue(total); // prints 55

        double[] nums = { 0.1, 2.0 };
        // DoubleStream.of(nums)
        //     .forEach(System.out::println);

        double result = DoubleStream.of(nums)
            .reduce(0, (d1, d2) -> d1 + d2);
        
        System.out.println(result);
    }
}
