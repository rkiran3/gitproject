package com.sandbox.java7.lang;

import java.util.HashMap;
import java.util.Map;

public class ScratchDemo {

    public static void main(String[] args) {
        String input = "XXYYX";
        String pattern = "";
        Map<Character, Integer> patternMap = new HashMap();
        String desired = "(.)\\1";
        int index = 1;
        for (Character token: input.toCharArray()){
            if (patternMap.containsKey(token)) {
                pattern += "\\" + patternMap.get(token);
            } else {
                patternMap.put(token, index++);
                pattern += "(.)";
            }
        }
        System.out.println("Pattern: " + pattern);
    }
}

