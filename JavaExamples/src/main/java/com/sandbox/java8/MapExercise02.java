package com.sandbox.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
 * Exercise that 
 */
public class MapExercise02 {
	// Class that contains attributes
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
                new Item("00", "Red"),		// Item with Code 00  Value: Red
                new Item("01", "Blue"),		// Item with Code 01
                new Item("00", "Red11"),
                new Item("01", "Blue22"),
                new Item("03", "Green")
        };
        // Convert array to List of Items
        List<Item> items = new ArrayList<Item>(Arrays.asList(itemsArray));

        items.stream().forEach(System.out::println);
        // convert List to Map         Key=Item.Code         Value=List of Items grouped by Code
        // Example: {00=[00:Red, 00:Red11], 01=[01:Blue, 01:Blue22], 03=[03:Green]}
        Map<String, List<Item>> itemsGroupedByCode = items.stream()
                .collect(Collectors.groupingBy(Item::getCode));

        // There are 3 groups based on their codes:      00, 01 and 03 
        System.out.println("Length of Grouped Items: " + itemsGroupedByCode.size());

        System.out.println("Printing all Groups which have size > 1");
        String duplicates = itemsGroupedByCode
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)	// filter based on a predicate
                .map(entry -> {
                    final String duplicateValues = entry.getValue().stream()
                            .map(Item::getDescription)
                            .collect(Collectors.joining(", ", "{", "}"));
                    return String.format("Code: [%1$s] used by %2$s", entry.getKey(), duplicateValues); 
                    })
                .collect(Collectors.joining(", "));

        System.out.println(duplicates);
        // Output:
        // Code: [00] used by {Red, Red11}, Code: [01] used by {Blue, Blue22}

    }
}
