package com.zc.exer1;

/**
 * @ClassName Solution36
 * @Description 剑指 Offer 36. 二叉搜索树与双向链表
 *              输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * @Author zngchao  Email:zengchao0905@163.com
 * @Date 2021/9/13 10:24
 * @Version 1.0
 */
public class Solution36 {
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        returnData res = recur(root);
        res.first.left = res.last;
        res.last.right = res.first;
        return res.first;
    }
    public returnData recur(TreeNode root){
        if (root == null) return null;
        returnData leftReturn = recur(root.left);
        returnData rightReturn = recur(root.right);
        TreeNode first;
        TreeNode last;
        if (leftReturn == null){
            first = root;
        }else{
            first = leftReturn.first;
            root.left = leftReturn.last;
            leftReturn.last.right = root;
        }

        if (rightReturn == null){
            last = root;
        }else{
            last = rightReturn.last;
            root.right = rightReturn.first;
            rightReturn.first.left = root;
        }

        return new returnData(first,last);
    }

    class returnData{
        TreeNode first;
        TreeNode last;

        public returnData(TreeNode first, TreeNode last) {
            this.first = first;
            this.last = last;
        }
    }



    TreeNode pre,head;
    public TreeNode treeToDoublyList1(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(TreeNode root){
        if (root == null) return;
        dfs(root.left);
        if (pre != null){
            pre.right = root;
        }else{
            head = root;
        }
        root.left = pre;
        pre = root;
        dfs(root.right);
    }
}
