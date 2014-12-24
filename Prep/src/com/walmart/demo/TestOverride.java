package com.walmart.demo;

public class TestOverride extends Test {

	public static void method() {
		System.out.println("method in testOverride");
	}

	public void methd() {
		System.out.println("methd in testOverride");
	}

	public static void main(String[] args) {
		Test testOverrideInTest = new TestOverride();
		testOverrideInTest.methd();
		method();
	}
}
