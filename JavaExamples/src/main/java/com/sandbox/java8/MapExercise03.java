package com.sandbox.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class MapExercise03 {
    public static void main(String [] args) {

        Map<String, String> data = new HashMap<String, String>() {{
            put("name", "Middle");
            put("prefix", "Front");
            put("postfix", "Back");
        }};

        String title = Stream.of("prefix", "name", "postfix")
                .filter(data::containsKey)
                .map(data::get)
                .collect(Collectors.joining());
        System.out.println("Title: " + title);
    }
}
