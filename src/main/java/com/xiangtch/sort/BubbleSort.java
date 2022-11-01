package com.xiangtch.sort;

import java.util.Arrays;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/29 13:29
 */
public class BubbleSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 4, 5, 2, 3, 6})));
    }

    private static int[] sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 标记没有进行交换，表示前面的已经排好了
            boolean flag = true;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return nums;
    }
}
