package com.zc.primary_class;

/**
 * @ClassName Solution27
 * @Description 剑指 Offer 27. 二叉树的镜像
 *              请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/8/30 21:15
 * @Version 1.0
 */
public class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        TreeNode a;
        a = root.left;
        root.left = root.right;
        root.right = a;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
