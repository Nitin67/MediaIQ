package com.DP;

import java.util.Arrays;

class Event implements Comparable<Event>{

	public int cost;
	public int startTime;
	public int endTime;
	
	public Event(int cost,int startTime,int endTime)
	{
		this.cost=cost;
		this.startTime=startTime;
		this.endTime=endTime;
	}
	@Override
	public int compareTo(Event arg0) {
		int returnValue=0;
		if (this.endTime<arg0.endTime)
			returnValue= -1;
		else if(this.startTime<arg0.startTime)
			returnValue= -1;
		else 
			returnValue=1;
		return returnValue;
	}
	
}
public class KthSmallestElementIn2DSortedArray {

	public static int kthSmallestElementIn2DSortedArray(Event []events)
	{
		Arrays.sort(events);
//		for(int i=0;i<events.length;i++)
//			System.out.println(events[i].endTime);
		int []dp=new int[events.length];
		for(int i=0;i<dp.length;i++)
		{
			if(i>0)
			{
				if(findMaximumCostSoFar(i,dp,events)>=0)
			dp[i]=Math.max(dp[i-1], dp[findMaximumCostSoFar(i,dp,events)]+events[i].cost);
				else
					dp[i]=Math.max(dp[i-1], events[i].cost);
			}
			else {
				dp[i]=events[i].cost;
			}
		}
		return dp[dp.length-1];
	}
	public static int findMaximumCostSoFar(int i,int []dp,Event []events)
	{
		int max=Integer.MIN_VALUE;
		int k=-1;
		int j;
		for(j=0;j<i;j++)
		{
			if(events[j].endTime<=events[i].startTime)
			{
				if(dp[j]>max)
				{
					max=dp[j];
					k=j;
				}
			}
		}
		return k;
	}
	
	public static void main(String []args)
	{
//		Event event1=new Event(4, 0, 3);
//		Event event2=new Event(5, 1, 5);
//		Event event3=new Event(6, 2, 4);
//		Event event4=new Event(4, 0, 2);
//		Event event5=new Event(3, 3, 7);
//		Event event6=new Event(7, 2, 6);
		Event event1 = new Event(5, 0, 4);
		Event event2 = new Event(2, 3, 5);
		Event event3 = new Event(6, 0, 3);
		Event event4 = new Event(5, 6, 8);
		Event event5 = new Event(4, 5, 7);
		Event event6 = new Event(8, 9, 11);
		Event []events={event1,event2,event3,event4,event5,event6};
		System.out.println(kthSmallestElementIn2DSortedArray(events));
	}
}
