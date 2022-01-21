package com.codingbat.warmup2;

/**
 *
 * Given a string, return a version where all the "x" have been removed.
 * Except an "x" at the very start or end should not be removed.
 stringX("xxHxix") → "xHix"
 stringX("abxxxcd") → "abcd"
 stringX("xabxxxcdx") → "xabcdx"
 */
public class StringX {
    public static void main(String [] args) {
        String input = "xxHxix";
        String substr = input.substring(1, input.length()-1);
        System.out.println(String.format("Input:%s substr:%s", input, substr));
        StringBuffer outputBuffer = new StringBuffer();
        int end = input.length();

        for (int i=0; i<end; i++) {
            if ((i==0 || i == end-1) && (input.charAt(i) == 'x')) {
                outputBuffer.append(input.charAt(i));
            } else {
                if (input.charAt(i) != 'x')
                    outputBuffer.append(input.charAt(i));
            }
        }

        System.out.println(String.format("Input: %s Output: %s", input, outputBuffer.toString()));

    }
}
