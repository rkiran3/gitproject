package com.sandbox.java8;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.logging.Logger;

public class BigDecimalDemo {
	public static Logger logger = Logger.getLogger(BigDecimalDemo.class.getName());
    public static void main(String[] args) {

        BigDecimal total = BigDecimal.ZERO;
        total = total.setScale(2, RoundingMode.HALF_UP);
        
        double[] percentageArr = { 30.73, 2.50, 42.22, 16.76, 7.24, 0.17 };
        
        DecimalFormat numberFormatter = new DecimalFormat("##.##");
        for (int i=0; i <percentageArr.length; i++) {
            total = total.add(new BigDecimal(percentageArr[i]));
        }

        String totalStr = numberFormatter.format(total);
        
        logger.info("Total Double: " + total.doubleValue());
        logger.info("Total: " +  totalStr);
        
        double r = 5.1234;
        logger.info("double: " + r); // r is 5.1234

        int decimalPlaces = 2;
        BigDecimal bd = new BigDecimal(r);

        // setScale is immutable
        bd = bd.setScale(decimalPlaces, RoundingMode.HALF_UP);
        r = bd.doubleValue();

        logger.info("double after rounding: " + r); // r is 5.12
    }

}
