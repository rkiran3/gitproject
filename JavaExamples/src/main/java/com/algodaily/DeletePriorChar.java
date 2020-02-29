package com.algodaily;

import java.util.ArrayList;
import java.util.List;

/**
 * Delete prior character in a String if "$" is found
 * f$st  =>  st  
 * rout$    => rout
 */
public class DeletePriorChar {

    public static String []deleteChar(String [] input) {
        List <String> output = new ArrayList<String>(); 
        int dIndex = 0;
        
        for (int sIndex=0; sIndex < input.length; sIndex++) {
            if (input[sIndex].equals("$") || 
                    ((sIndex+1 < input.length) && input[sIndex+1].equals("$"))) {
                continue;
            } 
            
            dIndex++;
            output.add(input[sIndex]);
        }
        
        return output.toArray(new String[dIndex]);
    }
    public static void main(String[] args) {
        String [] input = { "f", "$", "s", "t" };
        
        String [] output = deleteChar(input);
        
        for (int i=0; i< output.length; i++) {
            System.out.println(output[i]);
        }
    }
}
