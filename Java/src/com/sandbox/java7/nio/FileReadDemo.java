package com.sandbox.java7.nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by ravikir on 7/28/2016.
 */
public class FileReadDemo {

    public static void main(String [] args) {

        try {
            String fileName = "D:\\demo.txt";
            Charset charset = Charset.forName("US-ASCII");

            for (String line : Files.readAllLines(Paths.get(fileName), charset)) {
                // ...
                System.out.println(line);
            }
        } catch (IOException ioEx) {
        	ioEx.printStackTrace();
        }
    }
}
