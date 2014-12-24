package com.careercup;

import java.util.Stack;

public class BalancedBraces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "{(}{)}";
		boolean isBalanced = isBalanced(str);
		System.out.println(isBalanced);

	}

	private static boolean isBalanced(String str) {
		int strLength = str.length();
		Stack<Character> s1 = new Stack<Character>();
		boolean isBalanced = false;
		for(int i=0;i<strLength;i++){
			char strChar = str.charAt(i);
			if(strChar=='{'||strChar=='('||strChar=='['||strChar=='<'){
				s1.push(strChar);
			}else{
				Character charOut = (char) s1.pop();
				if(charOut!=null){
					if(charOut=='{'&&strChar=='}'||charOut=='('&&strChar==')'||charOut=='['&&strChar==']'||charOut=='<'&&strChar=='>')
						isBalanced = true;
					else{
						isBalanced = false;
						break;
					}
				}else{
					return false;
				}
			}
		}
		return isBalanced;
	}

}
