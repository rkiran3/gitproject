package com.sandbox.java7.util;

import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

/**
This program will go through a range of years and find if it 
contains any duplicate digits.

Examples of years with duplicate digits: 
1900    0 is duplicated
1977     7 is duplicated
*/
public class DuplicateDigitsTreeSetDemo {

    public static void main(String [] args) {
        int begin = 1980;
        int end = 1989;
        List <String> dupYearList = new ArrayList<String>();

        System.out.println (String.format("Processing: Begin: %d End: %d ", begin, end));
        for (int i=begin; i<end; i++) {
            // Convert to String representation to find duplicate digits
            String yearStr = String.valueOf(i);
            //System.out.println("Processing: " + yearStr);
            char [] tokens = yearStr.toCharArray();
            Set <Character> charSet = new TreeSet<Character>();
            for (Character c: tokens) {
                charSet.add(c);
            }

            // compare original length with the list without duplicate digits
            // if they differ - then it has duplicate entries
            if (charSet.size() != tokens.length) {
                System.out.println(String.format("Year %s contains duplicate entries", yearStr));
                dupYearList.add(yearStr);
            }
        }
        //
        assert(dupYearList.contains("1988"));

    }
}
