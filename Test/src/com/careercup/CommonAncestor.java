package com.careercup;

import java.util.Stack;

class Node {
	int val;
	Node left;
	Node right;
}

public class CommonAncestor {
	static Stack<Node> l1 = new Stack<Node>();
	static Stack<Node> l2 = new Stack<Node>();
	static boolean val1Found = false;
	static boolean val2Found = false;
	static Node previous = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node a = new Node();
		a.val = 1;
		Node b = new Node();
		b.val = 2;
		Node c = new Node();
		c.val = 3;
		Node d = new Node();
		d.val = 4;
		Node e = new Node();
		e.val = 5;
		Node f = new Node();
		f.val = 6;
		Node g = new Node();
		g.val = 7;
		Node h = new Node();
		h.val = 8;
		Node n = new Node();
		n.val = 9;
		Node m = new Node();
		m.val = 10;
		Node k = new Node();
		k.val = 11;
		a.left = b;
		b.left = c;
		a.right = g;
		g.left = h;
		b.right = d;
		d.left = e;
		d.right = f;
		e.left = m;
		f.right = n;
		n.left = k;
		int val1 = 2;
		int val2 = 7;
		l1.push(a);
		findCommonAncestor(a, val1, val2);
		System.out.println(previous.val);
		// TODO Auto-generated method stub

	}

	private static void findCommonAncestor(Node a, int val1, int val2) {
		if (a != null) {
			if (a.val == val1 || a.val == val2) {
				formBackupStack();
			}
			if (previous == null) {
				l1.push(a.left);
				findCommonAncestor(a.left, val1, val2);
				l1.pop();
				l1.push(a.right);
				findCommonAncestor(a.right, val1, val2);
				l1.pop();
			}
		}
		// TODO Auto-generated method stub

	}

	private static void formBackupStack() {
		if (l2.size() == 0) {
			l2 = (Stack<Node>) l1.clone();
		} else {
			int size1 = l1.size();
			int size2 = l2.size();
			int i = 0, j = 0;
			for (; i < size1 && j <size2; i++, j++) {
				previous = (l1.get(i) == l2.get(j)) ? l1.get(i) : previous;
			}
		}
	}

}
