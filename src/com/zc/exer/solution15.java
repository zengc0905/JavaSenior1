package com.zc.exer;

/**
 * @ClassName solution15
 * @Description 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/8/18 19:29
 * @Version 1.0
 */
public class solution15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if (n == 0) return 0;
        int a = (int) Math.pow(2, 30);
        int count = 0;
        while (a > 0) {
            if ((n & a) > 0) {
                count++;
            }
            a >>= 1;
        }
        if (n > 0){
            return count;
        }
        else {
            return ++count;
        }
    }

    /**位运算优化
     观察这个运算：n & (n−1)，其预算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果。
    **/
    public int hammingWeight1(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

}
