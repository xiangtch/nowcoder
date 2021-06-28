package com.xiangtch.nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 *  重排链表:
 *      原：L0 -> L1 -> L2 -> ... -> Ln-1 -> Ln
 *      现：L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ...
 * @author xiangtch - xiangtch6@gmail.com
 * @date 2021/6/28 14:13
 */
public class ResetLinkedList {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4};
        ListNode firstNode = buildListNode(array);
        recoderList(firstNode);

    }

    private static void recoderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    private static ListNode buildListNode(int[] array) {
        ListNode firstNode = new ListNode(array[0]);
        ListNode prev = firstNode;
        for (int i = 1; i < array.length; i++) {
            prev.next = new ListNode(i);
            prev = new ListNode(i);
        }
        return firstNode;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
