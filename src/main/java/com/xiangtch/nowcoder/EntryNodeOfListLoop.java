package com.xiangtch.nowcoder;

/**
 *  链表中环的入口节点 - 双指针解法
 * @author xiangtch - xiangtch6@gmail.com
 * @date 2021/6/28 22:52
 */
public class EntryNodeOfListLoop {

    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        entryNodeOfLoop(pHead);
    }

    private static ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode slow2 = pHead;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
