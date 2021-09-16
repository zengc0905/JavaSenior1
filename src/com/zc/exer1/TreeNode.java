package com.zc.exer1;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/5 14:30
 * @Version 1.0
 */
public class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

    public TreeNode() {
    }

    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val, TreeNode right, TreeNode left) {
        this.val = val;
        this.right = right;
        this.left = left;
    }
}
