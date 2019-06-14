package com.sandbox.java8;

import org.junit.Assert;

public class ArrayEqualsDemo {

    public static void testArrayEquals() {
        class Item1 {
            String name;
            Item1(String name) { this.name = name;}
        }

        Item1 itemA = new Item1("Jan");
        Item1 itemB = new Item1("Feb");
        Item1 itemC = new Item1("Jan");
        Item1 itemD = new Item1("Feb");
        
        Item1 [] actualArr = new Item1[] { itemA, itemB };        
        Item1 [] expectedArr = new Item1[] { itemC, itemD };

        Assert.assertArrayEquals(expectedArr, actualArr);
        
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        testArrayEquals();
    }

}
