package com.sandbox;

/**
 *
 */
class DemoException extends Exception {
    String name;
    public DemoException(String name) {
        this.name = name;
    }

    public String toString() {
        String message = String.format("%s", this.name);
        return message;
    }
}

public class ExceptionExercise {

    public static void main(String [] args) {
        try {
            String type = "2";
            String typeStr = "1".equals(type) ?  "DemoException" : "Exception";
            if (type.equals("1")) {
                throw new DemoException(typeStr);
            } else {
                throw new Exception(typeStr);
            }
        } catch (DemoException demoEx) {
            System.out.println("Exception thrown from: " + demoEx);
        } catch (Exception ex) {
            System.out.println("Exception thrown from: " + ex);
        }
    }
}
