package com.sandbox.java8.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

public class BigDecimalSampleTest {
    @Test
    public void testPrintValue() {
        BigDecimalSample.printValue(BigDecimalSample.sumBigDecimal(BigDecimal.ONE, BigDecimal.ONE));
    }

    @Test
    public void testSumBigDecimal() {

        double[] nums = { 0.0, 2.0 };
        Stream.of(Arrays.asList(nums))
            .forEach(System.out::println);

    }
}
