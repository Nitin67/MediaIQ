package com.graph;

import java.util.Scanner;


public class Dijkstra {

	public int[] dijkstra(int graph[][],int src,int v)
	{
		String str="abcd";
		str.getBytes();
		int dist[]=new int[v];
		boolean sptSet[]=new boolean[v];
		dist[src]=0;
		for(int i=1;i<v;i++)
		{
			sptSet[i]=false;
			dist[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<v;i++)
		{
			int u=minDist(dist,sptSet);
			sptSet[u]=true;
			for(int j=0;j<v;j++)
			{
				if(graph[u][j]!=0 && dist[u]!=Integer.MAX_VALUE && !sptSet[j] && graph[u][j]+dist[u]<dist[j])
				{
					dist[j]=dist[u]+graph[u][j];
				}
			}
		}
		return dist;
	}
	
	private int minDist(int[] dist, boolean[] sptSet) {
		int min=Integer.MAX_VALUE,minIndex=-1;
		for(int i=0;i<dist.length;i++)
		{
			if(sptSet[i]==false && dist[i]<min)
			{
				min=dist[i];
				minIndex=i;
			}
		}
		return minIndex;
	}

	public static void main(String []args)
	{
		Scanner  scanner=new Scanner(System.in);
		int v=scanner.nextInt();
		int e=scanner.nextInt();
		int graph[][]=new int[v][v];
		for(int i=0;i<e;i++)
		{
			int src=scanner.nextInt();
			int dest=scanner.nextInt();
			int weight=scanner.nextInt();
			graph[src][dest]=weight;
		}
		Dijkstra dij=new Dijkstra();
		int dist[]=dij.dijkstra(graph, 0, v);
	}
}
