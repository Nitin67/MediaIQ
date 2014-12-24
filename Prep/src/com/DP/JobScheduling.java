package com.DP;

import java.util.Arrays;

class Job implements Comparable<Job>
{
	public int cost;
	public int startTime;
	public int endTime;
	
	public Job(int cost,int startTime,int endTime)
	{
		this.cost=cost;
		this.startTime=startTime;
		this.endTime=endTime;
	}
	@Override
	public int compareTo(Job o) {
		int returnValue=0;
		if(this.endTime<o.endTime)
			returnValue=-1;
		else if(this.startTime<o.startTime)
			returnValue=-1;
		else
			returnValue=1;
		
		return returnValue;
	}
	
}
public class JobScheduling {

	public static int jobScheduling(Job []jobs)
	{
		Arrays.sort(jobs);
		int dp[]=new int[jobs.length];
		for(int i=0;i<dp.length;i++)
		{
			if(i>0)
			{
				if(maxJobCostSoFar(i, dp, jobs)>=0)
			dp[i]=Math.max(dp[i-1], dp[maxJobCostSoFar(i, dp, jobs)]+jobs[i].cost);
				else
					dp[i]=Math.max(dp[i-1], jobs[i].cost);
			}else
				dp[i]=jobs[i].cost;
		}
		return dp[dp.length-1];
		
	}
	public static int maxJobCostSoFar(int k,int dp[],Job []jobs)
	{
		int max=Integer.MIN_VALUE;
		int l=-1;
		for(int i=0;i<k;i++)
		{
			if(jobs[i].endTime<=jobs[k].startTime)
			{
				if(dp[i]>max)
				{
					max=dp[i];
					l=i;
				}
			}
		}
		
		return l;
	}
	public static void main(String []args)
	{
		Job job1 = new Job(5, 0, 4);
		Job job2 = new Job(2, 3, 5);
		Job job3 = new Job(6, 0, 3);
		Job job4 = new Job(5, 6, 8);
		Job job5 = new Job(4, 5, 7);
		Job job6 = new Job(8, 9, 11);
		Job[] jobArray = new Job[] { job1, job2, job3, job4, job5, job6 };
		int maxCost = jobScheduling(jobArray);
		System.out.println(maxCost);
		
	}
}
