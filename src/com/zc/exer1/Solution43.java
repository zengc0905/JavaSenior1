package com.zc.exer1;

import org.junit.Test;

/**
 * @ClassName Solution43
 * @Description 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/20 15:07
 * @Version 1.0
 */
public class Solution43 {
    public int countDigitOne(int n) {
        //digit：位数  cur：当前在哪个位上（个十百千......） high：cur的高位  low:cur的低位
        int digit = 1,res = 0;
        int cur = n % 10,high = n / 10,low = 0;
        while (high != 0 || cur != 0){
            if (cur == 0){
                res += high * digit;
            }else if (cur == 1){
                res += high * digit + low + 1;
            }else {
                res += (high + 1) * digit;
            }

            low = cur * digit + low;
            digit *= 10;
            cur = high % 10;
            high /= 10;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(countDigitOne(12));
    }
}
