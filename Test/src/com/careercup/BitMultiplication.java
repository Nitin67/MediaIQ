package com.careercup;

class XBigInt {
	public int[] array;

	public XBigInt(int[] array) {
		this.array = array;
	}

	public XBigInt() {
	}
	public void printBigInt(){
		int length = array.length;
		for(int i=0;length!=0&&i<length;i++){
			System.out.println(array[i]);
		}
	}
}

public class BitMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		XBigInt a = new XBigInt(new int[] { 0, 1});
		XBigInt b = new XBigInt(new int[] { 0, 1});
		XBigInt c = new XBigInt();
		c.array = new int[a.array.length + b.array.length];
		multiply(a, b, c);
	}

	private static void multiply(XBigInt a, XBigInt b, XBigInt c) {
		int aLength = a.array.length;
		for (int i = 0; i < aLength; i++) {
			if (a.array[i] != 0) {
				c = addArray(c.array, moveDigit(b.array, i));
			}
		}
		c.printBigInt();
	}

	private static XBigInt addArray(int[] a, int[] b) {
		int[] c = new int[a.length];
		int carry = 0;
		int i = 0;
		for (; i < c.length; i++) {
			int sum = 0;
			if (i < a.length && i < b.length) {
				sum = a[i] + b[i] + carry;
			} else if (i < a.length) {
				sum = a[i] + carry;
			} else if (i < b.length) {
				sum = b[i] + carry;
			} else {
				sum = carry;
			}
			c[i] = sum % 2;
			carry = sum / 2;
		}
		return new XBigInt(c);
	}

	private static int[] moveDigit(int[] arrayInt, int i) {
		int[] c = new int[arrayInt.length+i];
		for (int j = 0; j < arrayInt.length; j++) {
			c[i + j] = arrayInt[j];
		}
		return c;
	}

}
