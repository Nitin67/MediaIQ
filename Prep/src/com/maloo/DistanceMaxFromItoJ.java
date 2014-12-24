package com.maloo;



public class DistanceMaxFromItoJ {

	public static int maxSoFar(int []ar)
	{
		int maxsofarelements=0;
		int maxsofarvalue=ar[0];
		int []maxarray=new int[ar.length];
		maxarray[0]=0;
		for(int i=1;i<ar.length;i++)
		{
			if(ar[i]<maxsofarvalue)
			{
				
				maxarray[i]=maxsofarelements+1;
				maxsofarelements=0;
			}
			else
			{
				maxsofarvalue=ar[i];
				maxarray[i]=maxarray[i-1]+1;
				maxsofarelements++;
			}
		}
		int max=0;
		for(int i=0;i<ar.length;i++)
		{
			if(max<ar[i])
				max=ar[i];
		}
		return max;
	}
	
	public static void main(String []args)
	{
		int ar[]={4,3,5,2,1,3,2,3};
		System.out.println(maxSoFar(ar)); 
	}
}
