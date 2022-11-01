package com.xiangtch.leetcode.rotatearray;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/10/19 23:45
 */
public class BubbleRotate {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
    }

    private static int[] rotate(int[] arr, int order) {
        if (Objects.isNull(arr) || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        for (int i = 0; i < order; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
        return arr;
    }
}
