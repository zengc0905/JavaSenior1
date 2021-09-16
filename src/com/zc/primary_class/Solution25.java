package com.zc.primary_class;

/**
 * @ClassName Solution25
 * @Description 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/8/23 20:38
 * @Version 1.0
 */
public class Solution25 {
    //遍历解法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead =new ListNode(0);
        ListNode cur = newHead;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        while (l1 != null){
            cur.next = l1;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null){
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }
        return newHead.next;
    }

//递归解法
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists1(l1.next,l2);
        }else {
            l2.next = mergeTwoLists1(l1,l2.next);
        }
        return l1.val <= l2.val ? l1 : l2;
    }
}
