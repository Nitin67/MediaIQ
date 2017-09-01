package org.singleton;

public class Singleton {
	
	//Eager loading singleton example
	private static Singleton singleton= new Singleton();
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	public static Singleton getSingletonObj(){
		return singleton;
	}
	
}
