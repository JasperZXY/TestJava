package com.zxy.arithmetic.tree;

import java.util.Stack;

/**
 * 使用非递归的方式演示树的遍历
 */
public class TreePrint2 {

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
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = head;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(node.getVal() + " ");
                stack.push(node);
                node = node.getLeft();
            }
            if (!stack.isEmpty()) {
                node = stack.pop().getRight();
            }
        }
    }

    /**
     *  二叉树中序遍历   左-> 根-> 右
     */
    private static void inorderTraversal(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = head;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.getVal() + " ");
                node = node.getRight();
            }
        }
    }

    /**
     * 二叉树后序遍历   左-> 右-> 根
     */
    private static void postorderTraversal(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = head;   // 当前根节点
        TreeNode last = null;   // 上一次打印的节点
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                /*
                没有右节点，当前节点可以打印了
                当前节点的右节点就是上一次打印的节点，当前节点可以打印了
                “node = null”表示当前节点的这个分支不能再处理了，因为外层循环是“node = node.getLeft()”
                 */
                if (node.getRight() == null || node.getRight() == last) {
                    System.out.print(node.getVal() + " ");
                    last = node;
                    node = null;
                }else {
                    stack.add(node);
                    node = node.getRight();
                }

            }
        }
    }

}
