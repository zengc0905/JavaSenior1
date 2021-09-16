package com.zc.exer1;

import java.util.HashMap;

/**
 * @ClassName Solution35
 * @Description 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/11 15:39
 * @Version 1.0
 */
class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
    }
}

public class Solution35 {

    //方法一：哈希表
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> nodeMap = new HashMap<>();
        Node node = head;
        while (node != null) {
            nodeMap.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while (node != null) {
            nodeMap.get(node).next = nodeMap.get(node.next);
            nodeMap.get(node).random = nodeMap.get(node.random);
            node = node.next;
        }
        return nodeMap.get(head);
    }

    //方法二：拼接+拆分
    public Node copyRandomList1(Node head) {
        if (head == null) return null;
        Node cur = head;
        //1.复制各节点，并构建拼接链表
        while (cur != null) {
            Node temp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = temp;
            cur = temp;
        }
        //2.构建各新节点的random指向
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //3.拆分两链表
        cur = head.next;
        Node pre = head;
        Node head1 = head.next;
        while (cur != null) {
            pre.next = cur.next;
            if (cur.next != null) {
                cur.next = pre.next.next;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return head1;
    }

    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 3. 拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }
}
