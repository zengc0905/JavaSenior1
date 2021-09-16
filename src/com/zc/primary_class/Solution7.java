package com.zc.primary_class;

import org.junit.Test;

import java.util.HashMap;

//创建一个二叉树节点
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}


/**
 * @ClassName Solution7
 * @Description 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * （可根据包含中序遍历的任意两种遍历方式确定一颗二叉树）
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/7/15 23:30
 * @Version 1.0
 */

public class Solution7 {

    //    int[] preorder;
//    HashMap<Integer, Integer> dic = new HashMap<>();
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        this.preorder = preorder;
//        for(int i = 0; i < inorder.length; i++)
//            dic.put(inorder[i], i);
//        return recur(0, 0, inorder.length - 1);
//    }
//
//    public TreeNode recur(int rootIndex, int leftIndex, int rightIndex) {
//        if (leftIndex > rightIndex){
//            return null;
//        }
//        TreeNode node = new TreeNode(preorder[rootIndex]);
//        Integer i = dic.get(preorder[rootIndex]);
//        node.left = recur(rootIndex + 1,leftIndex,i - 1);
//        node.right = recur(i - leftIndex + rootIndex + 1,i + 1,rightIndex);
//        return node;
    HashMap<Integer, Integer> inOrderHashMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        //递归终止条件
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        //返回根节点
        TreeNode node = new TreeNode(preorder[preStart]);
        //获得根节点在中序遍历数组inorder中的索引
        Integer i = inOrderHashMap.get(node.val);

        //通过递归，连接左右子树
        node.left = buildTree(preorder, preStart + 1, preStart + i - inStart, inorder, inStart, i - 1);
        node.right = buildTree(preorder, preStart + i + 1 - inStart, preEnd, inorder, i + 1, inEnd);


        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //初始化inorderMap,将中序遍历inorder的值存入，inorder[i]对应key,i对应value;
        for (int i = 0; i < inorder.length; i++) {
            inOrderHashMap.put(inorder[i], i);
        }
        TreeNode node = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return node;
    }

    //二叉树的先序遍历
    public void preTravel(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + "\t");
        if (node.left != null) {
            preTravel(node.left);
        }
        if (node.right != null) {
            preTravel(node.right);
        }
    }
    //二叉树的中序遍历
    public void inTravel(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            inTravel(node.left);

        }
            System.out.print(node.val + "\t");

        if (node.right != null) {
            inTravel(node.right);
        }
    }
    //二叉树的后序遍历
    public void laTravel(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
           laTravel(node.left);
        }
        if (node.right != null) {
            laTravel(node.right);
        }
        System.out.print(node.val + "\t");
    }



    @Test
    public void testBuildTree() {
        int[] preorder = new int[]{3, 9, 2, 1, 7};
        int[] inorder = new int[]{9, 3, 1, 2, 7};
        TreeNode node = buildTree(preorder, inorder);
        preTravel(node);
        System.out.println();
        inTravel(node);
        System.out.println();
        laTravel(node);
        System.out.println();
        System.out.println(node.val);
    }
}
