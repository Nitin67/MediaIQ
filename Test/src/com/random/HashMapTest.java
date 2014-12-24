package com.random;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {
	public Integer val;

	public HashMapTest(Integer intVal) {
		this.val = intVal;
	}

	@Override
	public int hashCode() {
		return val % 2;
	}

	@Override
	public boolean equals(Object arg0) {
		return this.val == ((HashMapTest) arg0).val;
	}

	public static void main(String[] args) {
		Map<HashMapTest, Integer> map = new HashMap<HashMapTest, Integer>();
		HashMapTest obj1 = new HashMapTest(1);
		HashMapTest obj2 = new HashMapTest(2);
		HashMapTest obj3 = new HashMapTest(3);
		HashMapTest obj4 = new HashMapTest(4);
		map.put(obj1, 1);
		map.put(obj2, 2);
		map.put(obj3, 3);
		Iterator<Entry<HashMapTest, Integer>> itr1 = map.entrySet().iterator();
		while (itr1.hasNext()) {
			itr1.next();
			map.put(obj4, 4);
		}

		System.out.println("1: " + map.get(obj1));
		System.out.println("2: " + map.get(obj2));
		System.out.println("3: " + map.get(obj3));
		System.out.println("4: " + map.get(obj4));

		Set<HashMapTest> keySet = map.keySet();
		Iterator<HashMapTest> itr = keySet.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().val);
		}
	}
}
