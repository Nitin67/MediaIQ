package com.walmart.demo;

import java.util.Stack;

public class LostParentheses {

	public static int minResult(String e) {

		boolean max = false;
		StringBuilder str = new StringBuilder();
		Stack<Integer> soi = new Stack<Integer>();
		Stack<Character> soc = new Stack<Character>();
		int size = e.length();
		for (int i = 0; i < size; i++) {
			if (e.charAt(i) == '+') {
				int num;
				if (!soc.empty() && soc.peek() == '+') {
					int sec = Integer.parseInt(str.toString());
					num = soi.pop() + sec;
					soc.pop();
				} else {
					num = Integer.parseInt(str.toString());
				}
				soi.push(num);
				soc.push('+');
				str.setLength(0);
			} else if (e.charAt(i) == '-') {
				int num;
				if (!soc.empty() && soc.peek() == '+') {
					int sec = Integer.parseInt(str.toString());
					num = soi.pop() + sec;
					soc.pop();
				} else {
					num = Integer.parseInt(str.toString());
				}
				soi.push(num);
				str.setLength(0);
				soc.push('-');
				max = !max;

			} else {
				str.append(e.charAt(i));
				if (i == size - 1) {
					int num;
					if (!soc.empty() && soc.peek() == '+') {
						int sec = Integer.parseInt(str.toString());
						num = soi.pop() + sec;
						soc.pop();
					} else {
						num = Integer.parseInt(str.toString());
					}
					soi.push(num);
				}
			}

		}

		while (!soi.empty() && !soc.empty()) {
			char c = soc.pop();

			if (c == '-') {
				if (!soc.empty() && soc.peek() == '-') {
					int num = soi.pop() + soi.pop();
					soi.push(num);
				} else {
					int sec = soi.pop();
					int num = soi.pop() - sec;
					soi.push(num);
				}
				max = !max;
			}

		}
		return soi.lastElement();
	}

	public static void main(String[] args) {
		System.out
				.println(minResult("00010+20+30+40-34-329-394+28-334+20-329-394+28-39"));

	}
}
