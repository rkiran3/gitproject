package com.sandbox;

enum Type {
    RED(4);
    final Integer wheels;
    Type(int wheels) {
        this.wheels = new Integer(wheels);
    }
}

public class EnumDemo{
    
    public static void main (String [] args) {
        System.out.println("Hello");
        
        Integer value = new Integer(4);
        switch(value) {
            default:
                break;
        }
    }
}