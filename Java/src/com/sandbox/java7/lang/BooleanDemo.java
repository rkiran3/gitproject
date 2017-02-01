package com.sandbox.java7.lang;

public class BooleanDemo {

    public static void main(String [] args) {
        String [] trueStringArray = {"True", "true", "TRUE" };
        String [] falseStringArray = {"yes", "false", "FALSE", "", null};

        //// Test parseBoolean(String s)
        // returns true for {"True", "true", "TRUE" };
        for (String token : trueStringArray) {
            assert (Boolean.parseBoolean(token));
        }
        // returns false for {"yes", "false", "FALSE"};
        for (String token : falseStringArray) {
            assert (!Boolean.parseBoolean(token));
        }

        //// Test valueOf(String s)
        for (String token : trueStringArray) {
            assert (Boolean.valueOf(token).booleanValue());
        }
        for (String token : falseStringArray) {
            assert (!(Boolean.valueOf(token).booleanValue()));
        }
    }
}

