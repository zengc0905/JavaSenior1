package com.zc.primary_class;

/**
 * @ClassName Solution18
 * @Description 删除链表中的节点：
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/8/20 14:40
 * @Version 1.0
 */

//双指针版
public class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = head;
        ListNode cur = head.next;
        if (head.val == val) return head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) pre.next = cur.next;
        return head;
    }

    //单指针版
    public ListNode deleteNode1(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }

    //递归实现
    public ListNode deleteNode2(ListNode head, int val) {
        if (head.val == val) return head.next;//递归终止条件
        else {
            head.next = deleteNode2(head.next, val);
        }
        return head;
    }

}
