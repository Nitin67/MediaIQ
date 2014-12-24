package com.topcoder;

import java.util.Scanner;

public class ElephantBear {
	
	
	public static void main(String []args)
	{
		int a[]=new int[6];
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<6;i++)
			a[i]=scanner.nextInt();
		
		int x=a[0];
		int xcount=1;
		for(int i=1;i<6;i++)
		{
			if(x==-1)
			{	x=a[i];
				xcount++;
					
			}		
			
			else if(x!=a[i])
				--xcount;
			else
				++xcount;
			
			if(xcount==0)
				x=-1;
		}
		if(xcount>=2)
		{
			int l=-1,m=-1;
			int ycount=0;
			for(int i=0;i<6;i++)
			{
				
				if(x-a[i]!=0)
					{ycount++;
					if(l==-1)
					l=a[i];
					else
						m=a[i];
					}
			}
			if(ycount==2)
				{
				if(l==m)
				System.out.println("Elep");
				else
					System.out.println("Bear");
				}
			if(ycount==0){
				System.out.println("Elep");
				}
			else if(ycount==1)
			{
				System.out.println("Bear");
			}
		}
		else
			System.out.println("Alien");
	}

}
