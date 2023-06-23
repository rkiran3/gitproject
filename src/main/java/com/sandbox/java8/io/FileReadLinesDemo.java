package com.sandbox.java8.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Read in a File using Streams and print selected lines
 */
public class FileReadLinesDemo {

    public static void main(String [] args) {
        String filePath = "C:\\tmp\\output.csv";

        try {
            Path path = Paths.get(filePath);

            String regex = "[\\p{Alnum}-_]+";    // handle Alphanumeric
            //String regex = "[a-zA-Z0-9-]+"; // works
            List<String> matchedLines = Files.lines(path)
                    //.peek(line -> System.out.printf("Starting: [%s]\n", line))
                    .map(line ->line.trim())
                    //.peek(line -> System.out.printf("After trim: [%s]\n", line))
                    .filter(line -> line.matches(regex))
                    //.peek(line -> System.out.printf("Matched [%s]\n", line))
                    .collect(Collectors.toList());
           System.out.println("Printing Matched Lines");
           matchedLines.stream()
               .forEach(System.out::println);
            
            List<String> unMatchedLines = Files.lines(path)
                    //.peek(line -> System.out.printf("Starting: [%s]\n", line))
                    .map(line ->line.trim())
                    .filter(line -> line.length() >0)
                    //.peek(line -> System.out.printf("After trim: [%s]\n", line))
                    .filter(line -> !line.matches(regex)) 
                    //.peek(line -> System.out.printf("Matched [%s]\n", line))
                    .collect(Collectors.toList());
            System.out.println("Printing UnMatched Lines");
            unMatchedLines.stream()
                .forEach(System.out::println);
            
            System.out.println("End");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
