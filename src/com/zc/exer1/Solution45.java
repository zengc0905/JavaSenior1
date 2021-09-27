package com.zc.exer1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Solution45
 * @Description 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/20 16:52
 * @Version 1.0
 */
public class Solution45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}
class myComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        while (o1 / 10 != 0){
            o1 /= 10;
        }
        while (o2 / 10 != 0){
            o2 /= 10;
        }
        return o1 - o2;
    }
}
