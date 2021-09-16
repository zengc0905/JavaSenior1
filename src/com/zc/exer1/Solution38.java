package com.zc.exer1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Solution38
 * @Description 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/14 14:10
 * @Version 1.0
 */
public class Solution38 {
    List<String> res = new LinkedList<>();
    char[] chars;
    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    public void dfs(int x) {
        if (x == chars.length - 1) {
            res.add(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(chars, i, x);
            dfs(x + 1);
            swap(chars, i, x);
        }
    }

    void swap(char[] chars, int m, int n) {
        char temp = chars[m];
        chars[m] = chars[n];
        chars[n] = temp;
    }
}
