package com.gold;

public class SumOfDigitOfNumber {

	
	public static int sumOfDigitOfNumber(int num)
	{
		int sum=num;
		while(sum>10){
			num=sum;
			sum=0;
		while(num!=0)
		{
			sum+=(num%10);
			num=num/10;
		}
		}
		return sum;
	}
	public static int sumOfDigitOfNumberWithTrick(int num)
	{
		return (num%9==0 && num!=0)?9:num%9;
	}
	
	
	
	public static void main(String []args)
	{
		System.out.println(sumOfDigitOfNumber(441345));
		System.out.println(sumOfDigitOfNumberWithTrick(441345));
	}
}

