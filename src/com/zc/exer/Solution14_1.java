package com.zc.exer;

import org.junit.Test;

/**
 * @ClassName Solution14_1
 * @Description 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/8/5 9:40
 * @Version 1.0
 */
public class Solution14_1 {
    //动态规划法
    public int cuttingRope1(int n) {
        int[] dp = new int[n + 1];//dp[i]表示绳子长度为i时的最大乘积
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j < i;j++){
                dp[i] = Math.max(dp[i],Math.max(j * (i -j),j * dp[i - j]));
            }
        }
        return dp[n];
    }

    //数学推导（贪心思想）：尽可能把绳子等分成每段长度为3的小段
    public int cuttingRope2(int n) {
        int a = n / 3;//a为长度为3的段数
        int b = n % 3;//b为最后一段剩余的长度
        if (n <= 3) return n - 1;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;//最后两段3+1拆成2+2
        return (int) Math.pow(3, a) * 2;
    }
    @Test
    public void testCuttinRope(){
        int n = 1;
        System.out.println(cuttingRope1(n));
        System.out.println(cuttingRope2(n));
    }
}
