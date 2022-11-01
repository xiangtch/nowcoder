package com.xiangtch.sort;

import java.util.Arrays;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/10/9 23:46
 */
public class QuickSort2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 3, 6, 5, 2, 4})));
    }

    private static int[] sort(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    private static int[] sort(int[] nums, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(nums, left, right);
            sort(nums, left, partitionIndex - 1);
            sort(nums, partitionIndex + 1, right);
        }
        return nums;
    }

    private static int partition(int[] nums, int left, int right) {
        int i = left, j = right;
        int key = nums[left];

        while (i < j) {
            // 从右往左找第一个小于 key 的值
            while (i < j && nums[j] >= key) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            // 从左往右找第一个大于 key 的值
            while (i < j && nums[j] < key) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = key;
        sort(nums, left, i - 1);
        sort(nums, i + 1, right);
        return i;
    }
}
