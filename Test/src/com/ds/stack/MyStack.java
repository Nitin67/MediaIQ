package com.ds.stack;

public class MyStack {
	private final Integer INITIAL_SIZE = 16;
	private int size;
	private int currentMaxSize;
	private Object[] stack;

	public MyStack() {
		currentMaxSize = INITIAL_SIZE;
		size = 0;
		stack = new Object[currentMaxSize];
	}

	public void push(Object object) {
		if (size == currentMaxSize) {
			increaseCapacity();
		}
		stack[size] = object;
		size++;
	}

	public Object pop() {
		size--;
		Object result = stack[size];
		stack[size] = null;
		return result;
	}

	private void increaseCapacity() {
		currentMaxSize = currentMaxSize * 2;
		Object[] newStack = new Object[currentMaxSize];
		for (int i = 0; i < stack.length; i++) {
			newStack[i] = stack[i];
		}
		stack = newStack;
	}
}
