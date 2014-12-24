package com.walmart.demo;

enum Student {
	Nitin(22), Sid(23), Tushar(23);
	Student(int k) {
		this.age = k;
	}

	private int age;

	public int getAge() {
		return age;

	}
}

public class Enumerations {

	public static void main(String[] args) {

		Student stud = Student.Nitin;
		System.out.println(stud.getAge());

		Integer i = 10; // AutoBoxing
		int j = i; // Unboxing
		System.out.println(j);

	}
}
