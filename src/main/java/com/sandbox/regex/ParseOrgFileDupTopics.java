package com.sandbox.regex;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class ParseOrgFileDupTopics {

    public static void processFile(String name) {
        Set<String> topicsSet = new HashSet<>();
        try {
            Path path = Paths.get(name);
            //System.out.println(path.toFile());
            String fileName = path.toString();
            File file = path.toFile();
            System.out.println(fileName);
            String newFileName = "";
            int idx = path.toString().lastIndexOf(".");
            int randInt = new Random().nextInt(100);

            newFileName = fileName.substring(0, idx) + "-" + randInt + 
                fileName.substring(idx, fileName.length());
            System.out.println(newFileName);
            Path newPath = Paths.get(newFileName);
            Files.createFile(newPath);
            List<String> lines = Files.readAllLines(path);
            List<String> newLines = new ArrayList<>(lines.size());

            for (String line : lines) {
                if (line.matches("\\*\\s.*")) {
                    if (!topicsSet.contains(line)) {
                        topicsSet.add(line);
                    } else {
                        //System.out.println("Duplicate Topic " + line);
                        String randUUID = UUID.randomUUID().toString();
                        if (line.contains("drill")) {

                        } else {
                            line = line + " " + randUUID;
                        }
                    }
                }
                //newLines.add(line + "\n");
                Files.writeString(newPath, line + "\n", StandardOpenOption.APPEND);
            }
            
        } catch(IOException ioEx) { // IOException if file cannot be read
            ioEx.printStackTrace();
        }
    }

    public static void main(String... args) {
        if (args.length > 0) {
            processFile(args[0]);
        } else {
            System.out.println("Specify File name as argument");
        }
    }
}
