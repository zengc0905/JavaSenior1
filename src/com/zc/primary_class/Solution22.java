package com.zc.primary_class;

/**
 * @ClassName Solution22
 * @Description 22.链表中倒数第k个节点
 *              输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/8/21 21:45
 * @Version 1.0
 */
public class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        /*int len = 0;
        ListNode node = head;
        while (node != null){
            len++;
            node = node.next;
        }
        for (int i = 0; i < len - k; i++) {
            head =head.next;
        }
        return head;*/

        //双指针解法
        ListNode former = head,latter = head;
        for (int i = 0; i < k; i++) {
            former = former.next;
        }
        while (former != null){
            latter = latter.next;
            former = former.next;
        }
        return latter;
    }
}
