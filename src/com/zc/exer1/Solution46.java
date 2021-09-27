package com.zc.exer1;

/**
 * @ClassName Solution46
 * @Description 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，
 * 11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/23 19:54
 * @Version 1.0
 */
public class Solution46 {
    public int translateNum(int num) {
        int l = 0;
        int a = num;
        while (a != 0){
            l++;
            a = a / 10;
        }
        int[] nums = new int[l];
        for (int i = l - 1; i >= 0; i--) {
            nums[i] = num % 10;
            num /= 10;
        }
        return getTranslateNum(nums,nums.length - 1);
    }

    public int getTranslateNum(int[] arr,int i){
        if (i <= 0) return 1;
        int count = getTranslateNum(arr, i - 1);
        if (arr[i - 1] == 1 || (arr[i - 1] == 2) && arr[i] < 6){
                count += getTranslateNum(arr,i - 2);
        }
        return count;
    }
}
