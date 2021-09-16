package com.zc.primary_class;

/**
 * @ClassName Solution29
 * @Description 剑指 Offer 29. 顺时针打印矩阵
 *              输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/8/31 13:28
 * @Version 1.0
 */
public class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int a = 0,n = matrix[0].length - 1,b = 0,m = matrix.length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int idx = 0;
        while (true){
            for (int i = b;i <= n;i++){
                res[idx++] = matrix[a][i];
            }
            if (++a > m) break;
            for (int i = a;i <= m;i++){
                res[idx++] = matrix[i][n];
            }
            if (b >= n) break;
            for (int i = --n;i >= b;i--){
                res[idx++] = matrix[m][i];
            }
            if (--m < a) break;
            for (int i = m;i >= a;i--){
                res[idx++] = matrix[i][b];
            }
            if (++b > n) break;
        }
        return res;
    }
}
