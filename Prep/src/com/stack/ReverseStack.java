package com.stack;

import java.util.Stack;

public class ReverseStack {

	public static void revertStack(Stack<Integer> s) {
	    if (s.isEmpty()) {
	        return;
	    } else {
	        Integer a = s.pop();
	        revertStack(s);
	        appendStack(s, a);
	    }
	}

	public static void appendStack(Stack<Integer> s, Integer a) {
	    if (s.isEmpty()) {
	        s.push(a);
	        return;
	    } else {
	        Integer o = s.pop();
	        appendStack(s, a);
	        s.push(o);
	    }
	}
	public static void  main(String []args)
	{
		Stack<Integer> stack=new Stack<Integer>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		System.out.println(stack.peek());
		revertStack(stack);
		System.out.println(stack.peek());

	}
}
