package com.zxy.arithmetic.sort;


import java.util.Arrays;

/**
 * 归并排序
 *
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 *
 * 分治算法
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 *
 * https://images2017.cnblogs.com/blog/849589/201710/849589-20171015230557043-37375010.gif
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 12, 4, 1, 10, 3, 8, 20, 5, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        sort(arr, 0, arr.length-1, new int[arr.length]);
    }

    private static void sort(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, tmp);
            sort(arr, mid+1, right, tmp);
            merge(arr, left, mid, right, tmp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int tmpIndex = 0;
        while (i<=mid && j<=right) {
            if (arr[i] <= arr[j]) {
                tmp[tmpIndex++] = arr[i++];
            }else {
                tmp[tmpIndex++] = arr[j++];
            }
        }

        while (i<=mid) {
            tmp[tmpIndex++] = arr[i++];
        }
        while (j <= right) {
            tmp[tmpIndex++] = arr[j++];
        }

        tmpIndex = 0;
        while (left <= right) {
            arr[left++] = tmp[tmpIndex++];
        }
    }

}
