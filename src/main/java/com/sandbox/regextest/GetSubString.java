package com.sandbox.regextest;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetSubString {

    
    public static void testOrderNumberWithoutHyphens(String input) {
        String regex = "(\\p{Alpha}+)(\\p{Digit}+)(\\p{Alpha}\\p{Digit}+)";    //wordfollowedbydigitsfollowedbywordfollowedbydigits
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
 
        if (matcher.matches()) {
            System.out.println(input + " matches regex: " + regex + " has groupcount: " + matcher.groupCount());
            System.out.println(matcher.group(1) + " " + matcher.group(2) + " " + matcher.group(3));
        } else {
            System.out.println(input + " does NOT matches regex: " + regex);
            
        }
        
        
    }

    
    /**
     * Enter an Order Number that looks like AWS-33-P23
     * extract the subcomponents and print them.
     * @param input
     */
    public static void testOrderNumberWithHyphens(String input) {
        // matches: AWS-33-P12
        // no match: 1122, 1BAWS-AA-P12
        String regex = "(\\p{Alpha}+)-(\\p{Digit}+)-(\\p{Alpha}\\p{Digit}+)";    //word-followedbyhypen-digits-singlewordfollowedbydigits
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
 
        if (matcher.matches()) {
            System.out.println(input + " matches regex: " + regex + " has groupcount: " + matcher.groupCount());
            
            System.out.println(matcher.group(1) + " " + matcher.group(2) + " " + matcher.group(3));
        } else {
            System.out.println(input + " does NOT matches regex: " + regex);
            
        }

        
    }
    
    public static void extractFromXML(String input) {
        
        try {
            String regexStr = "<ItemId>(\\d+)</ItemId><ItemNumber>(\\d+)</ItemNumber>";
            String identifier = "";
            Pattern pattern = Pattern.compile(regexStr);
            Matcher matcher = pattern.matcher(input);
            
            if ((matcher.find())) {
                System.out.println("match found: ItemId: " + matcher.group(1) + " ItemNumber: " + matcher.group(2));
                identifier = String.format("%1s_%2s_", matcher.group(1), matcher.group(2));
            }
            
            File emailFile = File.createTempFile("order_" + identifier, ".xml");
            
            System.out.println(emailFile.getAbsolutePath());
            
            emailFile.deleteOnExit();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {

        extractFromXML("<Items><ItemId>1737313</ItemId><ItemNumber>1708503</ItemNumber><Date>10/24/2018</Date>");
        
        // extract the first portion of string
        String demoString = "60601 / City Of Chicago / IL";
        
        // get the zipcode at begin of string
        String pattern = "(\\d+) /.*";    
        
        if (demoString.matches(pattern)) {
            System.out.println("Matches");
            Pattern p = Pattern.compile(pattern);
            Matcher matcher = p.matcher(demoString);
            
            if (matcher.matches()) {
                if (matcher.group(1).equals("60601")) {
                    System.out.println("Test passes");
                }
            } else {
                System.out.println("There are no matches");
            }
        }

        System.out.println("Testing 2 start");
        String [] tests = { "AWS-33-P12", "1122", "1BAWS-AA-P12"};
        for (String entry: Arrays.asList(tests)) {
            testOrderNumberWithHyphens(entry);
            testOrderNumberWithoutHyphens(entry.replace("-", ""));
        }
        
    }
}
