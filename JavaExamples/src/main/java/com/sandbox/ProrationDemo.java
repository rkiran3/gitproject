package com.sandbox;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.Random;

public class ProrationDemo {

    public static BigDecimal getDiscounts(int [] mynum, double discount) {
        BigDecimal discountBD = new BigDecimal(discount).setScale(2);
        BigDecimal[] values = new BigDecimal[mynum.length];
        for (int i=0; i < mynum.length; i++ ) {
            values[i]  = new BigDecimal(mynum[i]).setScale(2);
        }

        double grandTotal = 0.0;
        // Get total of all elements
        for (int i =0; i < values.length; i++) { grandTotal += values[i].doubleValue(); }

        // Calculate percentage to be applied across all elements
        double percent = (discount / grandTotal)  * 100 ;
        BigDecimal percentBD = new BigDecimal(percent).setScale(2, BigDecimal.ROUND_HALF_DOWN);

        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        MathContext mc = new MathContext(4);
        BigDecimal totalDiscountAppliedBD = BigDecimal.ZERO;

        // Iterate each element to calculate proration.
        for (int i=0; i<values.length; i++) {
            BigDecimal orderDiscountBD =
                    percentBD.multiply(new BigDecimal(values[i].doubleValue()))
                            .divide(new BigDecimal(100))
                            .setScale(2, BigDecimal.ROUND_HALF_DOWN);

            // Apply remaining discount to last element
            if (i == values.length-1) {
                orderDiscountBD = discountBD.subtract(totalDiscountAppliedBD);
            }

            System.out.println(String.format("Price: %10s Discount: %10s ",
                    decimalFormat.format(values[i]), orderDiscountBD));

            // Accumulate total discounts applied.
            totalDiscountAppliedBD = totalDiscountAppliedBD.add(orderDiscountBD);
        }

        System.out.println(
                String.format("Total Discount Applied: %14s", totalDiscountAppliedBD.toPlainString()));

        return totalDiscountAppliedBD;
    }

    public static void main(String [] args) {

        int [] intpool = new int [5];
        int max=50, min=1;
        for (int i=0; i<5; i++) {
            intpool[i] = new Random().nextInt((max - min) + 1) + min;
        }

        getDiscounts(intpool, 49.00);
    }
}
