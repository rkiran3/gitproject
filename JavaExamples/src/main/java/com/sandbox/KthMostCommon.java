package com.sandbox;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Find the kth most common occurrence in an int array
 * {5, 4, 3, 2, 5, 3, 5}
 * 5 => 3
 * 4 => 1
 * 3 => 2
 * 2 => 1
 *
 * first common occurrence is "5" it occurs 3 times
 * second common occurrence is "3", it occurs 2 times
 */
public class KthMostCommon {

    public static int kthMostCommon(int [] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap();
        // Get the frequency of occurrences and store in Map
        for (int num : nums) {
            int occur = 1;
            if (freqMap.containsKey(num)) {
                occur = freqMap.get(num);
                occur++;
            }
            freqMap.put(num, occur);
        }

        // Store the Values and Keys
        Map <Integer, Integer> valuesMap = new TreeMap();
        for (Map.Entry <Integer, Integer> entries: freqMap.entrySet()) {
            valuesMap.put(entries.getValue(), entries.getKey());
        }

        for (Map.Entry <Integer, Integer> entries: freqMap.entrySet()) {
            System.out.printf("Number: %d Occurs: %d\n",entries.getKey(), entries.getValue());
        }

        Set<Integer> valueKeys = valuesMap.keySet();
        int [] sortedKeysArray = new int[valueKeys.size()];
        int i=0;
        for (Integer value: valueKeys){
            sortedKeysArray[i++] = value;
        }

        return valuesMap.get(sortedKeysArray[sortedKeysArray.length - k]);
    }

    public static void main(String [] args) {
        int k=2;
        System.out.printf("%d most common occurrence is %d ",
            k, kthMostCommon(new int [] {5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 2}, k));
    }
}
