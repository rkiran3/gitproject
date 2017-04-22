package com.sandbox.java8;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;

class Filter01Item {
    public static enum Type { PERISHABLE, NONPERISHABLE};
    String name;
    Type type;

    public Type getType() { return type; }

    public void setType(Type type) { this.type = type; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Filter01Item(String name, Type itemType) {
        this.name = name;
        this.type = itemType;
    }

    public String toString() { return String.format("%s - %s", name, type); }
}
public class FilterExercise01 {
    public static void main(String []args) {
        List<Filter01Item> itemsList = Arrays.asList(
                new Filter01Item("Perishable", Filter01Item.Type.PERISHABLE),
                new Filter01Item("NonPerishable", Filter01Item.Type.NONPERISHABLE)
        );

        // Print all items of both types
        itemsList
                .stream()
                .filter(item -> item.getType() == Filter01Item.Type.PERISHABLE ||
                    item.getType() == Filter01Item.Type.NONPERISHABLE)
                .collect(toList())
                .forEach(System.out::println);
    }
}
