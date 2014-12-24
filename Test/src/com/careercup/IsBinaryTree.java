package com.careercup;

public class IsBinaryTree {

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
		boolean isBinaryTree = isBinaryTree(e);
		System.out.println(isBinaryTree);
	}

	private static boolean isBinaryTree(Node a) {
		if(a==null)
			return false;
		if(a.left!=null&&a.right!=null){
			if(a.val<a.right.val&&a.val>a.left.val){
				return isBinaryTree(a.left)&&isBinaryTree(a.right);
			}else{
				return false;
			}
		}else if(a.left==null&&a.right==null){
			return true;
		}else if(a.left!=null&&a.left.val<a.val){
			return isBinaryTree(a.left);
		}else if(a.right!=null&&a.right.val>a.val){
			return isBinaryTree(a.right);
		}else{
			return false;
		}
	}

}
