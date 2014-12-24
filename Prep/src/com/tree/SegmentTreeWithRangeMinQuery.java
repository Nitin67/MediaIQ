package com.tree;

public class SegmentTreeWithRangeMinQuery {

	public static void main(String []args)
	{
		int ar[]= {1, 3, 2, 7, 9, 11};
		
		int st[]=constructST(ar);
		
		System.out.println(RMQ(st,0,ar.length-1,1,5,0));
	}

	private static int RMQ(int[] st,  int ss, int se, int qs, int qe,
			int m) {
		
		if(qs<=ss && qe>=se)
			return st[m];
		
		if(qs>se || qe<ss)
			return Integer.MAX_VALUE;
		
		int mid=ss + (se-ss)/2;
		return Math.min(RMQ(st, ss, mid, qs, qe, 2*m+1), RMQ(st,  mid +1,se, qs, qe, 2*m+2));
					
		
	}

	private static int[] constructST(int[] ar) {
		int n=ar.length;
		int size= 2*(int)Math.pow(2, (int)Math.ceil(Math.log(n)/Math.log(2)))-1;
		int st[]=new int[size];
		constructSTUtil(ar,st,0,n-1,0);
		
		return st;
	}

	private static int constructSTUtil(int[] ar, int[] st, int i, int j, int k) {
		if(i==j)
			st[k]=ar[i];
		else{
		int mid=i+(j-i)/2;
		st[k]= Math.min( constructSTUtil(ar, st, i, mid, 2*k+1),constructSTUtil(ar, st, mid+1, j, 2*k+2));
		}return st[k];
	}
}
