package com;

/**
 *
 */
public class Scratch {
    public static String[] combinations(String[] array) {
        String[] res = new String[(1 << array.length) - 1];
        int k = 0;
        int x = 1;
        for (int i = array.length - 1; i >= 0; --i) {
            res[k++] = array[i];
            for (int j = 1; j < x; ++j) {
                res[k++] = array[i] + res[j - 1];
            }
            x *= 2;
        }
        return res;
    }

    public static void main(String []args) {
        String [] cities = { "Chicago", "Austin", "Topeka"};

        String [] combination = combinations(cities);

        for (String city: combination) {
            System.out.println(city);
        }
    }
}
