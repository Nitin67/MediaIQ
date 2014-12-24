package com.ds.heap;

public class MaxHeap {
	public HeapNode root;

	public HeapNode insert(int data) {
		return insert(data, root);
	}

	private HeapNode insert(int data, HeapNode root) {
		if (root == null)
			return new HeapNode(data);
		else {
			if (data > root.data) {
				HeapNode node = new HeapNode(data);
				node.next = root;
				root.previous = node;
				return node;
			} else {
				HeapNode child = insert(data, root.next);
				root.next = child;
				child.previous = root;
				return root;
			}
		}
	}
}
