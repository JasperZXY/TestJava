package com.zxy.arithmetic.tree;

public class TreeBuilder {

    /**
     * 随机创建一个tree
     *                      1
     *                  /       \
     *                 2            3
     *              /   \           /   \
     *             4     5         6     7
     *             /                \
     *             8                 9
     * @return
     */
    public static TreeNode randomBuild() {
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6, null, node9);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4, node8, null);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        return node1;
    }

}
