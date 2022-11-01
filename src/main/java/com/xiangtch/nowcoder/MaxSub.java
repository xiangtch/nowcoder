package com.xiangtch.nowcoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/25 20:48
 */
public class MaxSub {

    public static void main(String[] args) {
        System.out.println(maxLength(new int[]{2, 3, 4, 5, 4, 3, 2, 1}));
        System.out.println(maxLength("abcabcbbb"));
    }

    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int maxLength(int[] arr) {
        // write code here
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        for (int num : arr) {
            while (queue.contains(num)) {
                queue.poll();
            }
            queue.add(num);
            result = Math.max(result, queue.size());
        }
        return result;
    }

    public static int maxLength(String str) {
        Queue<Character> queue = new LinkedList<>();
        int result = 0;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.add(c);
            result = Math.max(result, queue.size());
        }
        return result;
    }
}
