package com.xiangtch.nowcoder;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/9/23 10:34
 */
public class XiaoXiaoLe {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        String result = str;
//        String subStr = findSubStr(str);
//        while (subStr != null) {
//            result = result.replaceAll(subStr, "");
//            subStr = findSubStr(result);
//        }
//        System.out.println(result);
//        System.out.println(remainderStr("1233321151"));
        System.out.println(solve("1233321151"));
    }

    private static String solve(String str) {
        int length = str.length();
        for (int i = 1; i < length; ) {
            int start = i - 1;
            if (str.charAt(i) != str.charAt(start)) {
                i++;
            } else {
                do {
                    i++;
                } while (i < str.length() && str.charAt(i) == str.charAt(start));
                str = str.substring(0, start) + str.substring(i);
                length = str.length();
                i = start > 0 ? start : 1;
            }
        }
        return str;
    }

    private static String findSubStr(String str) {
        for (int i = 0; i < str.length(); i++) {
            char head = str.charAt(i);
            int tailOffset = 0;
            for (int j = i + 1; j < str.length(); j++) {
                char tail = str.charAt(j);
                if (head == tail) {
                    tailOffset++;
                } else {
                    break;
                }
            }
            if (tailOffset != 0) {
                return str.substring(i, i + tailOffset + 1);
            }
        }
        return null;
    }

    private static String remainderStr(String str) {
        Stack<Character> characterStack = new Stack<>();
        characterStack.push(str.charAt(0));
        boolean isEqual = false;
        for (int i = 1; i < str.length(); i++) {
            Character head = characterStack.peek();
            if (str.charAt(i) != head) {
                if (isEqual) {
                    characterStack.pop();
                    if (characterStack.isEmpty() || str.charAt(i) != characterStack.peek()) {
                        characterStack.push(str.charAt(i));
                        isEqual = false;
                    } else {
                        isEqual = true;
                    }
                } else {
                    characterStack.push(str.charAt(i));
                }
            } else {
                isEqual = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!characterStack.isEmpty()) {
            Character character = characterStack.pop();
            sb.append(character);
        }
        return sb.reverse().toString();
    }


}
