package com.xiangtch.nowcoder;

/**
 *  判断链表中是否有环 - 快慢指针解决
 * @author xiangtch - xiangtch6@gmail.com
 * @date 2021/7/4 12:38
 */
public class HasCycleSolution {

    public static void main(String[] args) {
        hasCycle(new ListNode(1));
    }

    private static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
