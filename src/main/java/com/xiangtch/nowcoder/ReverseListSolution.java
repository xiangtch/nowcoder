package com.xiangtch.nowcoder;

import java.util.Collections;

/**
 *  反转链表 - 遍历链表，替换 next 指针
 * @author xiangtch - xiangtch6@gmail.com
 * @date 2021/7/4 12:55
 */
public class ReverseListSolution {

    public static void main(String[] args) {
        reverseList(new ListNode(1));
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        ListNode current = head;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    static class ListNode {
        int value;
        ListNode next = null;
        ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
}
