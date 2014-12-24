package com.walmart.demo;

import java.util.List;

class Gen {

	double d;

	<T extends Number> Gen(T ob) {
		d = ob.doubleValue();
	}

	void showVar() {
		System.out.println(d);
	}
}

public class GenericTest {

	public static <T, V extends Number> void genString(T t, V v) {
		System.out.println(t + " --->" + v);
	}

	public static <S, N> S genReturn(S s, N n) {
		return s;
	}

	public static void main(String[] args) {
		Generic<Integer> gti = new Generic<Integer>(10);
		System.out.println(gti.getOb());
		Generic<String> gts = new Generic<String>("String from generic ");
		System.out.println(gts.getOb());
		Generic<Double> gtf = new Generic<Double>(3.23);
		System.out.println(gtf.getOb());
		Gen gen = new Gen(100);
		gen.showVar();
		Gen gen1 = new Gen(90.90);
		gen1.showVar();
		genString("This is gen Function ", 300);
		int k = genReturn(200, "blueo");
		System.out.println(k);
	}
}
