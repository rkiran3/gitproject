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
            String fileName = "D:\\demo.txt";
            Charset charset = Charset.forName("US-ASCII");
            int index = 0;
            Map <String, Integer> newSKUMap = new HashMap<String, Integer>();

            for (String line : Files.readAllLines(Paths.get(fileName), charset)) {
                // ...
                System.out.println(line);
            }
        } catch (IOException ioEx) {

        }
    }
}
