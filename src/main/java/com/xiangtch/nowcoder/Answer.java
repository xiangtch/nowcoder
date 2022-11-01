package com.xiangtch.nowcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/22 15:48
 */
public class Answer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] strArr = str.split(",");

        if (strArr.length == 0) {
            System.out.println(0);
        } else if (strArr.length == 1) {
            System.out.println(strArr[0]);
        } else if (strArr.length == 2) {
            int i = strArr[0].compareTo(strArr[1]);
            String result = i > 0 ? strArr[1] + strArr[0] : strArr[0] + strArr[1];
            System.out.println(result);
        } else {
            List<String> list = Arrays.asList(strArr);
            list.sort(Comparator.comparing(Integer::valueOf));
            List<String> preList = list.subList(0, 3);
            int i = preList.get(0).compareTo(preList.get(1));
            String max = i > 0 ? preList.get(0) : preList.get(1);
            String middle = i > 0 ? preList.get(1) : preList.get(0);
            int minSign = middle.compareTo(preList.get(2));
            String min = preList.get(2);
            if (minSign < 0) {
                min = middle;
                 middle = preList.get(2);
                int maxSign = preList.get(2).compareTo(max);
                if (maxSign > 0) {
                    middle = max;
                    max = preList.get(2);
                }
            }
            System.out.println(min + middle + max);
        }
    }
}
