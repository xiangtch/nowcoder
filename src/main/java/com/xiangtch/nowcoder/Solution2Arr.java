package com.xiangtch.nowcoder;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/23 18:24
 */
public class Solution2Arr {

    public static void main(String[] args) {
        System.out.println(find(151, new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}));
    }

    public static boolean find(int target, int[][] array) {
        int rowNum = array.length;
        if (rowNum == 0) {
            return false;
        }

        int columnNum = array[0].length;
        if (columnNum == 0) {
            return false;
        }

        int rowIndex = rowNum - 1, columnIndex = 0;

        while (rowIndex >= 0 && columnIndex < columnNum) {
            if (array[rowIndex][columnIndex] == target) {
                return true;
            } else if (array[rowIndex][columnIndex] < target) {
                columnIndex++;
            } else {
                rowIndex--;
            }
        }
        return false;

    }
}
