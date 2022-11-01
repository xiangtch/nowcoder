package com.xiangtch.leetcode.evaluatereversepolishnotaion;

import java.util.Stack;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/10/24 23:36
 */
public class NaiveApproach {

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRpn(tokens));
    }

    private static int evalRpn(String[] tokens) {
        String operators = "+-*/";
        Stack<String> stack = new Stack<>();
        for (String t : tokens) {
            if (!operators.contains(t)) {
                stack.push(t);
            } else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());

                switch (t) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(a - b));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(a / b));
                        break;
                }
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
