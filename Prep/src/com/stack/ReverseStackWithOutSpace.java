package com.stack;

import java.util.Stack;

public class ReverseStackWithOutSpace {

	public static void reverseStack(Stack<Integer> stack)
	{
		if(stack.isEmpty())
		{
			return;
		}
		else{
			Integer a=stack.pop();
			reverseStack(stack);
			appendStack(stack,a);
		}
	}
	public static void appendStack(Stack<Integer>s, Integer a)
	{
		if(s.isEmpty())
		{
			s.push(a);
			return;
		}else{
			Integer in=s.pop();
			appendStack(s, in);
			s.push(in);
		}
		
	}
	public static void main(String []args)
	{
		Stack<Integer> stack =  new Stack<Integer>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		System.out.println(stack.peek());
		reverseStack(stack);
		System.out.println(stack.peek());
	}
}
