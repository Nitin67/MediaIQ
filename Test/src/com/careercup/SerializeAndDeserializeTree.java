package com.careercup;

class TNode {
	public int data;
	public TNode left;
	public TNode right;

	public TNode(int data) {
		this.data = data;
	}
}

public class SerializeAndDeserializeTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TNode head = new TNode(1);
		TNode node1 = new TNode(2);
		head.left = node1;
		TNode node2 = new TNode(3);
		head.right = node2;
//		TNode node3 = new TNode(4);
//		node2.left = node3;
		String str = serealize(head);
		System.out.println(str);
		head = convertToLinkedList(head);
		while (head != null) {
			System.out.println(head.data);
			head = head.right;
		}

	}

	private static String serealize(TNode head) {
		if (head == null)
			return "";
		String left = serealize(head.left);
		String right = serealize(head.right);
		StringBuffer sb = new StringBuffer();
		sb.append(head.data);

		if (left.equals("") && right.equals(""))
			sb.append("");
		else if (left.equals(""))
			sb.append("(" + right + ")");
		else if (right.equals(""))
			sb.append("(" + left + ")");
		else
			sb.append("(" + left + "," + right + ")");
		return sb.toString();
	}

	private static TNode deserealize(String str) {
		if (str == null)
			return null;
		if (str.equals(""))
			return null;
		String[] nodeDetail = getNodeDetail(str);
		TNode head = new TNode(Integer.valueOf(nodeDetail[0]));
		head.left = deserealize(nodeDetail[1]);
		head.right = deserealize(nodeDetail[2]);
		return head;

	}

	private static String[] getNodeDetail(String str) {
		String[] nodeDetail = new String[3];
		int i = 0;
		while (str.charAt(i) != '(' && i < str.length())
			i++;
		nodeDetail[0] = str.substring(0, i);
		if (i != str.length()) {
			String temp = str.substring(i + 1, str.length() - 1);
		}

		return null;
	}

	private static TNode convertToLinkedList(TNode head) {
		if(head==null)
			return null;
		if (head.left == null)
			return head;
		TNode temp = head.right;
		TNode tempHead = head;
		head.right = convertToLinkedList(head.left);
		tempHead.left = null;
		while (head.right != null)
			head = head.right;
		head.right = convertToLinkedList(temp);
		return tempHead;
	}

}
