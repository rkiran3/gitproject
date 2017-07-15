package com.ctci;

/**
 *
 */
public class ReverseString {
    public static String reverse(String input) {
        char [] outputArray = new char[input.length()];
        char [] inputArray = input.toCharArray();

        for (int i=0; i < input.length(); i++) {
            int end = input.length()- i -1;
            char tmpChar = inputArray[end];
            outputArray[input.length() -i - 1] = inputArray[i];
            inputArray[i] = tmpChar;
        }

        return new String(outputArray);
    }

    public static void main(String [] args) {
        System.out.println(reverse("PLAY"));
    }
}
