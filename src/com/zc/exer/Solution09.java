package com.zc.exer;

import java.util.Stack;

/**
 * @ClassName Solution09
 * @Description 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail
 * 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/7/19 20:14
 * @Version 1.0
 */
public class Solution09 {

}

class CQueue {
//    LinkedList<Integer> listIn;
//    LinkedList<Integer> listOut;
//
//    public CQueue() {
//        listIn = new LinkedList<>();
//        listOut = new LinkedList<>();
//    }
//
//    public void appendTail(int value) {
//        listIn.addLast(value);
//    }
//
//    public int deleteHead() {
//        if (!listOut.isEmpty()) {
//            return listOut.removeLast();
//        }
//        if (listIn.isEmpty()) {
//            return -1;
//        }
//        while (!listIn.isEmpty()) {
//            listOut.addLast(listIn.removeLast());
//        }
//        return listOut.removeLast();
//    }
    //用栈的方式实现
    Stack<Integer> stackIn;//实现入队功能
    Stack<Integer> stackOut;//实现出队功能
    public CQueue(){
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void appendTail(int value){
        stackIn.push(value);
    }

    public int deleteHead(){
        if (!stackOut.isEmpty()){
            return stackOut.pop();
        }
        if (stackIn.isEmpty()){
            return -1;
        }
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
        return stackOut.pop();
    }
}

