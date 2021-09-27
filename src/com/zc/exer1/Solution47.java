package com.zc.exer1;

/**
 * @ClassName Solution47
 * @Description 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/24 12:15
 * @Version 1.0
 */
public class Solution47 {
    public int maxValue1(int[][] grid) {
        return getMaxValue(grid,0,0);
    }
    public int getMaxValue(int[][] grid,int i,int j){
        int m = grid.length,n = grid[0].length;
        if (i == m -1 && j == n - 1) return grid[i][j];
        if (i == m - 1) return grid[i][j] + getMaxValue(grid,i,j + 1);
        if (j == n - 1) return grid[i][j] + getMaxValue(grid, i + 1, j);
        return grid[i][j] + Math.max(getMaxValue(grid,i + 1,j),getMaxValue(grid,i,j + 1));
    }

    //动态规划
    public int maxValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0){
                    grid[i][j] += grid[i][j - 1];
                }else if (j == 0){
                    grid[i][j] += grid[i - 1][j];
                }else {
                    grid[i][j] = grid[i][j] + Math.max(grid[i - 1][j],grid[i][j - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
