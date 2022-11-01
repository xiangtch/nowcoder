package com.xiangtch.sort;

import java.util.Arrays;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/29 14:38
 */
public class QuickSort {

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
        // 设定基准值
        int pivot = left;
        int index = pivot + 1;
        // 这里刚好是因为 pivot 为 left，所以 i = index，理论上应该是从 left 开始遍历，i 为实际数组遍历的位置，index 为小于基准值的最新位置
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
