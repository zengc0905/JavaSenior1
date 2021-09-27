package com.zc.exer1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution39
 * @Description 剑指 Offer 39. 数组中出现次数超过一半的数字
 *  数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/16 21:06
 * @Version 1.0
 */
public class Solution39 {

    //哈希表统计法
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])){
                int count = hashMap.get(nums[i]) + 1;
                hashMap.put(nums[i],count);
            }else{
                hashMap.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            if (entry.getValue() > nums.length / 2) return entry.getKey();
        }
        return 0;
    }

    //数组排序法（中位数）
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //摩尔投票法
    public int majorityElement2(int[] nums) {
        int votes = 0;
        int x = nums[0];
        for (int num : nums) {
            if (votes == 0) x = num;
            if (x == num){
                votes++;
            }else {
                votes--;
            }
        }
        return 0;
    }
}
