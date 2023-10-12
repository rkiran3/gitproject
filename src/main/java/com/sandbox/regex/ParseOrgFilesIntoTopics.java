package com.sandbox.regex;

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

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter org file name to parse");
            System.exit(-1);
        }
        try {
            Path path = Paths.get(args[0]);
            if (path != null && path.getFileName() != null) {
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
            } else {
                log.info("No file found");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
