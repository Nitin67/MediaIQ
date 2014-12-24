package com.careercup;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NumberEvenlyDividedByNumbersTillN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("3.4".replace('.', '\0'));
		printMultiple(10);
	}

	private static void printMultiple(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i <= n; i++)
			findPrimeFactors(i, map);
		printNumber(map);
	}

	private static void printNumber(Map<Integer, Integer> map) {
		Iterator<Integer> itr = map.keySet().iterator();
		int r = 1;
		while (itr.hasNext()) {
			int n = itr.next();
			int i = map.get(n);
			while (i > 0) {
				r = r * n;
				i--;
			}
		}
		System.out.println(r);
	}

	private static void findPrimeFactors(int num, Map<Integer, Integer> map) {
		int n = num;
		int j2 = 0;
		while (n % 2 == 0) {
			j2++;
			n = n / 2;
		}
		if (j2 > 0) {
			if (map.containsKey(2)) {
				map.put(2, map.get(2) < j2 ? j2 : map.get(2));
			} else {
				map.put(2, j2);
			}
		}
		int i = 3;
		for (i = 3; i < Math.sqrt(n); i = i + 2) {
			if (n % i == 0) {
				int k = 0;
				while (n % i == 0) {
					k++;
					n = n / i;
				}
				if (map.containsKey(i)) {
					map.put(i, map.get(i) > k ? map.get(i) : k);
				} else {
					map.put(i, k);
				}
			}
		}
		if (n > 2) {
			if (n > i && map.containsKey(n)) {
				int r = 0;
				while (num % n == 0) {
					r++;
					num = num / n;
				}
				if (map.get(n) < r) {
					map.put(n, r);
				}
			} else if (!map.containsKey(n)) {
				map.put(n, 1);
			}
		}
		// System.out.println(map.toString());
	}

}
