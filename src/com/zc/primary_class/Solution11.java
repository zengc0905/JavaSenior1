package com.zc.primary_class;

/**
 * @ClassName Solution11
 * @Description 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/7/21 17:03
 * @Version 1.0
 */
public class Solution11 {
    //暴力法
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]){
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    //二分法结合暴力法
    public int minArray1(int[] numbers){
        int left = 0;
        int right = numbers.length - 1;
        int mid;
        while (left < right){
            mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]){
                left = mid + 1;
            }else if (numbers[mid] < numbers[right]){
                right = mid;
            } else{
                right--;
            }
        }
        return numbers[left];
    }
}
