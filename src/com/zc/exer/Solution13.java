package com.zc.exer;

import org.junit.Test;

/**
 * @ClassName Solution13
 * @Description 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/7/24 20:32
 * @Version 1.0
 */

/*
BFS/DFS ： 两者目标都是遍历整个矩阵，不同点在于搜索顺序不同。
        DFS 是朝一个方向走到底，再回退，以此类推；BFS 则是按照“平推”的方式向前搜索。
        BFS 实现： 通常利用队列实现广度优先遍历

*/


public class Solution13 {
    int m,n;
    boolean[][] visited;//记录[i,j]位置是否访问过，true代表已经访问
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.visited = new boolean[m][n];

        return dfs(m,n,0,0,k);

    }


    //方法一：深度优先遍历DFS
    public int dfs(int m,int n,int i,int j,int k){

        if (i >= m || j >= n || getSum(i) + getSum(j) > k || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(m,n,i + 1,j,k) + dfs(m,n,i,j + 1,k);//向下和向右递推
    }


    /**
    * @Author:ZengChao
    * @Description: 求数位之和
    * @Date: 22:11 2021/7/24
    * @Param [x]
    * @return int
    **/
    public int getSum(int x){
        int s = 0;
        while (x > 0){
            s += x % 10;
            x = x / 10;
        }
        return s;
    }

    @Test
    public void test(){
        System.out.println(movingCount(3, 2, 17));
    }

}
