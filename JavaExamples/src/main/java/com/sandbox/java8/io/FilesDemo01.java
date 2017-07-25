package com.sandbox.java8.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Read in a File using Streams and print selected lines
 */
public class FilesDemo01 {

    public static void main(String [] args) {
        String filePath = "C:\\tmp\\productInventory.txt";

        try {
            Path path = Paths.get(filePath);
            String productPattern = "43CA";

            Files.lines(path)
                    .filter(line -> line.contains(productPattern))
                    .forEach(System.out::println);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
