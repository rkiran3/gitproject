package com.sandbox;

public class CaseDemo01 {
    public static final Integer PRODUCT_10 = new Integer (10);
    public static final Integer PRODUCT_20 = new Integer (20);
    public static final Integer PRODUCT_30 = new Integer (30);

    public static void main(String [] args) {
        Integer productId = new Integer (10);
             
        switch (productId.intValue()) {
            case 10:
                System.out.println("found 10");
                break;
                
            case 20:
                System.out.println("Found 20");
                break;
                
            default:
                System.out.println("Default");
                break;
        }
    }
}