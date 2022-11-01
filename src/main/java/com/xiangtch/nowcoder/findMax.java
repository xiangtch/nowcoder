package com.xiangtch.nowcoder;

import java.util.Arrays;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/8/2 18:44
 */
public class findMax {

    public static void main(String[] args) {
        Integer num = 23193;
        Integer[] arr = new Integer[]{2, 4, 9};
        System.out.println(findMaxNum(num, arr));
    }

    private static Integer findMaxNum(Integer num, Integer[] arr) {
        int numLength = num.toString().length();
        String maxNumStr = "";
        for (int i = 0; i <= numLength; i++){
            int numChar = Integer.parseInt(num.toString().substring(i, i + 1));
            int nearNum = findNearNumFromArr(numChar, arr);
            if (nearNum < 0) {
                return nearNum;
            }
            maxNumStr = maxNumStr + nearNum;
            if (nearNum != numChar) {
                break;
            }
        }

        for (int k = maxNumStr.length(); k < num.toString().length(); k++) {
            maxNumStr = maxNumStr + arr[arr.length - 1];
        }
        return Integer.valueOf(maxNumStr);
    }

    private static int findNearNumFromArr(int numChar, Integer[] arr) {
        System.out.println("numChar: {}" + numChar + ", arr: {}" + Arrays.toString(arr));
        int nearNum = -1;
        for (int i = 0; i <= arr.length; i++) {
            if (numChar == arr[i]) {
                return numChar;
            }
            if (numChar > arr[i]) {
                nearNum = arr[i];
                continue;
            }
            if (numChar < arr[i]) {
                break;
            }
        }
        return nearNum;
    }
}
