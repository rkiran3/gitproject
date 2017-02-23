package com.sandbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ravikir on 2/19/2017.
 */
public class ListDemo {
    public static void debug(List <String>tmpList) {
        for (String token: tmpList) {
            System.out.println(token);
        }
    }

    public static void main( String [] args) {
        Map<String, List<String>> myMap = new HashMap();
        List <String>firstList = new ArrayList<String>();
        firstList.add("January");
        firstList.add("February");
        debug(firstList);
        myMap.put("months", firstList);

        List <String>secondList = myMap.get("months");
        for (String token: secondList) {
            System.out.println("token = " + token);
        }
        secondList.add("March");

        debug(secondList);
        System.out.println("printing firstList");
        for (String token: myMap.get("months")) {
            System.out.println("token = " + token);
        }
    }
}
