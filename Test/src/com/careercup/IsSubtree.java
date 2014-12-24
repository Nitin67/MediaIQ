package com.careercup;

public class IsSubtree {

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
		e.left = c;
		c.right = d;
		c.left = a;
		a.right = b;
		e.right = h;
		h.left = f;
		f.right = g;
		h.right = m;
		m.left = n;
		m.right = k;
		
		Node a1 = new Node();
		a1.val = 1;
		Node b1 = new Node();
		b1.val = 2;
		Node c1 = new Node();
		c1.val = 3;
		Node d1 = new Node();
		d1.val = 4;
		Node e1 = new Node();
		e1.val = 5;
		Node f1 = new Node();
		f1.val = 6;
		Node g1 = new Node();
		g1.val = 7;
		Node h1 = new Node();
		h1.val = 8;
		Node n1 = new Node();
		n1.val = 9;
		Node m1 = new Node();
		m1.val = 10;
		Node k1 = new Node();
		k1.val = 11;
/*		e1.left = c1;
		c1.right = d1;
		c1.left = a1;
		a1.right = b1;
		e1.right = h1;*/
		h1.left = f1;
		f1.right = g1;
		h1.right = m1;
		m1.left = n1;
		m1.right = k1;
		Node a2 = findInBST(e,h1.val);
		boolean isSubtree = isSubtree(a2,h1);
		System.out.println(a2.val);
		System.out.println(isSubtree);
	}

	private static Node findInBST(Node a, int val) {
		if(a==null)
			return null;
		if(a.val == val)
			return a;
		else if(a.val<val)
			return findInBST(a.right, val);
		else
			return findInBST(a.left, val);
	}

	private static boolean isSubtree(Node a, Node a1) {
		if(a1==null)
			return true;
		else{
			if(a==null)
				return false;
			return a.val==a1.val&&isSubtree(a.left, a1.left)&&isSubtree(a.right, a1.right);
		}
	}

}
