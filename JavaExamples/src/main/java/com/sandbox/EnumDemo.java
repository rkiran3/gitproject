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
        
        System.out.println(Type.RED);
        Type inType = Type.RED;
        
        switch(inType) {
            case RED:
                break;
            default:
                break;
        }
    }
}