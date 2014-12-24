package com.careercup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class MaxNumberOfNodesOnLevel {
	static List<Node> l1 = new ArrayList<Node>();
	static List<Node> l2 = new ArrayList<Node>();
	static Stack<Node> s1 = new Stack<Node>();
	static int max = 0;

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
		l1.add(a);
		// l2.add(a);
		printLevelWithMaxNode(a);
		System.out.println(max);

	}

	private static void printLevelWithMaxNode(Node a) {
		while(l1!=null&&l1.size()>0){
			max = max>l1.size()?max:l1.size();
			Iterator<Node> itr = l1.iterator();
			while(itr.hasNext()){
				Node n = itr.next();
				s1.push(n.left);
				s1.push(n.right);
			}
			l1 = new ArrayList<Node>();
			while(!s1.empty()){
				Node n = s1.pop();
				if(n!=null)
					l1.add(n);
			}
		}
		// TODO Auto-generated method stub

	}

}
