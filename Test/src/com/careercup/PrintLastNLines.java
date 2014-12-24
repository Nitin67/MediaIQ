package com.careercup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CircularFixedSizeList<T> extends ArrayList<T>{
	private static final long serialVersionUID = 1L;
	private int size = 0;
	List<T> list = null;
	public CircularFixedSizeList(int size1){
		this.size = size1;
		new ArrayList<T>();
	}
	public boolean add(T t){
		if(this.size()>=size){
			this.remove(0);
			return super.add(t);
		}else{
			return super.add(t);
		}
		
	}
}
public class PrintLastNLines {
	static List<Integer> list = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] intArray = {1,23,1,23,4,234,5,6,4657,67,323,1,32,45};
		int size = 5;
		list = new CircularFixedSizeList<Integer>(size);
		for(int val:intArray){
			list.add(val);
		}
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

}
