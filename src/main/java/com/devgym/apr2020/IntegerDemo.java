package com.devgym.apr2020;

public class IntegerDemo {

    public static void main(String[] args) {

        /*
         * T T F T T F
         * T F T T
         */
        int ii = 10;
        Integer i = 10;
        double dd = 10.0;
        Double d = 10.0;

        System.out.println(i.equals(ii) + "");
        //System.out.println(i.equals(d) + "");
        System.out.println(i == ii);
        System.out.println(i == dd);
        System.out.println(ii == dd);
        System.out.println(ii == d);

    }

}
