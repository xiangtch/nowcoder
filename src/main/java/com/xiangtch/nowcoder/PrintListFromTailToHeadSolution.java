package com.xiangtch.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author xiangtch - xiangtiancheng@youxin.cloud
 * @date 2022/6/13 17:30
 */
public class PrintListFromTailToHeadSolution {

    public static void main(String[] args) {
        ListNode third = new ListNode(3, null);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(1, second);
//        System.out.println(printListFromTailToHeadByRecursive(first));
//        System.out.println(printListFromTailToHeadByHeadInsert(first));
        System.out.println(printListFromTailToHeadByStack(first));
    }

    /**
     * 使用栈实现，栈具有后进先出的特点
     * @param first 头节点
     * @return 返回结果
     */
    private static List<Integer> printListFromTailToHeadByStack(ListNode first) {
        Stack<Integer> stack = new Stack<>();
        // 入栈
        while (Objects.nonNull(first)) {
            stack.add(first.val);
            first = first.next;
        }

        // 出栈
        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }

    /**
     * 从尾到头反过来打印出每个结点的值
     *      头插入实现
     * @param first 头结点
     * @return 返回列表
     */
    private static List<Integer> printListFromTailToHeadByHeadInsert(ListNode first) {
        // 头插法构建逆序链表
        ListNode head = new ListNode(-1);
        while (Objects.nonNull(first)) {
            ListNode memo = first.next;
            first.next = head.next;
            head.next = first;
            first = memo;
        }
        // 构建 ArrayList
        List<Integer> ret = new ArrayList<>();
        head = head.next;
        while (Objects.nonNull(head)) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    /**
     * 从尾到头反过来打印出每个结点的值
     *   尾递归实现
     * @param first 头结点
     * @return 节点值列表
     */
    private static List<Integer> printListFromTailToHeadByRecursive(ListNode first) {
        List<Integer> result = new ArrayList<>();
        if (Objects.nonNull(first)) {
            result.addAll(printListFromTailToHeadByRecursive(first.next));
            result.add(first.val);
        }
        return result;
    }
}
