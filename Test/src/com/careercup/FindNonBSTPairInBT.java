package com.careercup;

import java.util.ArrayList;
import java.util.List;

public class FindNonBSTPairInBT {

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
		List<Integer> inOrderList = new ArrayList<Integer>();
		inOrderTraversal(inOrderList, a);
		printAllNonIncreasing(inOrderList);
	}

	private static void inOrderTraversal(List<Integer> inOrderList, Node a) {
		if (a == null)
			return;
		inOrderTraversal(inOrderList, a.left);
		inOrderList.add(a.val);
		inOrderTraversal(inOrderList, a.right);
	}

	private static void printAllNonIncreasing(List<Integer> inOrderList) {
		for (int i = 0; i < inOrderList.size() - 1; i++) {
			if (!(inOrderList.get(i) < inOrderList.get(i + 1))) {
				System.out.println(inOrderList.get(i) + ","
						+ inOrderList.get(i + 1));
				int j = i - 1;
				while (j >= 0) {
					if (!(inOrderList.get(j) < inOrderList.get(i + 1))) {
						System.out.println(inOrderList.get(j) + ","
								+ inOrderList.get(i + 1));
					}
					j--;
				}
			}

		}
	}

}
