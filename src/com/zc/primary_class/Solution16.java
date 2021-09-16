package com.zc.primary_class;

import org.junit.Test;

/**
 * @ClassName Solution16
 * @Description 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/8/18 20:58
 * @Version 1.0
 */
public class Solution16 {
    public double myPow(double x, int n){
        if (x == 1) return 1;
        if (x == 0 && n > 0) return 0;
        if (x == 0 && n < 0) throw new RuntimeException("输入数据非法，请重新输入！");
        double a = x;
        long b = Math.abs((long)n);
        while (b > 1){
            x *= a;
            b--;
        }
        if (n > 0) return x;
        if (n == 0) return 1;
        else return 1/x;
    }

/**
* @Author:ZengChao
* @Description: 数值的整数次方之快速幂解法。
* @Date: 12:01 2021/8/19
* @Param [x, n]
* @return double
**/
    public double myPow1(double x, int n){
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;
        double res = 1;
        long m = n;
        if (n < 0){
            m = -m;
            x = 1/x;
        }
        while (m > 0){
            if ((m & 1) != 0){
                res *= x;
            }
            x *= x;
            m >>= 1;
        }
        return res;
    }

    @Test
    public void mypowTest(){
        System.out.println(myPow1(2.0000, -2147483648));
    }
}
