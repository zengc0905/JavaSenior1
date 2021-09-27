package com.zc.exer1;

import java.util.HashMap;

/**
 * @ClassName Solution50
 * @Description 剑指 Offer 50. 第一个只出现一次的字符
 *      在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/27 18:59
 * @Version 1.0
 */
public class Solution50 {
    public char firstUniqChar(String s) {
        if (s == null) return ' ';
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char aChar : chars) {
            if (hashMap.containsKey(aChar)){
                hashMap.put(aChar,2);
            }else {
                hashMap.put(aChar,1);
            }
        }
        for (char aChar : chars) {
            if (hashMap.get(aChar) == 1){
                return aChar;
            }
        }
        return ' ';
    }
}
