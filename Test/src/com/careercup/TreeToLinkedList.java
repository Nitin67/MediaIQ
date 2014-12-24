package com.careercup;

public class TreeToLinkedList {

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
		//b.left = c;
		a.right = g;
		//g.left = h;
		//b.right = d;
		//d.left = e;
		//d.right = f;
		//e.left = m;
		//f.right = n;
		//n.left = k;
		Node head = new Node();
		head.left = treeToLinkedList(a,a);

	}

	private static Node treeToLinkedList(Node a1,Node a2) {
		if(a1==null)
			return null;
		a2 = a1;
		a2.left = treeToLinkedList(a1.left,a2);
		while(a2.left!=null){
			a2 = a2.left;
		}
		a2.left = treeToLinkedList(a1.right, a2);
		return a1;
	}

}
