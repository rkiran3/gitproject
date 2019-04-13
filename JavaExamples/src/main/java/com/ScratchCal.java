package com;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Insured {
    private int id;
    private String name;
    public Insured(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
public class ScratchCal {

    public static void main(String[] args) {
        
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String destination = "C:\\tmp\\anewfolder\\" + dateFormat.format(calendar.getTime()) + "\\";
        
        System.out.println("Check if folder exists: " + destination);
        File destinationFolder = new File(destination);
        try {
            if (destinationFolder.exists()) {
                System.out.println("folder already exists");
            } else {
                boolean result = new File(destination).mkdirs();
                if (!result) {
                    System.out.println("Unable to create folder, exiting program.. ");
                    System.exit(-1);
                } else {
                    System.out.println("folder: " + destinationFolder + " created successfully");
                }
            }

            // Create a new file
            dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmss");
            String newFileName = destinationFolder + "\\nipr_" + dateFormat.format(calendar.getTime()) + "_response.xml";
            System.out.println("Creating new file: " + newFileName);
            
            boolean fileCreate = new File(newFileName).createNewFile();
            if (!fileCreate) {
                System.out.println("Unable to create newFile: " + newFileName);
            }

        } catch (Exception ex) {
            
        }
        
    }
}
