package com.xiangtch.nowcoder;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/6/13 15:50
 */
public class DuplicateSolution {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 1, 0, 2, 3};
        System.out.println(duplicate(arr));
    }

    /**
     * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     *
     * 思路：对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
     * 在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
     * @param arr 数组
     * @return 结果
     */
    private static int duplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                } else {
                    swap(arr, i, arr[i]);
                }
            }
        }
        return 0;
    }

    /**
     * 将 value 上的值与 i 上的值互换
     * @param arr 数组
     * @param i 位置
     * @param value 位置对应的值
     */
    private static void swap(int[] arr, int i, int value) {
        int t = arr[i];
        arr[i] = arr[value];
        arr[value] = t;
    }
}
