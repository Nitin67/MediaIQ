package com.careercup;

import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ExpressionEvaluator {

	/**
	 * @param args
	 * @throws ScriptException
	 * 
	 *             f[x]=ex+c f[0]=c f[1]=e+c x=-1*c/e=f[0]/(f[0]-f[1])
	 */
	public static void main(String[] args) throws ScriptException {
		System.out.println(evaluateExpressionForVariable("3x+(29*4x-4x)/x", 3));
		ScriptEngineManager sm = new ScriptEngineManager();
		ScriptEngine se = sm.getEngineByName("JavaScript");
		System.out.println(se.eval(evaluateExpressionForVariable(
				"3x+(29*4x-4x)/x", 3)));
		/*
		 * evaluate(evaluateExpressionForVariable( "3x+(29*4x-4x)/x", 3));
		 */
		System.out.println(evaluate("3*3+(29*4*3-4*3)/3"));

	}

	public static int evaluate(String string) {
		Stack<Character> opStack = new Stack<Character>();
		Stack<Integer> conStack = new Stack<Integer>();
		for (int i = 0; i < string.length();) {
			char character = string.charAt(i);
			if (character == '(') {
				opStack.push(character);
				i++;
			} else if (character >= '0' && character <= '9') {
				StringBuffer sb = new StringBuffer();
				while (i < string.length() && string.charAt(i) >= '0'
						&& string.charAt(i) <= '9')
					sb.append(string.charAt(i++));
				conStack.push(Integer.valueOf(sb.toString()));
			} else if (character == ')') {
				Integer con2 = conStack.pop();
				Integer con1 = conStack.pop();
				conStack.push(eval(opStack.pop(), con1, con2));
				opStack.pop();
				i++;
			} else if (character == '+' || character == '-' || character == '*'
					|| character == '/') {
				if (!opStack.isEmpty() && (opStack.peek() != '(')) {
					char op2 = character;
					char op1 = opStack.pop();
					if (hasPresedence(op1, op2)) {
						Integer con2 = conStack.pop();
						Integer con1 = conStack.pop();
						conStack.push(eval(op2, con1, con2));
						opStack.push(op1);
					} else {
						StringBuffer sb = new StringBuffer();
						i++;
						while (i < string.length() && string.charAt(i) >= '0'
								&& string.charAt(i) <= '9')
							sb.append(string.charAt(i++));
						i--;
						Integer con = Integer.valueOf(sb.toString());
						conStack.push(eval(op1, conStack.pop(), con));
						opStack.push(op2);
					}

				} else
					opStack.push(character);
				i++;
			} else {
				System.out.println("Invalid Character " + character);
			}

		}
		conStack.push(eval(opStack.pop(), conStack.pop(), conStack.pop()));
		return conStack.pop();
	}

	private static boolean hasPresedence(char op2, char op1) {
		return getPriority(op1) < getPriority(op2);
	}

	private static int getPriority(char c) {
		switch (c) {
		case '+':
			return 1;
		case '-':
			return 2;
		case '/':
			return 3;
		case '*':
			return 4;
		}
		return 0;
	}

	private static Integer eval(Character operator, Integer op1, Integer op2) {
		switch (operator) {
		case '+':
			return op1 + op2;
		case '-':
			return op1 - op2;
		case '*':
			return op1 * op2;
		case '/':
			if (op2 != 0) {
				return op1 / op2;
			} else
				return 0;
		default:
			break;
		}
		return 0;
	}

	private static String evaluateExpressionForVariable(String string,
			int number) {
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < string.length(); i++) {
			if (isNumber(String.valueOf(string.charAt(i))))
				stack.push(String.valueOf(string.charAt(i)));
			else if (string.charAt(i) == 'x') {
				if (!isNumber(stack.peek()))
					stack.push(String.valueOf(number));
				else {
					stack.push("*");
					stack.push(String.valueOf(number));
				}
			} else {
				stack.push(String.valueOf(string.charAt(i)));
			}
		}
		String exp = "";
		while (!stack.isEmpty())
			exp = stack.pop() + exp;
		return exp;
	}

	private static boolean isNumber(String string) {
		if (string.charAt(0) >= '0' && string.charAt(0) <= '9')
			return true;
		return false;
	}

}
