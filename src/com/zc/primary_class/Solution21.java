package com.zc.primary_class;

/**
 * @ClassName Solution21
 * @Description 21.调整数组顺序使得奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/8/21 20:38
 * @Version 1.0
 */
public class Solution21 {
    //首尾双指针
    public int[] exchange(int[] nums) {
//        int[] ints = new int[nums.length];
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] % 2 == 1) ints[j++] = nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] % 2 == 0) ints[j++] = nums[i];
//        }
//        return ints;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 0) {
                if (nums[right] % 2 == 1) swap(nums, left, right);
                else right--;
            } else {
                left++;
            }
        }
        return nums;
    }

    /*快慢双指针
    定义快慢双指针 fast 和 low ，fast 在前， low 在后 .
    fast 的作用是向前搜索奇数位置，low 的作用是指向下一个奇数应当存放的位置
    fast 向前移动，当它搜索到奇数时，将它和 nums[low] 交换，此时 low 向前移动一个位置 .
    重复上述操作，直到 fastfast 指向数组末尾 .*/
    public int[] exchange1(int[] nums) {
        int fast = 0,slow = 0;
        while (fast < nums.length){
            if (nums[fast] % 2 == 0) fast++;
            else swap(nums,slow++,fast++);
        }
        return nums;
    }

    public void swap(int[] arrs, int i, int j) {
        int temp = 0;
        temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}
