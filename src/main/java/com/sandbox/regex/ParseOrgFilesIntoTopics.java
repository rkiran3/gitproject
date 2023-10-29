package com.sandbox.regex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.extern.java.Log;

@Log
public class ParseOrgFilesIntoTopics {

    /**
     * Create a class to store Header and Content of the Org file block
     * Each block starts with "* " star followed by space 
     * 
     */
    @Data
    public static class Snippet {
        String header;
        List<String> contentsList;
    }

    public static void processFile(Path path) {
        try { 
            List<String> lines = Files.readAllLines(path);
            
            // Org file topic 
            String regex = "\\* .*";
            Snippet current = null;
            boolean isHeader = false;
            List<Snippet> snippetList = new ArrayList<>();
            for (String line: lines) {
                isHeader = line.matches(regex);

                if (isHeader) {
                    Snippet newSnippet = new Snippet();
                    newSnippet.setHeader(line);
                    newSnippet.setContentsList(new ArrayList<>());
                    snippetList.add(newSnippet);
                    current = newSnippet;
                } else if (current != null) {
                    current.contentsList.add(line);
                } else {
                    //System.out.println("Ignoring line: " + line);
                }
            }

            Snippet snippet = snippetList.get(new Random().nextInt(snippetList.size()));
            System.out.println(snippet.getHeader());
            String contents = snippet.getContentsList().stream()
                .collect(Collectors.joining("\n"));
            System.out.println(contents);
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter org file name to parse");
            System.exit(-1);
        }
        try {
            Path path = Paths.get(args[0]);
            if (path != null && path.getFileName() != null) {
                if (Files.isDirectory(path)) {
                    
                    List<Path> orgFiles = Files.list(path)
                        .map(p -> p.toAbsolutePath())
                        .filter(p -> p.getFileName().toString().endsWith("org"))
                        .collect(Collectors.toList());

                    for (Path orgFile : orgFiles) {
                        processFile(orgFile);
                    }
                } else {
                    processFile(path);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
