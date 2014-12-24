package com.careercup;

public class NumberProducts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] products = products(new int[] { 1 });
		for (int i : products)
			System.out.println(i);
	}

	private static int[] products(int[] is) {
		int[] frontProducts = new int[is.length];
		int[] rearProducts = new int[is.length];
		int[] product = new int[is.length];
		for (int i = 0; i < is.length; i++) {
			if (i == 0)
				frontProducts[i] = is[i];
			else
				frontProducts[i] = is[i] * frontProducts[i - 1];
		}
		for (int i = is.length - 1; i >= 0; i--) {
			if (i == is.length - 1)
				rearProducts[i] = is[i];
			else
				rearProducts[i] = is[i] * rearProducts[i + 1];
		}
		for (int i = 0; i < is.length; i++) {
			if (i == 0 && i != is.length - 1)
				product[i] = rearProducts[i + 1];
			else if (i == is.length - 1 && i != 0)
				product[i] = frontProducts[i - 1];
			else if (i != 0 && i != is.length - 1)
				product[i] = rearProducts[i + 1] * frontProducts[i - 1];
			else
				product[i] = is[i];
		}
		return product;
	}

}
