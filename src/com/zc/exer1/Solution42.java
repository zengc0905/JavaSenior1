package com.zc.exer1;

/**
 * @ClassName Solution42
 * @Description 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/18 19:57
 * @Version 1.0
 */
public class Solution42 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0){
                nums[i] = nums[i] + nums[i - 1];
            }
            res = Math.max(res,nums[i]);
        }
        return res;
    }
}
//nums[i] += Math.max(nums[i - 1], 0);
//        res = Math.max(res, nums[i]);