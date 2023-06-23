package com;

public class Demo {

    public static void printObjectSize(Object object) {
        System.out.println("Object type: " + object.getClass() + " :size: " +
                MyAgent.getObjectSize(object));
    }

    public static void main(String[] args) {

        // List<String> months = new ArrayList<>(1);

        // printObjectSize(Integer.valueOf(1));

        // printObjectSize(new ArrayList<String>());

        // printObjectSize(new ArrayList<String>(100));

        System.out.println("End");
    }
}
