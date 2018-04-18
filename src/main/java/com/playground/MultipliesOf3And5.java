package com.playground;

import java.util.TreeSet;

public class MultipliesOf3And5 {
//    TreeSet<String> set = new TreeSet<String>();
//
//    public static void main(String[] args) {
//        try {
//
//            for (int i = 1; i < 1001; i++) {
//
//            }
//
//        } catch (NullPointerException e) {
//            System.out.println(e);
//            System.out.println("Set doesn't allow null value and duplicate value");
//        }
//    }
    public static void main(String[] args){

        System.out.println("The sum of the multiples of 3 and 5 is: " + getSum());

    }

    private static int getSum() {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
