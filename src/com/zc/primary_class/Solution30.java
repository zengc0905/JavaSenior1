package com.zc.primary_class;

import java.util.Stack;

/**
 * @ClassName Solution30
 * @Description 剑指 Offer 30. 包含min函数的栈
 *              定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 *              调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/5 12:29
 * @Version 1.0
 */
public class Solution30 {
    class MinStack {
        Stack<Integer> A,B;
        public MinStack() {
            //A为数据栈，B为辅助栈
            A = new Stack<>();
            B = new Stack<>();
        }
        public void push(int x) {
            A.add(x);
            if (B.empty() || B.peek() >= x) B.push(x);
        }
        public void pop() {
            if (A.pop().equals(B.peek())) B.pop();
        }
        public int top() {
            return A.peek();
        }
        public int min() {
            return B.peek();
        }
    }

    /*作者：jyd
    链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
