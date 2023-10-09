package com.sandbox.regex;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Data;

public class ParseOrgFileHeaders {

    @Data
    public static class Question {
        String name;
        List<String> content;
        List<String> answer;
    }   

    @Data
    public static class Chapter {
        String summary;
        String name;
        List<String> questions;
        List<String> answers;
    }

    public static void main(String... args) {
        try {
            Path path = Paths.get("/home/kiran/Dropbox/org-content/java/OCA-OCPJavaSE8Tests.org");
            List<String> lines = Files.readAllLines(path);
            List<Chapter> chapters = new LinkedList<>();

            Pattern headerPattern = Pattern.compile("^\\* .*"); // line starts with asterisk followed by star and rest of string
            Chapter current = null;
            for (String line : lines) {
                Matcher matcher = headerPattern.matcher(line);
                
                if (matcher.matches()) {
                    String chapRegex = "(Chapter \\d+)";
                    Pattern chapPattern = Pattern.compile(chapRegex);
                    Matcher chapMatcher = chapPattern.matcher(line);
                    if (chapMatcher.find()) {
                        String name = chapMatcher.group(1);
                        System.out.println("Found: " + name);
                        Chapter chapter = new Chapter();
                        chapter.setName(name);
                        current = chapter;
                        chapters.add(chapter);
                    }
                } else {
                    if (current != null) {
                        String quesRegex = "\\s+\\* "; // spaces followed by asterisk
                        Pattern quesPattern = Pattern.compile(quesRegex);
                        q
                    }

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
