package com.zc.exer1;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName Solution32
 * @Description 剑指 Offer 32 - I. 从上到下打印二叉树
 *              从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/5 14:28
 * @Version 1.0
 */
public class Solution32 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
//        int i = 0;
        int[] res = new int[list.size()];
//        for (Integer integer : list) {
//            res[i++] = integer;
//        }
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }
        return res;

    }

//    ArrayList<Integer> list = new ArrayList<>();
//    public int[] levelOrder1(TreeNode root) {
//        dfs(root);
//        int[] ints = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            ints[i] = list.get(i);
//        }
//        return ints;
//    }
//    public void dfs(TreeNode root){
//        if (root == null) return;
//        list.add(root.val);
//        dfs(root.left);
//        dfs(root.right);
//
//    }

}
