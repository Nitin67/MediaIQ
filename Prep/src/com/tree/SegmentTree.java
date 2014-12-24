package com.tree;

import java.util.Scanner;

public class SegmentTree {

	
	
	public static void main(String []args)
	{
		int []ar={1, 3, 5, 7, 9, 11};
		int []st=constructST(ar);
		Scanner scanner=new Scanner(System.in);
		int index=scanner.nextInt();
		int newValue=scanner.nextInt();
		System.out.println(getSum(st, ar, 1, 3));
		updateVal(st,ar,ar.length-1,index,newValue);
		System.out.println(getSum(st, ar, 1, 3));
		
		
	}

	
	
private static int getSum(int[] st, int[] ar, int i, int j) {
		if(i>j || i<0 || j>ar.length-1)
		{
			System.out.println("Invalid input");
			return Integer.MIN_VALUE;
		}
		return getSumUtil(st,0,ar.length-1,i,j,0);
	}



private static int getSumUtil(int[] st, int i, int j, int qs, int qe, int k) {
	
	if(j<qs || i>qe)
	return 0;
	if(qs<=i && qe>=j)
		return st[k];
	int mid=i+(j-i)/2;
	return getSumUtil(st, i, mid, qs, qe, 2*k+1) + getSumUtil(st, mid+1, j, qs, qe, 2*k+2);
}



private static void updateVal(int[] st, int[] ar, int i, int index,
			int newValue) {
		
		if(index<0 || index>=ar.length)
		{
			System.out.println("index not in range");
			return;
		}
		int diff=newValue- ar[index];
		ar[index]=newValue;
		updateValUtil(st,0,ar.length-1,0 , diff, index);
		
	}



	private static void updateValUtil(int[] st, int i, int length, int j, int diff,
		int index) {
		if(index>length || index<i)
			return;
		
		st[j]+=diff;
		if(i!=length)
		{
			int mid=i +(length-i)/2;
			updateValUtil(st, i, mid, 2*j+1, diff, index);
			updateValUtil(st, mid+1, length, 2*j+2, diff, index);
		}
}




	private static int[] constructST(int[] ar) {
	int n=ar.length;
	int size=2*(int)Math.pow(2,((int)Math.ceil(Math.log(n)/Math.log(2))))-1;
	int []st=new int [size];
	constructSTUtil(ar,st,0,n-1,0);
	return st;
	}

	private static int constructSTUtil(int[] ar, int[] st, int i, int j, int k) {
		if(i==j)
			st[k]=ar[i];
		else
		{
			int mid=i+(j-i)/2;
			st[k]= constructSTUtil(ar, st, i, mid, 2*k+1)+constructSTUtil(ar, st, mid+1, j, 2*k+2);
		}
		return st[k];
	}
}
