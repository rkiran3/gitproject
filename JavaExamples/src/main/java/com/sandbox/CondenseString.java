package com.sandbox;

public class CondenseString {

    public static String condense(String input) {
        String tokens [] = input.split("\\s+");

        // split the tokens and start with first token
        String result = tokens[0];
        for (int i=0; i< tokens.length-1; i++) {
            String tempResult = result;
            boolean match= false;
            for (int j=tokens[i+1].length(); j>0; j-- ) {
                if (result.endsWith(tokens[i+1].substring(0,j))) {
                    tempResult = result + tokens[i+1];
                    match = true;
                    break;
                }
            }
            if (!match) {
                tempResult = tempResult + " " + tokens[i+1];
            }
            result = tempResult;
        }
        return result;
    }
    public static void main(String []args) {
        String bigMessage = "Some big other";
        System.out.println(condense(bigMessage));

        bigMessage = "Some      metoo    bother";
        System.out.println(condense(bigMessage));
    }
}
