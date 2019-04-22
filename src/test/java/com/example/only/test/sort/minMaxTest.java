package com.example.only.test.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Author: created by liguoliang
 * Date: 2019/4/22 11:30 30
 * Version: 1.0
 * Function: 用于
 */
public class minMaxTest {
    public static void main(String[] args) {
        int[] arr = new int[]{12,20,7,-3,0};
        System.out.println("getMax=="+getMax(arr));

        Integer[] temp = {12,20,7,-3,0};
        int min = (int)Collections.min(Arrays.asList(temp));
        int max = (int)Collections.max(Arrays.asList(temp));

        System.out.println("getMAX=="+getMAX(arr));

    }

    public static int getMax(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

    public static int getMAX(int[] arr){
        return Arrays.stream(arr).max().getAsInt();
    }
}
