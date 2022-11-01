package com.xiangtch.nowcoder;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/29 11:10
 */
public class Search {

    public static void main(String[] args) {
        System.out.println(find(new int[]{-1, 0, 3, 4, 6, 10, 13, 14}, 13));
    }

    private static int find(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
