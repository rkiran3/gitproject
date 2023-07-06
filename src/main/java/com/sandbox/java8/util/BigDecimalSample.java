package com.sandbox.java8.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.logging.Logger;
import java.util.stream.DoubleStream;

/*
 * Function to try BigDecimal samples
 */
public class BigDecimalSample {
    
	public static Logger logger = Logger.getLogger(BigDecimalSample.class.getName());

        /**
     * Uses HALF_UP 
     * 
     * @param d
     * @return
     */
    public static BigDecimal roundingHalfUp(double d, int scale) {
        BigDecimal bd = new BigDecimal(d);

        // setScale is immutable
        bd = bd.setScale(scale, RoundingMode.HALF_UP);
        return bd;
    }

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

        BigDecimal bd = BigDecimalSample.roundingHalfUp(5.1234, 2);
        System.out.println("After Rounding: " + bd.toString());
        System.out.println("Rounding HALF_UP " + bd.toString().equals("5.12"));

        // show ceiling 
        BigDecimal bdCeil = new BigDecimal("75.51");
        // setScale is immutable
        bdCeil = bdCeil.setScale(0, RoundingMode.HALF_UP);

        logger.info("Ceiling : " + bdCeil.toString()); // 
     
        // test to sum array of doubles
        total = BigDecimal.ZERO;
        total = total.setScale(2, RoundingMode.HALF_UP);
        
        double[] percentageArr = { 30.73, 2.50, 42.22, 16.76, 7.24, 0.17 };
        
        DecimalFormat numberFormatter = new DecimalFormat("##.##");
        for (int i=0; i <percentageArr.length; i++) {
            total = total.add(new BigDecimal(percentageArr[i]));
        }

        String totalStr = numberFormatter.format(total);
        
        logger.info("Total Double: " + total.doubleValue());
        logger.info("Total: " +  totalStr);

    }
}
