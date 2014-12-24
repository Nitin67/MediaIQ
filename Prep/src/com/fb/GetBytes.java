package com.fb;

public class GetBytes {

	public static void main(String []args)
	{
		String str="kill";
		byte[]bytes=str.getBytes();
	
		System.out.println(bytes.length);
		for(byte b:bytes)
		{
			System.out.println(b);
		}
	}
}
