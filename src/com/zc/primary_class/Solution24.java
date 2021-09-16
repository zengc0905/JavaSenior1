package com.zc.primary_class;

/**
 * @ClassName Solution24
 * @Description 24.反转链表
 *              定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/8/23 15:08
 * @Version 1.0
 */
public class Solution24 {
    //遍历
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode temp;
        head.next = null;
        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //递归
    public ListNode reverseList1(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
