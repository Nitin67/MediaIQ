package com.careercup.dash;

class ResultNode {
	public int data = 0;
	public ResultNode previous;
	public ResultNode next;
	private int radix = 10;
	boolean isHead = false;

	public ResultNode(boolean isHead, int radix) {
		this.isHead = isHead;
		this.radix = radix;
	}

	public ResultNode getNext() {
		if (this.next == null) {
			ResultNode node = new ResultNode(false, this.radix);
			node.previous = this;
			this.next = node;
			return node;
		}
		return this.next;
	}

	public ResultNode getPrevious() {
		if (this.previous == null) {
			ResultNode node = new ResultNode(false, this.radix);
			this.previous = node;
			node.next = this;
			return node;
		}
		return this.previous;
	}

	public ResultNode getHead() {
		if (this.isHead)
			return this;
		if (this.previous != null) {
			return this.previous.getHead();
		}
		return null;
	}

	public ResultNode getStart() {
		if (this.previous == null)
			return this;
		return this.previous.getStart();
	}

	public void increase(int value) {
		if (value > 0) {
			value = value + this.data;
			this.data = value % radix;
			if (value / radix > 0)
				this.getPrevious().increase(value / radix);
		}
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		ResultNode r = this.getStart();
		while (r != null) {
			sb.append(r.data + ",");
			r = r.next;
		}
		return sb.toString();
	}
}

public class MultiplyTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] n1 = new int[] { 1, 0 };
		int[] n2 = new int[] { 1, 0 };
		System.out.println(multiply(2, n1, n2).toString());
	}

	private static ResultNode multiply(int radix, int[] n1, int[] n2) {
		ResultNode result = new ResultNode(true, radix);
		int offset = 0;
		for (int i = 0; i < n1.length; i++) {
			int k = offset;
			result = result.getHead();
			while (k > 0) {
				result = result.getNext();
				k--;
			}
			for (int j = 0; j < n2.length; j++) {
				result.increase(n1[i] * n2[j]);
				if (j != n2.length - 1)
					result = result.getNext();
			}
			offset++;
		}
		return result;
	}

}
