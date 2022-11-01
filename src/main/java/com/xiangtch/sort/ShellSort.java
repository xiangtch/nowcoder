package com.xiangtch.sort;

import java.util.Arrays;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/29 14:00
 */
public class ShellSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 3, 5, 2, 6, 4})));
    }

    private static int[] sort(int[] nums) {
        int length = nums.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = nums[i];
                int j = i - step;
                while (j >= 0 && nums[j] > temp) {
                    nums[j + step] = nums[i];
                    j -= step;
                }
                nums[j + step] = temp;
            }
        }
        return nums;
    }
}
