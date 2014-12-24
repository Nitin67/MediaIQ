package com.careercup;

public class MaximumProfit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] sharePrice = {23,23,41,23,45,66,12,34,57};
		int max_profit = sharePrice[1]-sharePrice[0];
		int min = sharePrice[0]; 
		for(int i=1;i<sharePrice.length;i++){
			if(max_profit<sharePrice[i]-min){
				max_profit=sharePrice[i]-min;
			}
			if(min>sharePrice[i])
				min=sharePrice[i];
		}
		System.out.println(max_profit);;

	}

}
