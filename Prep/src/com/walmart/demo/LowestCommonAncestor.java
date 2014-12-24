package com.walmart.demo;

class Tree {
	int data;
	Tree left;
	Tree right;

	public Tree addNode(int data) {
		Tree t = new Tree();
		t.data = data;
		t.left = null;
		t.right = null;
		return t;
	}

	public void inOrder(Tree t) {
		if (t != null) {
			t.inOrder(t.left);
			System.out.println(t.data);
			inOrder(t.right);
		}
	}

	public void preOrder(Tree t) {
		if (t != null) {
			System.out.println(t.data);
			t.preOrder(t.left);
			t.preOrder(t.right);
		}
	}

	public void postOrder(Tree t) {
		if (t != null) {
			t.postOrder(t.left);
			t.postOrder(t.right);
			System.out.println(t.data);
		}
	}

	public Tree lcs(Tree t, Tree a, Tree b) {
		if (t == null)
			return null;
		if (t == a || t == b)
			return t;
		Tree left = lcs(t.left, a, b);
		Tree right = lcs(t.right, a, b);
		if (left != null && right != null)
			return t;

		return (left != null) ? left : right;
	}
}

public class LowestCommonAncestor {

	public static void main(String[] args) {
		Tree tree = new Tree();
		Tree temp = new Tree();
		tree = tree.addNode(4);
		tree.left = tree.addNode(5);
		tree.right = tree.addNode(6);
		temp = tree.left;
		temp.left = tree.addNode(7);
		tree.inOrder(tree);
		System.out.println("---------------------");
		tree.preOrder(tree);
		System.out.println("---------------------");
		if (tree.lcs(tree, temp.left, tree.right) != null)
			System.out.println("lcs : "
					+ tree.lcs(tree, temp.left, tree.right).data);

	}
}
