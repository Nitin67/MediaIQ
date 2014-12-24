package com.careercup;

class NNode {
	public int val;
	public NNode next;

	public NNode() {
		// TODO Auto-generated constructor stub
	}
}

class RNode {
	public int val;
	public RNode next;
	public RNode previous;
	public boolean isHead = false;

	public RNode() {

	}

	public RNode getNextNode() {
		if (this.next == null) {
			RNode next = new RNode();
			next.previous = this;
			this.next = next;
			return next;
		} else {
			return this.next;
		}
	}

	public void increaseVal(int val) {
		if (val > 0) {
			int sum = this.val + val;
			this.val = sum % 10;
			RNode previous = this.previous;
			if (sum / 10 > 0) {
				if (previous == null) {
					previous = new RNode();
					this.previous = previous;
					previous.next = this;
				}
				previous.increaseVal(sum / 10);
			}
		}
	}

	public RNode getHead() {
		if (this.isHead)
			return this;
		else {
			RNode head = this.previous != null ? this.previous.getHead() : null;
			return head;
		}
	}

	public RNode getFirstNode() {
		if (this.previous != null)
			return this.previous.getFirstNode();
		return this;
	}
}

public class MultiplyLinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NNode head1 = new NNode();
		head1.val = 9;
		NNode node1 = new NNode();
		node1.val = 9;
		head1.next = node1;
		NNode node3 = new NNode();
		node3.val = 9;
		node1.next = node3;

		NNode head2 = new NNode();
		head2.val = 9;
		NNode node2 = new NNode();
		node2.val = 9;
		head2.next = node2;

		RNode result = multiply(head1, head2);
		StringBuffer sb = new StringBuffer();
		while (result != null) {
			sb.append(result.val);
			result = result.next;
		}
		System.out.println(sb.toString());
	}

	private static RNode multiply(NNode head1, NNode head2) {
		RNode result = new RNode();
		result.isHead = true;
		int i = 0;
		NNode node1 = head1;
		while (node1 != null) {
			RNode startNode = result.getHead();
			int j = i;
			while (j > 0) {
				startNode = startNode.getNextNode();
				j--;
			}
			NNode node2 = head2;
			while (node2 != null) {
				startNode.increaseVal(node1.val * node2.val);
				node2 = node2.next;
				if (node2 != null)
					startNode = startNode.getNextNode();
			}
			node1 = node1.next;
			i++;
		}
		return result.getFirstNode();
	}

}
