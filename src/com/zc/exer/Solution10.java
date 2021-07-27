package com.zc.exer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ClassName Solution10
 * @Description 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/7/20 21:28
 * @Version 1.0
 */
public class Solution10 {

    public int fib(int n){
        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(0);
        fib.add(1);
        for (int i = 2; i <= n; i++) {
            fib.add(i,(fib.get(i - 1) + fib.get(i - 2))% (1000000007));
        }
       return fib.get(n);
    }

    //递归法
    public int fib1(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (fib1(n -1) + fib1(n -2)) % 1000000007;
    }

//方法三：动态规划法
    public int fib2(int n){
        int a = 0,b = 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
    * @Author:ZengChao
    * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
     *              求该青蛙跳上一个 n 级的台阶总共有多少种跳法(与斐波那契数列类似)
     *              设跳上 nn 级台阶有 f(n)f(n) 种跳法。在所有跳法中，青蛙的最后一步只有两种情况：
     *              跳上 11 级或 22 级台阶。
    当为 1 级台阶： 剩 n-1个台阶，此情况共有 f(n-1)种跳法；
    当为 2 级台阶： 剩 n-2个台阶，此情况共有 f(n-2)种跳法。

    * @Date: 16:13 2021/7/21
    * @Param [n]
    * @return int
    **/
    public int numWays(int n) {
        int a = 1,b = 1;
        int count;
        for (int i = 0; i < n; i++) {
            count = (a + b) % 1000000007;
            a = b;
            b = count;
        }
        return a;
    }

    
    @Test
    public void testFib(){
        System.out.println(fib2(3));

    }
}
