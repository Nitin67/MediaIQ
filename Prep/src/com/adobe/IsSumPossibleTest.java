package com.adobe;


import java.util.Collections;
import java.util.Vector;

public class IsSumPossibleTest {

	public static int isSumPossible(Vector<Integer> voi,int sum)
	{
		Collections.sort(voi);
		for(int i=0,j=voi.size()-1;i<j;)
		{
			if(voi.get(i)+voi.get(j)==sum)
				return 1;
			else if(voi.get(i)+voi.get(j)>sum)
				j--;
			else if(voi.get(i)+voi.get(j)<sum)
				i++;
		}
		return 0;
	}
	
	public static void main(String []args)
	{
		Vector<Integer> v=new Vector<Integer>();
		v.add(34);
		v.add(12);
		v.add(48);
		v.add(10);
		v.add(15);
		
		
		System.out.println(isSumPossible(v, 25));
	}
	
}
