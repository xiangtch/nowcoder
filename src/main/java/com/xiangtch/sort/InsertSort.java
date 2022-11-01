package com.xiangtch.sort;

import java.util.Arrays;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/29 13:51
 */
public class InsertSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 3, 4, 6, 5, 2})));
    }

    private static int[] sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];

            int j = i;
            while (j > 0 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                nums[j] = temp;
            }
        }
        return nums;
    }
}
