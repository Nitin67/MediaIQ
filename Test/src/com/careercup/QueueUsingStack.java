package com.careercup;

import java.util.Stack;

public class QueueUsingStack<T> {
	Stack<T> s1 = new Stack<T>();
	Stack<T> s2 = new Stack<T>();
	/**
	 * @param args
	 */
	public boolean offer(T t){
		try{
			s1.push(t);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public T poll(boolean isPeek){
		while(!s1.empty()){
			s2.push(s1.pop());
		}
		T t = s2.pop();
		if(isPeek){
			s2.push(t);
		}
		while(!s2.empty()){
			s1.add(s2.pop());
		}
		return t;
	}
	public void remove(){
		this.poll(false);
	}
	public T peek(){
		T t = this.poll(true);
		return t;
	}
	public T poll(){
		return this.poll(false);
	}
}
