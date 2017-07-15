package com.sandbox;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 */
public class Scratch {
    public void print(byte x) {
        System.out.print("byte");
    }
    public void print(int x) {
        System.out.print("int");
    }
    public void print(float x) {
        System.out.print("float");
    }
    public void print(Object x) {
        System.out.print("Object");
    }

    public static void main(String []args) {
        Scratch t = new Scratch();
        short s = 123;
        t.print(s);
        t.print(true);
        t.print(6.789);
    }
}
