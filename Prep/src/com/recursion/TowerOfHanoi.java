package com.recursion;

public class TowerOfHanoi {
	
	public static void towerrOfHanoi(int n,char start,char aux,char destination)
	{
		if(n==1)
		{
			System.out.println(start + "-->" + destination);
		}
		else
		{
			towerrOfHanoi(n-1, start,destination , aux);
			System.out.println(start + "-->" + destination);
			towerrOfHanoi(n-1, aux, start, destination);
		}
	}

	public static void main(String []args)
	{
		char start='A';
		char aux='B';
		char destination ='C';
		towerrOfHanoi(4, start, aux, destination);
	}

}
