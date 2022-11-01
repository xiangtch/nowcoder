package com.xiangtch.nowcoder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/22 16:30
 */
public class Sum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        Set<Integer> setNum = new HashSet<>();
        for(int i = 0; i < m; i++){
            int x = sc.nextInt();
            setNum.add(x);
        }
        int n = sc.nextInt();
        if (2 * n > setNum.size()) {
            System.out.println(-1);
        } else {
            List<Integer> collect = setNum.stream().sorted().collect(Collectors.toList());
            List<Integer> headList = collect.subList(0, n);
            List<Integer> tailList = collect.subList(collect.size() - n, collect.size());
            Integer headSum = headList.stream().reduce(Integer::sum).get();
            Integer tailSum = tailList.stream().reduce(Integer::sum).get();
            System.out.println(headSum + tailSum);
        }
    }
}
