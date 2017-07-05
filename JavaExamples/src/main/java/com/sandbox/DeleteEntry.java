package com.sandbox;

import java.util.*;

/**
 * Sample Item consists of Color and Inventory
 */
class ItemRecord {
    private String label;
    private int inventory;

    public ItemRecord(String label, int inventory) {this.label = label; this.inventory = inventory;}
    public String toString() { return String.format("%s-%d", label, inventory); }
}

public class DeleteEntry {
    // Helper class to display Item
    public static void printItemRecord(List <ItemRecord> itemRecordList) {
        for (ItemRecord itemRecord : itemRecordList) {
            System.out.println(itemRecord);
        }
    }

    public static void main(String [] args) {
        ItemRecord[] itemArray = {  /* Construct a list of Items */
                new ItemRecord("Red",  1300),
                new ItemRecord("Blue", 1300),
                new ItemRecord("Green", 1321),
                new ItemRecord("Red",   1321),
                new ItemRecord("Blue",  1321)
        };

        // Create a List of those items [Notice the LinkedList(), otherwise we get Modification error]
        List<ItemRecord> itemRecordList = Arrays.asList(itemArray);
        List <String> masterActionRecordTokens = new ArrayList<>();

        // Create a signature of each item and store in a list that will be used to compare later.
        for (ItemRecord itemRecord: itemArray) {
            masterActionRecordTokens.add(itemRecord.toString());
        }

        System.out.println("--Before"); printItemRecord(itemRecordList);

        // Delete specific entries
        Iterator <ItemRecord> iterator = itemRecordList.iterator();
        while (iterator.hasNext()) {
            ItemRecord actionRecord = iterator.next();
            String currToken = actionRecord.toString();
            if (currToken.startsWith("Blue")) {
                String newToken = currToken.replace("Blue", "Red");
                if (masterActionRecordTokens.contains(newToken)) {
                    iterator.remove();
                }
            }
        }

        System.out.println("--After"); printItemRecord(itemRecordList);
    }
}
