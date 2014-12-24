package com.interview;
public class MergeTwoArrays {
	
	public static int []merge(int a[],int b[])
	{
		if(a.length==0 && b.length==0)
			return null;
		else if(a.length==0)
			return b;
		else if(b.length==0)
			return a;
			
		int c[]=new int[a.length+b.length];
		int k=0,i,j;
		for(i=0,j=0;i<a.length && j<b.length ;)
		{
			if(a[i]<b[j])
			{
				c[k++]=a[i++];
			}
			else
				c[k++]=b[j++];
		}
		if(i==a.length)
		{
			for(;j<b.length;j++)
			{
				c[k++]=b[j];
			}
		}
		else
		{
			for(;i<a.length;i++)
			{
				c[k++]=a[i];
			}
		}
		return c;
		
	}
	public static void main(String []args)
	{
		int a[]={1,4,7,9,10};
		int b[]={3,5,8,11};
		int c[]=merge(a,b);
		for(int i=0;i<c.length;i++)
		{
			System.out.println(c[i]);
		}
		
	}

}
