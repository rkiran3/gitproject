package com;

public class ConstructorChallenge {

    public static void main(String... strings) {
        Homer homer = new Homer();
        homer.printMessage();
    }

    abstract static class Simpson {
        static {
            System.out.println("In Simpson");
        }
    }

    static class Homer extends Simpson {
        static {
            System.out.println("Doh!");
        }

        Homer() {
            System.out.println("In Homer");
        }

        void printMessage() {
            System.out.println("In Homer printMessage");
        }
    }
}
