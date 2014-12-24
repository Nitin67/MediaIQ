package com.random;

class ListNode {
	int data;
	ListNode next;

	public ListNode(int data) {
		this.data = data;
		next = null;
	}
}

public class ReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode previous = new ListNode(0);
		ListNode head = previous;
		for (int i = 1; i < 10; i++) {
			ListNode node = new ListNode(i);
			previous.next = node;
			previous = node;
		}
		previous.next = head;
		head = reverseList(head);
		int i = 0;
		while (i < 100) {
			System.out.println(head.data);
			head = head.next;
			i++;
		}
	}

	private static ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode temp = head.next;
		head.next = null;
		ListNode reversedList = reverseList(temp);
		temp.next = head;
		return reversedList;
	}

}
