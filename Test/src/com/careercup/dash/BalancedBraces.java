package com.careercup.dash;

import java.util.Stack;

public class BalancedBraces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String braces = "{{{}{}{}}}{}}";
		boolean isBalanced = isBalnced(braces);
		if (isBalanced)
			System.out.println("Balanced");
		else
			System.out.println("UnBalanced");

	}

	private static boolean isBalnced(String braces) {
		if (braces == null)
			return false;
		Stack<Character> charStack = new Stack<Character>();
		for (int i = 0; i < braces.length(); i++) {
			Character brace = braces.charAt(i);
			if (brace.equals('}')) {
				Character stackBrace = null;
				if (!charStack.isEmpty())
					stackBrace = charStack.pop();
				else
					return false;
				if (!stackBrace.equals('{'))
					return false;

			} else
				charStack.push(brace);
		}
		return true;
	}

}
