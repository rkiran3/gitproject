package com.sandbox;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 */
public class Scratch {
    public static void main(String []args) {
        int [] intarray = {
                9785818,
                9969733,
                9997229,
                9999036,
                9999428,
                9999816,
                9999875,
                9999919,
                10099077
                };

        int processed = 0;
        for (Integer x : intarray) {

            Integer.parseInt(Integer.toString(x));
            System.out.printf("Processing: %d\n", x);
            processed++;
        }


        if (intarray.length == processed) {
            System.out.println("Success");
        } else {
            System.out.println("Error");

        }

    }
}
