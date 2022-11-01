package com.xiangtch.nowcoder;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/29 12:57
 */
public class FindPeakElement {

    public static void main(String[] args) {
        System.out.println(find(new int[]{2, 0, 1, 9, 7, 8, 4}));
    }

    private static int find(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
