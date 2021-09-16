package com.zc.exer1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution32_2
 * @Description 剑指 Offer 32 - II. 从上到下打印二叉树 II
 *              从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/5 16:14
 * @Version 1.0
 */
public class Solution32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {//for循环从高到低，完美避免size的大小改变
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            lists.add(list);
        }
        return lists;
    }

    //递归
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> levelOrder1(TreeNode root) {
        dfs(0,root);
        return lists;
    }

    public void dfs(int depth,TreeNode root){
        if (root == null) return;
        if (lists.size() == depth){
            lists.add(new ArrayList<>());
        }
        lists.get(depth).add(root.val);
        dfs(depth + 1,root.left);
        dfs(depth + 1,root.right);
    }
}
