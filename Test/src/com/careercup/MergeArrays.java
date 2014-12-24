package com.careercup;

public class MergeArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {2,3,6,7,9};
		int[] b = {4,5,8,10,-1,-1,-1,-1,-1};
		int[] c = mergeArrays(a,b);
		for(int n:c)
			System.out.println(n);

	}

	private static int[] mergeArrays(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		for(int i=n-m-1,j=n-1;i>=0;i--,j--){
			b[j] = b[i];
			b[i] = -1;
		}
		for(int i=0,j=m,k=0;i<a.length;){
			if(a[i]>b[j]){
				b[k] = b[j];
				j++;k++;
			}else{
				b[k] = a[i];
				i++;k++;
			}
		}
		return b;
	}

}
