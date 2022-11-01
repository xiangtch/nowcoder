package com.xiangtch.leetcode.rotatearray;

import java.util.Arrays;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/10/20 23:14
 */
public class Reversal {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate(new int[]{1, 2, 3, 4, 5, 6}, 2)));
    }

    private static int[] rotate(int[] arr, int order) {
        order = order % arr.length;

        if (arr == null || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        int a = arr.length - order;
        reverse(arr, 0, a - 1);
        reverse(arr, a, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        return arr;
    }

    private static void reverse(int[] arr, int left, int right) {
        if (arr == null || arr.length == 1) {
            return;
        }

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
