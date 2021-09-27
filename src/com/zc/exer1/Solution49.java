package com.zc.exer1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution49
 * @Description 剑指 Offer 49. 丑数
 *      我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/27 16:11
 * @Version 1.0
 */
public class Solution49 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0,b = 0,c = 0;
        for (int i = 1; i < dp.length; i++) {
            int n2 = dp[a] * 2,n3 = dp[b] * 3,n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n -1];
    }
    @Test
    public void test(){
        System.out.println(nthUglyNumber(11));
//        Integer[] arr = {1,2,3,5};
//        List<Integer> list = Arrays.asList(arr);
//        System.out.println(list.size());
    }
}
