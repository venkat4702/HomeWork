package com.playground;

public class LargestPrimeFactor {

    public static int largestPrimeFactor(long number) {
        int i;

        for (i = 2; i <= number; ++i) {
            if (number % i == 0) {
                System.out.println("i:"+i+" number:"+number);
                number = number/i;
                System.out.println("i-2:"+i+" number:"+number);
                i--;
                System.out.println("i-3:"+i+" number:"+number);
            }
            System.out.println("i-99999:"+i+" number:"+number);
        }

        return i;
    }

    public static void main(String[] args) {
        System.out.println(LargestPrimeFactor.largestPrimeFactor(15));
    }
}
