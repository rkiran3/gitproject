package com.sandbox.java8.io;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// Extract a string in the email message,  returns
// From: First Last <firstname@name.org>
// We need to extract "First Last"
public class GetSenderNameInEmail {

    public static void main(String[] args) {

        try {
            // Read a file containing message contents
            List<String> lines = Files.lines(Paths.get("c://tmp/message.txt"))
                    .collect(Collectors.toList());

            // From: First Name <firstname@bon.com>
            // first pass - check if any of the input lines contain a "From: "
            String fromLine = lines.stream()
                    .filter(line -> line.startsWith("From:"))
                    .findFirst()
                    .orElse("");

            // Gets all lines in email that contain From: and Subject:
            List<String> wantedlines = lines.stream()
                    .filter(line -> line.startsWith("From:") || line.startsWith("Subject:"))
                    .collect(Collectors.toList());
            System.out.println(wantedlines.size());

            // search for strings with a pattern,
            // the group represents the sender name which we are interested
            Pattern pattern = Pattern.compile("From: (.*) <.*>");
            Matcher matcher = pattern.matcher(fromLine);
            if (matcher.matches()) {
                // remove any quotes surrounding name
                System.out.println(matcher.group(1).replace("\"", ""));
            }

            // System.out.printf("[%s]\n", fromLine);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
