package com.zc.exer1;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution37
 * @Description 剑指 Offer 37. 序列化二叉树
 *
 *  请实现两个函数，分别用来序列化和反序列化二叉树。
你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/13 15:38
 * @Version 1.0
 */
public class Solution37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#!";
        String str = root.val + "!";
        return str + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        String[] str = data.split("!");
        queue.addAll(Arrays.asList(str));
        return reconPreOrder(queue);
    }

    public TreeNode reconPreOrder(Queue<String> queue){
        if (queue.isEmpty()) return null;
        String poll = queue.poll();
        if (poll.equals("#")) return null;
        TreeNode head = new TreeNode(Integer.valueOf(poll));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }


   @Test
    public void test(){
       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);
       root.right.left = new TreeNode(4);
       root.right.right = new TreeNode(5);
       System.out.println(serialize(root));
//       System.out.println(deserialize(serialize(root)).val);
   }
}
