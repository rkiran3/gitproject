package com.sandbox;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.logging.Logger;

/**
 * Find duplicate filenames and rename file with identifier if found. 
 * replace filename 
 *
 */
public class FindDuplicateFileNamesInList {

    final static Logger log = Logger.getLogger("FindDuplicateFileNamesInList");
    
    public static void main(String[] args) {

        // Create a map of file names, if file name exists - create a copy using filename 
        List <String> srcFullNames = Arrays.asList(
                "C://src//fileA.txt", 
                "C://src//folderB//fileA.txt", 
                "C://src//folderC//fileA.txt", 
                "C://src//Inventory.xls");
        
        // expected filenames
        String [] expecteds = {
                "C://dest//fileA.txt", 
                "C://dest//fileA_copy_1.txt", 
                "C://dest//fileA_copy_2.txt", 
                "C://dest//Inventory.xls",
                };

        Map <String, String> map = new LinkedHashMap<String, String>(); // keep them ordered, easier to test
        String destFolder = "C://dest//";
        for (String srcFullName: srcFullNames) {
            // Get filename from full path
            String fileName = srcFullName.substring(srcFullName.lastIndexOf("//")+2, srcFullName.length());
            
            // construct destination filename
            String destFullName = destFolder + fileName;
            if (!map.containsValue(destFullName)) {
                map.put(srcFullName, destFullName);
            } else { // there must be a copy already
                int copyCount=1;
                // First copy c://dest//fileA_copy_1.txt
                destFullName = destFolder + fileName.substring(0, fileName.lastIndexOf(".")) + "_copy_" + 
                        copyCount + fileName.substring(fileName.lastIndexOf("."), fileName.length());
                // If first copy exists, increment copy counter   c://dest//fileA_copy_2.txt
                if (map.containsValue(destFullName)) {
                    Pattern pattern = Pattern.compile(".*(_copy_(\\d+)).*"); // extract copy counter
                    Matcher matcher = pattern.matcher(destFullName);
                    if (matcher.matches()) {
                        String copyCountStr = matcher.group(2);
                        copyCount = Integer.valueOf(copyCountStr) + 1;  // increment counter
                        destFullName = destFullName.replaceFirst(matcher.group(1), "_copy_"+ copyCount);
                    }
                }
                map.put(srcFullName, destFullName);
            }
        }

        String [] actuals = map.entrySet().stream()
            .map(e -> e.getValue())
            .toArray(String[]::new);

        // Test values
        //assertArrayEquals(expecteds, actuals);
        
        // Logging
        map.entrySet()
            .forEach(e -> log.info(String.format("%-30s %-30s\n", e.getKey(), e.getValue())));
    }

}
