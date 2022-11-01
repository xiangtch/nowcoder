package com.xiangtch.sort;

import java.util.Arrays;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/29 13:44
 */
public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 3, 4, 6, 5, 2})));
    }

    private static int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            // 找到最小元素下标
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            // 将小数挪到前面
            if (i != min) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
        return nums;
    }
}
