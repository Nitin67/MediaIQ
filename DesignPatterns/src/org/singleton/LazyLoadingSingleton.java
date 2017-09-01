package org.singleton;

public class LazyLoadingSingleton {

	private static LazyLoadingSingleton singleton = null;
	private LazyLoadingSingleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static LazyLoadingSingleton getSingletonClass(){
		if(singleton == null){
			singleton = new LazyLoadingSingleton();
		}
		return singleton;
	}
}
