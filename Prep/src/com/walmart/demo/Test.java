package com.walmart.demo;

public class Test {
	public static void main(String[] args) {
		System.out.println("Average: " + avg(20.3, 3.1415, 32.3));
		System.out.println("Concatenation: " + concat("Hello", " ", "World"));

		Test test = new Test();
		test.method();
		Test testOverrideInTest = new TestOverride();
		testOverrideInTest.method();
		TestOverride testOverride = new TestOverride();
		testOverride.method();

		test.methd();
		testOverrideInTest.methd();
		testOverride.methd();

		// new TestOverride().method();
	}

	public void methd() {
		System.out.println("methd in test");
	}

	public static void method() {
		System.out.println("method in test");
	}

	static double avg(double... numbers) {
		double total = 0;
		for (int i = 0; i < numbers.length; i++)
			total += numbers[i];
		return total / numbers.length;
	}

	static String concat(String... strings) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strings.length; i++)
			sb.append(strings[i]);
		return sb.toString();
	}

}
