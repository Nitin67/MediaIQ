package com.careercup;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class WrapInt{
	public int l;
}
public class SumAtSameLevel {

	/**
	 * @param args
	 */
	
	private static Set<Node> s1 = new HashSet<Node>();
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
		WrapInt nLevel = new WrapInt();
		nLevel.l = 5;
		depthFirst(a,nLevel);

	}
	private static void depthFirst(Node a, WrapInt nLevel) {
		if(a==null){
			return;
		}else if(a.left==null&&a.right==null){
			nLevel.l--;
			return;
		}
		if(nLevel.l==0){
			s1.add(a);
		}
		depthFirst(a.left, nLevel);
		depthFirst(a.right, nLevel);
		nLevel.l--;
	}

}
