package com.sandbox;

import java.util.logging.Logger;

public class CaseDemo01 {
	public final static Logger log = Logger.getLogger(CaseDemo01.class.getName());
	
    public static final Integer PRODUCT_10 = Integer.valueOf(10);
    public static final Integer PRODUCT_20 = Integer.valueOf(20);
    public static final Integer PRODUCT_30 = Integer.valueOf(30);

    public static void main(String [] args) {
        Integer productId = Integer.valueOf(10);
             
        switch (productId.intValue()) {
            case 10:
                log.info("found 10");
                break;
                
            case 20:
                log.info("Found 20");
                break;
                
            default:
                log.info("Default");
                break;
        }
    }
}