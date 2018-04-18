package com.playground;

import java.util.Arrays;

public class SmallestNumberInArray {
    public static int getSmallest(int[] a, int total){
        int temp;
        for (int i = 0; i < total; i++)
        {
            for (int j = i + 1; j < total; j++)
            {
                if (a[i] < a[j])
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    System.out.println("i:"+i+"j:"+j+"a-i:"+a[i]+"a-j:"+a[j]+"temp"+temp);
                }
            }
        }
        return a[0];
    }

    public static int getSmallestByArray(int[] a, int total){
        Arrays.sort(a);
        return a[0];
    }

    public static void main(String args[]){
        int a[]={1,2,5,6,3,2};
        int b[]={44,66,99,77,33,22,55};
        System.out.println("Smallest: "+getSmallestByArray(a,6));
        System.out.println("Smallest: "+getSmallestByArray(b,7));

    }
}
