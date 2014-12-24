package com.walmart.demo;

public class CuttingRod {

	int cuttingRod(int price[], int k) {
		if (k == 0)
			return 0;
		int max1 = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			max1 = max(max1, cuttingRod(price, k - i - 1) + price[i]);
		}
		return max1;
	}

	int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;

	}

	int dpCuttingRod(int price[], int size) {
		int val[] = new int[size + 1];
		val[0] = 0;

		for (int i = 1; i <= size; i++) {
			int maxl = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				maxl = max(maxl, val[i - j - 1] + price[j]);
			}
			val[i] = maxl;
		}
		return val[size];
	}

	public static void main(String[] args) {
		int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int size = price.length;
		CuttingRod cutRod = new CuttingRod();
		System.out.println(cutRod.cuttingRod(price, size));
		System.out.println(cutRod.dpCuttingRod(price, size));
	}

}
