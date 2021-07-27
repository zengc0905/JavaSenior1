package com.zc.exer;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author:ZengChao
 * @Description: 创建一个链表类及相应的方法
 * @Date: 19:46 2021/7/15
 * @Param
 * @return
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    //添加新的节点
    public void add(int newval) {
        ListNode newNode = new ListNode(newval);
        if (this.next == null)
            this.next = newNode;
        else
            this.next.add(newval);
    }

    //打印链表
    public void print() {
        System.out.print(this.val);
        if (this.next != null) {
            System.out.print("-->");
            this.next.print();
        }
    }

    public void print1(ListNode node) {
        while (node != null) {
            if (node.next != null) {
                System.out.print(node.val + "-->");
            } else {
                System.out.println(node.val);
            }
            node = node.next;

        }
    }
}


/**
 * @ClassName Solution06_10
 * @Description 剑指offer第6题
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/7/12 22:29
 * @Version 1.0
 */
public class Solution06 {

    /**
     * @return int[]
     * @Author:ZengChao
     * @Description: 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * @Date: 19:10 2021/7/15
     * @Param [head]
     **/
    public int[] reversePrint(ListNode head) {
//        方法一：
//        ArrayList<Integer> list = new ArrayList();
//        while (head != null){
//            list.add(head.val);
//            head = head.next;
//        }
//        int len = list.size();
//        int[] arr = new int[len];
//        for (int i = 0; i < len; i++) {
//            arr[i] = list.get(len - 1 - i);
//        }
//        return arr;
//        方法二：
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int len = stack.size();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }

    @Test
    public void testReversePrint() {
        ListNode head = new ListNode(1);
        head.add(3);
        head.add(2);
        int[] ints = reversePrint(head);
        System.out.print('[');
        for (int i = 0; i < ints.length; i++) {
            if (i != ints.length - 1)
                System.out.print(ints[i] + ",");
            else
                System.out.print(ints[i]);
        }
        System.out.print(']');
        System.out.println();
        head.print();
        System.out.println();
        head.print1(head);
    }

}
