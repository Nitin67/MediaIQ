package com.careercup;

public class CoinDenominationBounded {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] coins = new int[][] {{1,2,5},{3,2,1}};
		findCombinations(5,coins,0,"");
	}

	private static void findCombinations(int amount, int[][] coins, int indexToStartFrom,
			String output) {
		if(amount==0){
			System.out.println(output);
			return;
		}
		if(amount<0||indexToStartFrom==coins[0].length)
			return;
		if(coins[1][indexToStartFrom]>0){
			coins[1][indexToStartFrom] = coins[1][indexToStartFrom]-1;
			findCombinations(amount-coins[0][indexToStartFrom], coins, indexToStartFrom, output+","+coins[0][indexToStartFrom]);
			coins[1][indexToStartFrom] = coins[1][indexToStartFrom]+1;
		}
		findCombinations(amount, coins, indexToStartFrom+1, output);
	}

}
