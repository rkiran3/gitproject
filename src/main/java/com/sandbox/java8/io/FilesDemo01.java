package com.sandbox.java8.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Read in a File using Streams and print selected lines
 */
public class FilesDemo01 {

    public static void main(String [] args) {
        String filePath = "C:\\tmp\\delme.json";

        try {
            Path path = Paths.get(filePath);
            String productPattern = "43CA";

           Files.lines(path)
                   .filter(line -> line.contains(productPattern))
                   .forEach(System.out::println);
            String contents = Files.lines(path)
            	.collect(Collectors.joining());
            System.out.println(contents);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
