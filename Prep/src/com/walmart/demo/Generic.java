package com.walmart.demo;

public class Generic<T> {

	T ob;

	Generic(T o) {
		ob = o;
	}

	public T getOb() {
		return ob;
	}

}
