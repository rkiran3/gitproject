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

    public List<Snippet> processFile(Path path) {
        List<Snippet> snippets = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(path);

            // Org file topic 
            String regex = "\\* .*"; // Header line
            String regexDrill = ":.*"; // Drill
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
                } else if (line.matches(regexDrill)) {
                    continue;
                } else if (current != null) {
                    current.contentsList.add(line);
                }
            }

            Snippet snippet = snippetList.get(new Random().nextInt(snippetList.size()));
            System.out.println("====> [" + path + "]");
            System.out.println(snippet.getHeader());
            String contents = snippet.getContentsList().stream()
                .collect(Collectors.joining("\n"));
            System.out.println(contents);
            } catch (Exception ex) {
        }

        return snippets;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter org file name to parse");
            System.exit(-1);
        }
        try {
            ParseOrgFilesIntoTopics parseOrgFile = new ParseOrgFilesIntoTopics();

            Path path = Paths.get(args[0]);
            List<Snippet> snippets = new ArrayList<>();
            if (path != null && path.getFileName() != null) {
<<<<<<< HEAD
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

=======
                boolean isDir = Files.isDirectory(path);
                if (isDir) {
                    List<Path> files = Files.list(path).collect(Collectors.toList());
                    for (Path entry : files) {
                        if (entry.getFileName().toString().endsWith(".org")) {
                            snippets.addAll(parseOrgFile.processFile(entry));
                        }
                    }
                } else {
                    snippets.addAll(parseOrgFile.processFile(path));
                }
>>>>>>> ab369a21c53d22712032677bb4b8c72570f1cbaa
            }

            if (snippets.size() > 0) {
                System.out.println("completed");
            } 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
