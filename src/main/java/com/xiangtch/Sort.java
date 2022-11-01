package com.xiangtch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/10/10 17:02
 */
public class Sort {

    public static void main(String[] args) {
        System.out.println(sortByGroup("a2d5c1"));
        System.out.println(sortByGroup("321abc"));
        System.out.println(sortByGroup("123"));
        System.out.println(sortByGroup("aa"));
        System.out.println(sortByGroup("a"));
        String str = "aaa";
        System.out.println(str);
    }

    private static String sortByGroup(String str) {
        List<Integer> numIndexList = new ArrayList<>();
        List<Character> numList = new ArrayList<>();
        List<Integer> charIndexList = new ArrayList<>();
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('0' <= c && c <= '9') {
                numList.add(c);
                numIndexList.add(i);
            } else {
                charList.add(c);
                charIndexList.add(i);
            }
        }
        Collections.sort(numList);
        Collections.sort(charList);

        Character[] resultArray = new Character[str.length()];
        for (int i = 0; i < numList.size(); i++) {
            Integer index = numIndexList.get(i);
            Character value = numList.get(i);
            resultArray[index] = value;
        }
        for (int j = 0; j < charList.size(); j++) {
            Integer index = charIndexList.get(j);
            Character value = charList.get(j);
            resultArray[index] = value;
        }
        return Arrays.toString(resultArray);
    }
}
