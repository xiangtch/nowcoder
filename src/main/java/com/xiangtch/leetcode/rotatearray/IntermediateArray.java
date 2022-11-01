package com.xiangtch.leetcode.rotatearray;

import java.util.Arrays;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/10/19 22:05
 */
public class IntermediateArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
    }

    private static int[] rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < k; i++) {
            result[i] = nums[nums.length - k + i];
        }
        int j = 0;
        for (int i = k; i < nums.length; i++) {
            result[i] = nums[j];
            j++;
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
        return nums;
    }
}
