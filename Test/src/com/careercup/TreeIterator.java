package com.careercup;

import java.util.Stack;

class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
}

public class TreeIterator {

	Stack<TreeNode> stack = new Stack<TreeNode>();

	public TreeIterator(TreeNode root) {
		if (root != null) {
			stack.push(root);
			pushLeftChild(root.left);
		}
	}

	private void pushLeftChild(TreeNode root) {
		if (root != null) {
			stack.push(root);
			pushLeftChild(root.left);
		}
	}

	public boolean hasNext() {
		return stack.size() > 0;
	}

	public TreeNode next() {
		if (stack.isEmpty()) {
			return null;
		} else {
			TreeNode treeNode = stack.pop();
			pushLeftChild(treeNode.right);
			return treeNode;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
