package com.sandbox;

import java.util.logging.Logger;

/*
 * Program to test String capabilities
 */
public class StringDemo {
    public static Logger logger = Logger.getLogger(StringDemo.class.getName());

    /**
     * Function to take in String and return formatted version
     * Input: 1234567
     * Output: 123-4567
     * 
     * @param value
     * @return formatted string if valid, otherwise 
     */
    public static String customFormat(String value) {
        String output = "";
        if (value == null) {
            return output;
        }
        if (value.length() == 7) {
            StringBuilder sb = new StringBuilder(value.substring(0, 3));
            sb.append("-");
            sb.append(value.substring(3, 7));
            output = sb.toString();
        }
        return output;
    }

    public static void main(String[] args) {
        logger.info("Start");
        String result = StringDemo.customFormat("1234567");
        logger.info("End " + result);
    }
}
