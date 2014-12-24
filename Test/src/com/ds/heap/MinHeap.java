package com.ds.heap;

public class MinHeap {
	public HeapNode head;

	public MinHeap() {
		this.head = null;
	}

	public HeapNode insert(int data) {
		return insert(data, head);
	}

	private HeapNode insert(int data, HeapNode head) {
		if (head == null)
			return new HeapNode(data);
		else {
			if (data < head.data) {
				HeapNode node = new HeapNode(data);
				node.next = head;
				head.previous = node;
				return node;
			} else {
				HeapNode child = insert(data, head.next);
				head.next = child;
				child.previous = head;
				return head;
			}

		}
	}

}
