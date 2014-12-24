package com.walmart.demo;

public class Knapsack {

	int knapsack(int W, int w[], int val[], int n) {
		if (W == 0 || n == 0)
			return 0;
		if (w[n - 1] > W)
			return knapsack(W, w, val, n - 1);

		return max(knapsack(W - w[n - 1], w, val, n - 1) + val[n - 1],
				knapsack(W, w, val, n - 1));
	}

	int dpKnapsack(int W, int w[], int val[], int n) {
		int res[][] = new int[n + 1][W + 1];
		for (int i = 0; i <= n; i++) {
			for (int k = 0; k <= W; k++) {
				if (i == 0 || k == 0)
					res[i][k] = 0;
				else {
					if (k < w[i - 1]) {
						res[i][k] = res[i - 1][k];
					} else {

						res[i][k] = max(res[i - 1][k],
								(res[i - 1][k - w[i - 1]] + val[i - 1]));

					}
				}
			}
		}
		return res[n][W];
	}

	int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;

	}

	public static void main(String[] args) {
		int w[] = { 2, 3, 4, 7 };
		int val[] = { 5, 6, 7, 15 };
		Knapsack knap = new Knapsack();

		System.out.println(knap.knapsack(10, w, val, 4));
		System.out.println(knap.dpKnapsack(10, w, val, 4));
	}
}
