package com.walmart.demo;

public class RevealTriangle {

	public static String[] calcTriangle(String triangle[]) {

		int size = triangle.length;
		System.out.println(size);
		for (int i = size - 2; i >= 0; i--) {
			StringBuilder str = new StringBuilder(triangle[i]);

			int j = 0;
			for (j = 0; j < str.length(); j++) {
				if (str.charAt(j) != '?')
					break;
			}
			for (int k = j; k < str.length() - 1; k++) {
				int num = triangle[i + 1].charAt(k) - str.charAt(k);
				if (num < 0) {
					num += 10;
				}
				char c = (char) (num + 48);
				str.setCharAt(k + 1, c);
			}
			for (int k = j; k > 0; k--) {
				int num = triangle[i + 1].charAt(k - 1) - str.charAt(k);
				if (num < 0) {
					num += 10;
				}
				char c = (char) (num + 48);
				str.setCharAt(k - 1, c);
			}
			triangle[i] = str.toString();
		}

		return triangle;

	}

	public static void main(String[] args) {

		String tri[] = { "??5?", "??9", "?4", "6" };
		String tri2[] = calcTriangle(tri);
		for (int i = 0; i < tri2.length; i++) {
			System.out.println(tri2[i]);
		}
	}

}
