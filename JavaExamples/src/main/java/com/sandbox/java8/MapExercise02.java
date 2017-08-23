package com.sandbox.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//import static java.util.stream.Collectors.*;


public class MapExercise02 {

    public static class Item {
        public Item(String code, String desc) {
            this.code = code;
            this.description = desc;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        private String code;
        private String description;


        public String toString() {
            return String.format("%s:%s", code, description);
        }
    }

    public static void main(String [] args) {
        Item [] itemsArray = {
                new Item("00", "Red"),
                new Item("01", "Blue"),
                new Item("00", "Red11"),
                new Item("01", "Blue22"),
                new Item("03", "Green")
        };
        List <Item> items = new ArrayList(Arrays.asList(itemsArray));

        items.stream().forEach(System.out::println);

        Map<String, List<Item>> itemsGroupedByCode = items.stream()
                .collect(Collectors.groupingBy(Item::getCode));

        System.out.println("Length: " + itemsGroupedByCode.size());

        String duplicates = itemsGroupedByCode
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(entry -> {
                    final String duplicateValues = entry.getValue().stream()
                            .map(Item::getDescription)
                            .collect(Collectors.joining(", ", "{", "}"));
                    return String.format("Code: [%1$s] used by %2$s", entry.getKey(), duplicateValues);
                })
                .collect(Collectors.joining(", "));

        System.out.println(duplicates);
    }
}
