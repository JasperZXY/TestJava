package com.jasper.mine;

/**
 * 排序二叉树实现，用整形做例子
 * @author Jasper
 */
public class Tree {
	private TreeNode root;
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		int[] data = new int[7];
		for (int i = 0; i < data.length; i++) {
			data[i] = (int) (Math.random() * 100) + 1;
			System.out.print(data[i] + ",");
		}
		System.out.println();

		for (int i = 0; i < data.length; i++) {
			tree.insert(data[i]);
		}
		tree.preList();
		System.out.println();
		tree.middleList();
		System.out.println();
		tree.afterList();
		System.out.println();
	}
	
	public void insert(int value) {
		if(root == null) {
			root = new TreeNode();
			root.value = value;
		} else {
			root.store(value);
		}
	}
	
	public void preList() {
		root.preList();
	}
	
	public void middleList() {
		root.middleList();
	}

	public void afterList() {
		root.afterList();
	}
	
	/**
	 * 树节点
	 * @author Jasper
	 */
	class TreeNode {
		public int value;
		public TreeNode left;
		public TreeNode right;

		public void store(int value) {
			if (value < this.value) {
				if (left == null) {
					left = new TreeNode();
					left.value = value;
				} else {
					left.store(value);
				}
			} else {
				if (right == null) {
					right = new TreeNode();
					right.value = value;
				} else {
					right.store(value);
				}
			}
		}

		public boolean find(int value) {
			System.out.println("happen " + this.value);
			if (value == this.value) {
				return true;
			} else if (value > this.value) {
				if (right == null)
					return false;
				return right.find(value);
			} else {
				if (left == null)
					return false;
				return left.find(value);
			}

		}

		public void preList() {
			System.out.print(this.value + ",");
			if (left != null)
				left.preList();
			if (right != null)
				right.preList();
		}
		
		public void prePrint(TreeNode node) {
			if(node != null) {
				System.out.print(node.value + ",");
				prePrint(node.left);
				prePrint(node.right);
			}
		}
		

		public void middleList() {
			if (left != null)
				left.middleList();
			System.out.print(this.value + ",");
			if (right != null)
				right.middleList();
		}

		public void afterList() {
			if (left != null)
				left.afterList();
			if (right != null)
				right.afterList();
			System.out.print(this.value + ",");
		}
	}
}
