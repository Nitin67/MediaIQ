package com.ds.avl;

class AVLTreeNode {
	public int height = 0, val;
	public AVLTreeNode left, right;

	public AVLTreeNode(int val) {
		left = null;
		right = null;
		this.val = val;
		height = 0;
	}
}

public class AvlTree {
	AVLTreeNode root;

	public AvlTree() {
		this.root = null;
	}

	public AVLTreeNode insert(int val) {
		return insert(val, root);
	}

	private AVLTreeNode insert(int val, AVLTreeNode root) {
		if (root == null)
			return new AVLTreeNode(val);
		else {
			if (val < root.val) {
				root.left = insert(val, root.left);
				if (height(root.left) - height(root.right) == 2)
					if (val < root.left.val)
						root = rotateWithLeftChild(root);
					else
						root = doubleRotateWithLeftChild(root);
			} else {
				root.right = insert(val, root.right);
				if (height(root.right) - height(root.left) == 2)
					if (val > root.right.val)
						root = rotateWithRightChild(root);
					else
						root = doubleRotateWithRightChild(root);

			}
		}
		root.height = height(root);
		return root;
	}

	private AVLTreeNode doubleRotateWithRightChild(AVLTreeNode node) {
		node.right = rotateWithLeftChild(node.right);
		return rotateWithRightChild(node);
	}

	private AVLTreeNode rotateWithRightChild(AVLTreeNode node) {
		AVLTreeNode right = node.right;
		node.left = right.right;
		right.right = node;
		node.height = height(node);
		right.height = height(right);
		return right;
	}

	private AVLTreeNode doubleRotateWithLeftChild(AVLTreeNode node) {
		node.left = rotateWithRightChild(node.left);
		return rotateWithLeftChild(node);
	}

	private AVLTreeNode rotateWithLeftChild(AVLTreeNode node) {
		AVLTreeNode left = node.left;
		node.left = left.right;
		left.right = node;
		node.height = height(node);
		left.height = height(left);
		return left;
	}

	private int height(AVLTreeNode node) {
		if (node == null)
			return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
}
