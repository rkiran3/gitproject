package com.sandbox.regextest;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetSubString {

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
            
            File emailFile = File.createTempFile("Quote_" + identifier, ".xml");
            
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
    }
}
