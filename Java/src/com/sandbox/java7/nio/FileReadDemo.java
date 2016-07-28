package com.sandbox.java7.nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ravikir on 7/28/2016.
 */
public class FileReadDemo {

    public static void main(String [] args) {

        try {
            Map skuMapping = new HashMap<String, String>();
            String fileName = "D:\\CrashPlanBackupFolder\\JADocs\\ItemNumberConversion\\JA_Prod_NewItemNumbers_07262016.txt";
            Charset charset = Charset.forName("US-ASCII");
            int index = 0;
            Map <String, Integer> newSKUMap = new HashMap<String, Integer>();

            for (String line : Files.readAllLines(Paths.get(fileName), charset)) {
                // ...
                // Ignore the first record
                if (index++==0) {
                    continue;
                }
                String [] tokens = line.split("\\t");
                if (tokens == null || tokens.length < 3) {
                    System.out.println("Error in input, token is null or length < 3 ");
                } else {
                    String oldSKU = tokens[0];
                    String newSKU = tokens[1];

                    if (newSKUMap.containsKey(newSKU)) {
                        System.out.println("there is a duplicate newSKU");
                    } else {
                        newSKUMap.put(newSKU, 0);
                    }

                    if (skuMapping.containsKey(oldSKU)) {
                        System.out.println("there is a duplicate oldSKU");
                    } else {
                        skuMapping.put(oldSKU, newSKU);
                    }
                }
                //System.out.println(line);
            }
        } catch (IOException ioEx) {

        }
    }
}
