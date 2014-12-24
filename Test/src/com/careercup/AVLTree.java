package com.careercup;

class AVLTreeNode {
	public int data;
	public AVLTreeNode left;
	public AVLTreeNode right;
	public int height;

	public AVLTreeNode(int data) {
		this.data = data;
		this.height = 0;
	}

}

public class AVLTree {
	public AVLTreeNode root;

	public AVLTree() {
		root = null;
	}

	public AVLTreeNode insert(int data) {
		return insert(data, root);
	}

	private AVLTreeNode insert(int data, AVLTreeNode root) {
		if (root == null)
			return new AVLTreeNode(data);
		else {
			if (data < root.data) {
				root.left = insert(data, root.left);
				if (height(root.left) - height(root.right) == 2)
					if (data < root.left.data)
						root = rotateWithLeftNode(root);
					else
						root = doubleRotateWithLeftNode(root);
			} else {
				root.right = insert(data, root.right);
				if (height(root.right) - height(root.left) == 2)
					if (data > root.right.data)
						root = rotateWithRightNode(root);
					else
						root = doubleRotateWithRightNode(root);
			}
			root.height = height(root);
			return root;
		}
	}

	private AVLTreeNode doubleRotateWithRightNode(AVLTreeNode right) {
		right.right = rotateWithLeftNode(right.right);
		return rotateWithRightNode(right);
	}

	private AVLTreeNode rotateWithRightNode(AVLTreeNode right) {
		AVLTreeNode temp = right.right;
		right.right = temp.left;
		temp.left = root;
		temp.height = height(temp);
		right.height = height(right);
		return temp;
	}

	private AVLTreeNode doubleRotateWithLeftNode(AVLTreeNode left) {
		left.left = rotateWithRightNode(left.left);
		return rotateWithLeftNode(left);
	}

	private AVLTreeNode rotateWithLeftNode(AVLTreeNode left) {
		AVLTreeNode temp = left.left;
		left.left = temp.right;
		temp.right = left;
		left.height = height(left);
		temp.height = height(temp);
		return temp;
	}

	private int height(AVLTreeNode root) {
		if (root == null)
			return 0;
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	public int getMedian() {
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		if (leftHeight == rightHeight)
			return root.data;
		else if (leftHeight > rightHeight)
			return (root.left.data + root.data) / 2;
		else
			return (root.right.data + root.data) / 2;
	}
}
