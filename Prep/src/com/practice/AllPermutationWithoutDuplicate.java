package com.practice;

import java.util.HashSet;

public class AllPermutationWithoutDuplicate {

	public static void generatePermutation(int ar[],int index)
	{
		if(index==ar.length-1)
		{
			for(int i:ar)
				System.out.print(i);
			System.out.println();
		}
		HashSet<Integer> set=new HashSet<Integer>();
		for(int i=index;i<ar.length;i++)
		{
			int size=set.size();
			set.add(ar[i]);
			if(i==index || size!=set.size()){
			swap(ar,i,index);
			generatePermutation(ar, index+1);
			swap(ar,i,index);
			}
		}
	}
	
	
	
	private static void swap(int[] ar, int i, int index) {
		int temp=ar[i];
		ar[i]=ar[index];
		ar[index]=temp;
		
	}



	public static void main(String []args)
	{
		int ar[]={1,2,2};
		generatePermutation(ar, 0);
	}
}
