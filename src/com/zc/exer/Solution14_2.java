package com.zc.exer;

/**
 * @ClassName Solution14_2
 * @Description 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/8/6 10:00
 * @Version 1.0
 */
public class Solution14_2 {
    public int cuttingRope(int n) {
            if(n < 4){
                return n - 1;
            }else if(n == 4){
                return n;
            }
            long res = 1;
            //循环取余
            while(n > 4){
                res *= 3;
                res %= 1000000007;
                n -= 3;
            }
            // 最终剩下来的肯定是2,3,4
            return (int) (res * n % 1000000007);
    }

    public int cuttingRope1(int n) {
        if(n <= 3)
            return n - 1;
        int b = n % 3, p = 1000000007;
        long ret = 1;
        int lineNums=n/3;           //线段被我们分成以3为大小的小线段个数
        for(int i=1;i<lineNums;i++) //从第一段线段开始验算，3的ret次方是否越界。注意是验算lineNums-1次。
            ret = 3*ret % p;
        if(b == 0)
            return (int)(ret * 3 % p);   //刚好被3整数的，要算上前一段
        if(b == 1)
            return (int)(ret * 4 % p);   //被3整数余1的，要算上前一段

        return (int)(ret * 6 % p);       //被3整数余2的，要算上前一段
    }
}
