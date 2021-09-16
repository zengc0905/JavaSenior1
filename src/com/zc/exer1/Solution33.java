package com.zc.exer1;

/**
 * @ClassName Solution33
 * @Description 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/9 19:12
 * @Version 1.0
 */
public class Solution33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) return true;
        return recur(postorder, 0, postorder.length - 1).isBst;
    }

    public returnType recur(int[] postorder, int m, int n) {
        if (m > n) return null;
        int p = m;
        while (postorder[p] < postorder[n]) p++;
        returnType leftReturn = recur(postorder, m, p - 1);
        returnType rightReturn = recur(postorder, p, n - 1);
        int min = postorder[n], max = postorder[n];
        if (leftReturn != null) {
            min = Math.min(leftReturn.min, min);
            max = Math.max(leftReturn.max, max);
        }
        if (rightReturn != null) {
            min = Math.min(rightReturn.min, min);
            max = Math.max(rightReturn.max, max);
        }
        boolean isBft = false;
        if (
                (leftReturn == null || (leftReturn.isBst && leftReturn.max < postorder[n])) &&
                        (rightReturn == null || (rightReturn.isBst && rightReturn.min > postorder[n]))
                ) {
            isBft = true;
        }
        return new returnType(isBft, min, max);


    }

    //力扣简便解法
    public boolean verifyPostorder1(int[] postorder) {
        return recur1(postorder, 0, postorder.length - 1);
    }
    boolean recur1(int[] postorder, int i, int j) {
        if(i >= j -1) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur1(postorder, i, m - 1) && recur1(postorder, m, j - 1);
    }
/*
    作者：jyd
    链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

}

class returnType {
    boolean isBst;
    int min;
    int max;

    public returnType(boolean isBst, int min, int max) {
        this.isBst = isBst;
        this.min = min;
        this.max = max;
    }
}