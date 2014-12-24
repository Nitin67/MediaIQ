package com.careercup;

import java.util.Stack;

public class RemoveUnwantedBraces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "(((A+B)*C()))";
		char[] charArray = str.toCharArray();
		Stack<Character> operator = new Stack<Character>();
		Stack<Character> braces = new Stack<Character>();
		for (char chr : charArray) {
			if (chr == ')') {
				if (operator.isEmpty()) {
					Stack<Character> temp = new Stack<Character>();
					while (!braces.isEmpty()) {
						char tempChar = braces.pop();
						if (tempChar != '(')
							temp.push(tempChar);
						else
							break;
					}
					while (!temp.isEmpty()) {
						braces.push(temp.pop());
					}
				} else {
					braces.push(chr);
					operator.pop();
				}
			} else {
				braces.push(chr);
				if (chr == '*' || chr == '+' || chr == '/' || chr == '-') {
					operator.push(chr);
				}

			}
		}
	}

}
