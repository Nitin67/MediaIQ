package com.ds.avl;

class ANode {
	int data, height;
	ANode left, right;

	public ANode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.height = 0;
	}
}

public class AVLTreePractice {

	ANode root;

	public AVLTreePractice() {
		this.root = null;
	}

	public ANode insert(int data) {
		return insert(data, root);
	}

	private ANode insert(int data, ANode root) {
		if (root == null)
			return new ANode(data);
		else {
			if (data < root.data) {
				root.left = insert(data, root.left);
				if (height(root.left) - height(root.right) == 2)
					if (data < root.left.data)
						root = rotateWithLeftChild(root);
					else
						root = doubleRotateWithLeftChild(root);
			} else {
				root.right = insert(data, root.right);
				if (height(root.right) - height(root.left) == 2)
					if (data > root.right.data)
						root = rotateWithRightChild(root);
					else
						root = doubleRotateWithRightChild(root);
			}
		}
		root.height = height(root);
		return null;
	}

	private ANode doubleRotateWithRightChild(ANode root) {
		root.right = rotateWithLeftChild(root.right);
		return rotateWithRightChild(root);
	}

	private ANode rotateWithRightChild(ANode root) {
		ANode node = root.right;
		root.right = node.left;
		node.left = root;
		node.height = height(node);
		root.height = height(root);
		return node;
	}

	private ANode doubleRotateWithLeftChild(ANode root) {
		root.left = rotateWithRightChild(root.left);
		return rotateWithLeftChild(root);
	}

	private ANode rotateWithLeftChild(ANode root) {
		ANode node = root.left;
		root.left = node.right;
		node.right = root;
		root.height = height(root);
		node.height = height(node);
		return node;
	}

	private int getMedian() {
		int heightLeft = height(root.left);
		int heightRight = height(root.right);
		if (heightLeft == heightRight)
			return root.data;
		else if (heightLeft > heightRight)
			return root.data + root.left.data / 2;
		else
			return root.data + root.right.data / 2;

	}

	private int height(ANode node) {
		if (node == null)
			return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
}
