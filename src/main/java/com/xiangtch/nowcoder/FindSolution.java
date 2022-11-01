package com.xiangtch.nowcoder;

import java.util.Objects;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/6/13 16:19
 */
public class FindSolution {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(find(5, matrix));
        System.out.println(find(20, matrix));
    }

    /**
     * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。因此，从右上角开始查找，
     *      就可以根据 target 和当前元素的大小关系来快速地缩小查找区间，每次减少一行或者一列的元素。
     * @param target 目标值
     * @param matrix 二维数组
     * @return 结果
     */
    private static boolean find(int target, int[][] matrix) {
        if (Objects.isNull(matrix) || Objects.equals(matrix.length, 0) || Objects.equals(matrix[0].length, 0)) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        // 从右上角开始
        int r = 0, c = cols - 1;
        while (r <= rows - 1 && c >=0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }
}
