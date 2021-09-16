package com.zc.primary_class;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author zengchao
 * @create 2021-06-17 21:20
 */
public class Solution03_05 {
    /*
    * * 03:
    * 找出数组中重复的数字。
     在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
     但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
//        int i = 0;
//        while(i < nums.length) {
//            if(nums[i] == i) {
//                i++;
//                continue;
//            }
//            if(nums[nums[i]] == nums[i]) return nums[i];
//            int tmp = nums[i];
//            nums[i] = nums[tmp];
//            nums[tmp] = tmp;
//        }
//        return -1;
        throw new RuntimeException("无重复元素");
    }

    public int findRepeatNumber1(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            boolean add = hashSet.add(nums[i]);
            if (add == false) {
                return nums[i];
            }
        }
        throw new RuntimeException("无重复元素");
    }

    @Test
    public void test() {
        int[] nums = {2, 3, 9, 4, 6, 9, 8};
        int repeatNumber = findRepeatNumber1(nums);
        System.out.println(repeatNumber);
    }

    /*
    04:
    在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length - 1, m = 0;//matrix.length为行数，matrix[0].length为列数
        while (n >= 0 && m < matrix[0].length) {
            if (matrix[n][m] == target) return true;
            if (matrix[n][m] > target) n--;
            else m++;
            //if (matrix[n][m] < target) m++;
        }
        return false;
    }

    @Test
    public void test1() {
        int[][] matrix = new int[][]{{1, 3, 5, 8}, {2, 5, 6, 9}, {5, 6, 8, 10}, {6, 8, 10, 11}};
        int target = 7;
        System.out.println(findNumberIn2DArray(matrix, target));
    }

    /**
     * @return java.lang.String
     * @Author:ZengChao
     * @Description: 05.实现一个函数，把字符串s中的每个空格替换成%20
     * @Date: 21:29 2021/7/12
     * @Param [s]
     **/
    public String replaceSpace(String s) {
//        String replace = s.replace(" ", "%20");
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                builder.append("%20");
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    @Test
    public void testReplaceSpace() {
        String s = " ih dhvi vhehei vhue   ih    ";
        System.out.println(replaceSpace(s));
    }


}
