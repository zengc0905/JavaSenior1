package com.zc.exer1;

import java.util.*;

/**
 * @ClassName Solution32_3
 * @Description 剑指 Offer 32 - III. 从上到下打印二叉树 III
 *              请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 *              第三行再按照从左到右的顺序打印，其他行以此类推。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/5 18:40
 * @Version 1.0
 */
public class Solution32_3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<List<Integer>> lists = new ArrayList<>();

        if (root != null) queue.add(root);
        while (!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = queue.size(); i > 0 ; i--) {
                TreeNode node = queue.poll();
                if (lists.size() % 2 == 0) list.addLast(node.val);
                else list.addFirst(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            lists.add(list);
        }
        return lists;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();//双端队列
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) deque.add(root);
        while(!deque.isEmpty()) {
            // 打印奇数层
            List<Integer> tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 从左向右打印
                TreeNode node = deque.removeFirst();
                tmp.add(node.val);
                // 先左后右加入下层节点
                if(node.left != null) deque.addLast(node.left);
                if(node.right != null) deque.addLast(node.right);
            }
            res.add(tmp);
            if(deque.isEmpty()) break; // 若为空则提前跳出
            // 打印偶数层
            tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                TreeNode node = deque.removeLast();
                tmp.add(node.val);
                // 先右后左加入下层节点
                if(node.right != null) deque.addFirst(node.right);
                if(node.left != null) deque.addFirst(node.left);
            }
            res.add(tmp);
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(res.size() % 2 == 1) Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
    }


}
