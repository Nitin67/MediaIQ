package com.maloo;

import java.util.Arrays;
import java.util.Scanner;

class Event implements Comparable<Event>
{
	int start;
	int end;
	int cost;

	@Override
	public int compareTo(Event o) {
		if(this.end<o.end)
			return -1;
		else if(this.start<o.start)
			return -1;
		else if(this.end==o.end && this.start==o.start)
			return -1;
		return 1;
	}
	
}




public class Eventscheduling {

	
	public int scheduleEvent(Event []events)
	{
		int maxEvent[]=new int[events.length];
		for(int i=0;i<events.length;i++)
			maxEvent[i]=events[i].cost;
		for(int i=1;i<events.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(events[i].start>=events[j].end)
				{
					if(maxEvent[i]<maxEvent[j]+events[i].cost)
						maxEvent[i]=maxEvent[j]+events[i].cost;
				}
			}
		}
		return maxEvent[events.length-1];
	}
	
	public static void main(String []args)
	{
		
		Scanner scanner=new Scanner(System.in);
		int k=scanner.nextInt();
		Event []events=new Event[k];
		for(int i=0;i<k;i++)
		{
			events[i]=new Event();
		}
		for(int i=0;i<k;i++)
		{
			int n=scanner.nextInt();
			events[i].start=n;
			n=scanner.nextInt();
			events[i].end=n;
			n=scanner.nextInt();
			events[i].cost=n;
		}
		Arrays.sort(events);
		Eventscheduling eventscheduling=new Eventscheduling();
		System.out.println(eventscheduling.scheduleEvent(events));
	}

}
