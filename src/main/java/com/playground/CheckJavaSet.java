package com.playground;

import java.util.TreeSet;

public class CheckJavaSet {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        TreeSet<String> set = new TreeSet<String>();
        try {
            set.add("hello");
            set.add("world");
            set.add("welcome");
            set.add("all");
            set.add("all");
            set.add("welcome");

            for (String num : set) {
                System.out.println( num);

            }
//            set.add(null);
        } catch (NullPointerException e) {
            System.out.println(e);
            System.out.println("Set doesn't allow null value and duplicate value");
        }

    }

}
