package com.xiangtch.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/29 17:11
 */
public class NumSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 6, 9, 24, 11, 14, 5, 10})));
    }

    private static int[] sort(int[] nums) {
        int[] result = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (0 <= nums[i] && nums[i] <=10) {
                result[i] = nums[i];
            } else {
                list.add(nums[i]);
                indexList.add(i);
            }
        }
        Collections.sort(list);

        for (int i = 0; i < indexList.size(); i++) {
            Integer index = indexList.get(i);
            result[index] = list.get(i);
        }
        return result;
    }


}
