package com.zxy.arithmetic.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 8, 9, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }

        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-1-i; j++) {
                // 相邻两两比较
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
