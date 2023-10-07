package com.sandbox.regex;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Data;
import lombok.extern.java.Log;

@Log
public class ParseOrgFiles {

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
        try {
            Path path = Paths.get("/tmp/python.org");
            if (path != null && path.getFileName() != null) {

                String content = Files.readString(Path.of("/tmp/python.org"));

                // String regex = "(?m)^(\\* .*?)"; // stop after first match of [* ]
                //String regex = "(?s)^(\\* (.*))?";
                //String regex = "(?m)(\\* .*)";
                //String regex = "(?s)^(\\* .*)";
                String regex = "(?m)^(\\*.*(\n.*(?:(?!^\\*))))";

                Pattern pat = Pattern.compile(regex);
                Matcher matcher = pat.matcher(content);

                matcher = pat.matcher(content);
                //System.out.println("Groups: " + matcher.groupCount());
                while (matcher.find()) {
                    for (int i =1; i <= matcher.groupCount(); i++) {
                       System.out.println(String.format("O2-G[%d]: [%s]", i, matcher.group(i)));
                    }
                }
            } else {
                log.info("No file found");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
