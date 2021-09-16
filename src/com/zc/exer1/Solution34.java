package com.zc.exer1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Solution34
 * @Description 剑指 Offer 34. 二叉树中和为某一值的路径
 *              输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 *              从树的根节点开始往下一直到叶节点所经过的节点形成一条路径
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/11 13:45
 * @Version 1.0
 */
public class Solution34 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root,target);
        return res;
    }
    public void recur(TreeNode root,int tar){
        if (root == null) return;
        list.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null){
            res.add(new LinkedList(list));
        }
        recur(root.left,tar);
        recur(root.right,tar);
        list.removeLast();
    }
}
