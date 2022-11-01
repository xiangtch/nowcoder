package com.xiangtch.nowcoder;

import java.util.Scanner;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/22 17:04
 */
public class Ball {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[10];
        int sum = 0;
        for(int i = 0; i < 10; i++){
            int num = sc.nextInt();
            scores[i] = num;
            sum += num;
        }
        int minResult = sum;
        for (int first = 0; first <= 5; first++) {
            int firstNum = scores[first];
            for (int second = first + 1; second <= 6; second++) {
                int secondNum = scores[second];
                for (int third = second + 1; third <= 7; third++) {
                    int thirdNum = scores[third];
                    for (int fourth = third + 1; fourth <= 8; fourth++) {
                        int fourthNum = scores[fourth];
                        for (int fifth = fourth + 1; fifth <= 9; fifth++) {
                            int fifthNum = scores[fifth];
                            int left = firstNum + secondNum + thirdNum + fourthNum + fifthNum;
                            int right = sum - left;
                            int result = Math.abs(left - right);
                            if (result == 0) {
                                System.out.println(0);
                                return;
                            }
                            minResult = Math.min(minResult, result);
                        }
                    }
                }
            }
        }
        System.out.println(minResult);
    }
}
