package com.careercup;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeZigZagTraversal {

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
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(a);
		printZigZag(s1, s2, false);
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(a);
		printZigZag(queue);

	}

	private static void printZigZag(Queue<Node> queue) {
		Node nullNode = new Node();
		int flag = 0;
		queue.add(nullNode);
		StringBuffer sb = new StringBuffer();
		while (!queue.isEmpty()) {
			if (flag % 2 == 0) {
				Node node = queue.poll();
				if (node != nullNode) {
					while (node != nullNode && node != null) {
						sb.append(node.val + "\t");
						if (node.right != null)
							queue.offer(node.right);
						if (node.left != null)
							queue.offer(node.left);
						node = queue.poll();
					}
					queue.offer(nullNode);
					sb.append("\n");
					flag++;
				} else
					break;
			} else {
				Node node = queue.poll();
				if (node != nullNode) {
					while (node != nullNode && node != null) {
						sb.append(node.val + "\t");
						if (node.left != null)
							queue.offer(node.left);
						if (node.right != null)
							queue.offer(node.right);
						node = queue.poll();
					}
					queue.offer(nullNode);
					sb.append("\n");
					flag++;
				} else
					break;
			}
		}

		System.out.println(sb.toString());

	}

	private static void printZigZag(Stack<Node> s1, Stack<Node> s2, boolean b) {
		if (s1.isEmpty())
			return;
		while (!s1.isEmpty()) {
			Node n = s1.pop();
			if (n != null) {
				System.out.println(n.val);
				if (b) {
					s2.push(n.right);
					s2.push(n.left);
				} else {
					s2.push(n.left);
					s2.push(n.right);
				}
			}
		}
		printZigZag(s2, s1, !b);

	}

}
