package com.xiangtch.sort;

import java.util.Arrays;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/29 14:06
 */
public class MergeSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 3, 5, 6, 2, 4})));
    }

    private static int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int middle = (int) Math.floor(nums.length / 2);
        int[] left = Arrays.copyOfRange(nums, 0, middle);
        int[] right = Arrays.copyOfRange(nums, middle, nums.length);

        return merge(sort(left), sort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }
}
