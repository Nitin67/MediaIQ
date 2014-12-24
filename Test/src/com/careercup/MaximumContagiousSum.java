package com.careercup;

public class MaximumContagiousSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[]{1,4,-1,-3,6,-1,6};
		int sum = contagiousMaxSum(array);
		System.out.println(sum);
	}

	private static int contagiousMaxSum(int[] array) {
		if(array!=null){
			int max=-9999,currMax = -9999;
			int start=0,end=0;
			int count = 0;
			int i=0;
			for(int n:array){
				if(n>=(currMax+n)){
					currMax = n;
					count = 1;
					start=i;
					end=i;
				}else{
					currMax=currMax+n;
					count++;
					end=i;
				}
				if(currMax>max){
					max = currMax;
				}
				i++;
			}
			System.out.println(start);
			System.out.println(end);
			System.out.println(count);
			System.out.println(max);
			return max;
		}else{
			return 0;
		}
		
	}

}
