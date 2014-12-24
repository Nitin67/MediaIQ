package com.walmart.demo;

class stack1 {
	int height;
	int index;
}

public class StackTest {

	int maxRectangleArea(int a[], int n) {
		int maxArea = -1, currentArea;
		int top = -1;
		stack1 st1[] = new stack1[n];

		for (int i = 0; i < n; i++) {
			st1[i] = new stack1();
			while (top >= 0 && st1[top].height > a[i]) {
				int left;
				if (top == 0)
					left = -1;
				else
					left = st1[top - 1].index;

				int hgt = st1[top].height;
				currentArea = (i - left - 1) * hgt;
				if (maxArea < currentArea) {
					maxArea = currentArea;
				}
				top--;
			}
			if (i < n) {
				top++;
				st1[top].height = a[i];
				st1[top].index = i;

			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 5, 6, 2, 4, 2, 5, 6, 1, 4 };
		StackTest st = new StackTest();
		System.out.println(st.maxRectangleArea(a, a.length));
	}

}
