package com.zxy.arithmetic.tree;

/**
 * 使用递归的方式演示树的遍历
 */
public class TreePrint1 {

    public static void main(String[] args) {
        TreeNode head = TreeBuilder.randomBuild();

        System.out.println("preorderTraversal");
        preorderTraversal(head);

        System.out.println("\n\ninorderTraversal");
        inorderTraversal(head);

        System.out.println("\n\npostorderTraversal");
        postorderTraversal(head);
    }

    /**
     * 二叉树前序遍历   根-> 左-> 右
     */
    private static void preorderTraversal(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.getVal() + " ");
        preorderTraversal(head.getLeft());
        preorderTraversal(head.getRight());
    }

    /**
     *  二叉树中序遍历   左-> 根-> 右
     */
    private static void inorderTraversal(TreeNode head) {
        if (head == null) {
            return;
        }
        inorderTraversal(head.getLeft());
        System.out.print(head.getVal() + " ");
        inorderTraversal(head.getRight());
    }

    /**
     * 二叉树后序遍历   左-> 右-> 根
     */
    private static void postorderTraversal(TreeNode head) {
        if (head == null) {
            return;
        }
        postorderTraversal(head.getLeft());
        postorderTraversal(head.getRight());
        System.out.print(head.getVal() + " ");
    }

}
