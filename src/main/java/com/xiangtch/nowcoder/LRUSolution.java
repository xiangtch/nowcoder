package com.xiangtch.nowcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  设计LRU缓存结构
 * @author xiangtch - xiangtch6@gmail.com
 * @date 2021/7/4 17:19
 */
public class LRUSolution {

    private static Map<Integer, Node> map = new HashMap<>();
    private static Node head = new Node(-1, -1);
    private static Node tail = new Node(-1, -1);
    private static int k;

    public static void main(String[] args) {
        LRU(new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}}, 3);
    }

    private static int[] LRU(int[][] operators, int k) {

        head.next = tail;
        tail.prev = head;
        LRUSolution.k = k;
        int len = (int)Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] res = new int[len];
        for (int i = 0, j = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else {
                res[j++] = get(operators[i][1]);
            }
        }

        return res;
    }

    private static void set(int key, int val) {
        if (get(key) > -1) {
            map.get(k).val = val;
        } else {
            if (map.size() == k) {
                int rk = tail.prev.key;
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                map.remove(rk);
            }
            Node node = new Node(key, val);
            map.put(key, node);
            moveToHead(node);
        }

    }

    private static int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    private static void moveToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    static class Node {
        int key, val;
        Node prev, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
