package com.zc.exer;

import org.junit.Test;

/**
 * @ClassName Solution12
 * @Description 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/7/23 20:07
 * @Version 1.0
 */
public class Solution12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0;j < board[0].length;j++){
                if (dsf(board,words,i,j,0))
                    return true;
            }
        }
        return false;
    }

    private boolean dsf(char[][] board,char[] word,int i,int j,int k){
        if (i >= board.length || i < 0 || j < 0 || j >= board[0].length || board[i][j] != word[k])
            return false;
        if (k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dsf(board,word,i + 1,j,k + 1) || dsf(board,word,i - 1,j,k + 1) ||
                dsf(board,word,i,j - 1,k + 1) || dsf(board,word,i,j + 1,k + 1);
        board[i][j] = word[k];
        return res;
    }

    @Test
    public void test1(){
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
