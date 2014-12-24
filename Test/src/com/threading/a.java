package com.threading;

public class a {

	private int i=10;
	public static void  main(String[] args){
		a a = new b();
		System.out.println(a.i);
		String s1  ="Test";
		String s2 = "Test";
		System.out.println(s1==s2);
		String s3 = new String("Test");
		System.out.println(s3==s1);
	}

}
class b extends a{
	int i=12;
}