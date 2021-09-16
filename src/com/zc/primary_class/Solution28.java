package com.zc.primary_class;

/**
 * @ClassName Solution28
 * @Description 剑指 Offer 28. 对称的二叉树
 *              请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/8/30 21:48
 * @Version 1.0
 */
public class Solution28 {
    public boolean isSymmetric1(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }
    private boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

}
