package com.careercup;

public class CheckMirrorImageInBT {

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
		// l2.add(a);
		boolean ismirrorImage =  isMirrorImage(a.left,a.right);
		System.out.println(ismirrorImage);

	}

	private static boolean isMirrorImage(Node left, Node right) {
		if(left==null&&right==null)
			return left==null&&right==null;
		return left.val==right.val&&isMirrorImage(left.left, right.right)&&isMirrorImage(left.right, right.left);
		
	}
}
