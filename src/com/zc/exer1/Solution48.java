package com.zc.exer1;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution48
 * @Description 剑指 Offer 48. 最长不含重复字符的子字符串
 *     请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/24 13:11
 * @Version 1.0
 */
public class Solution48 {
    //暴力遍历
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length; i++) {
            if (chars.length - i < maxLength) break;
            int res = 1;
            label: for (int j = i + 1; j < chars.length; j++) {
                for (int k = i; k < j; k++) {
                    if (chars[k] == chars[j]) break label;
                }
                res++;
            }
            maxLength = Math.max(maxLength,res);
        }
        return maxLength;
    }

    //动态规划 + 哈希表
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }

}
