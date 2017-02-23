package com.sandbox.java7.lang;

import java.util.HashMap;
import java.util.Map;

public class ScratchDemo {

    public static void main(String[] args) {
        String input = "XXYYX";
        String pattern = "";
        Map<Character, Integer> patternMap = new HashMap();
        String message = "Hello";
        System.out.println(String.format("Actual:[%s] Show max 2 chars:[%.2s]", message, message));
        System.out.println(String.format("Actual:[%s] LeftJustified 10 chars:[%-10s]", message, message));
        System.out.println(String.format("Actual:[%s] RightJustified 10 chars:[%10s]", message, message));
    }
}

