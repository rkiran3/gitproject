package com.sandbox.java8;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalDemo {

    public static void main(String[] args) {

        BigDecimal total = new BigDecimal(0);
        //total = total.setScale(2, RoundingMode.HALF_UP);
        total = total.setScale(2, BigDecimal.ROUND_HALF_UP);
        
        
        double [] percentageArr = { 30.73, 2.50, 42.22, 16.76, 7.24, 0.17 };
        
        DecimalFormat numberFormatter = new DecimalFormat("##.##");
        for (int i=0; i <percentageArr.length; i++) {
            total = total.add(new BigDecimal(percentageArr[i]));
        }

        String totalStr = numberFormatter.format(total);
        
        System.out.println(total.doubleValue());
        System.out.println(totalStr);
        
        //
        double r = 5.1234;
        //System.out.println(r); // r is 5.1234

        int decimalPlaces = 2;
        BigDecimal bd = new BigDecimal(r);

        // setScale is immutable
        bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
        r = bd.doubleValue();

        //System.out.println(r); // r is 5.12
    }

}
