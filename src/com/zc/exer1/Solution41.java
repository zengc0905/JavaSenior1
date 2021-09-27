package com.zc.exer1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Solution41
 * @Description 剑指 Offer 41. 数据流中的中位数
 *   如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *   如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/17 19:18
 * @Version 1.0
 */
public class Solution41 {


}
class MedianFinder{
    /** initialize your data bstructure here. */
    PriorityQueue<Integer> A,B;
    public MedianFinder() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if (A.size() != B.size()){
            A.add(num);
            B.add(A.poll());
        }else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() == B.size() ? (A.peek() + B.peek()) / 2.0 : A.peek();
    }
}
