package com.careercup;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeftMostRightCousin {
	static 	Queue<Node> q1 = new LinkedList<Node>();
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
		q1.offer(a);
		Node out = leftMostRightCousin(2);
		System.out.println(out==null?0:out.val);

	}

	private static Node leftMostRightCousin(int val) {
		int length = q1.size();
		while(length>0){
			Node n = q1.poll();
			if(n!=null){
				if(n.val==val)
					return q1.poll();
				q1.offer(n.left);
				q1.offer(n.right);
				
			}
			length--;
		}
		return leftMostRightCousin(val);
	}

}