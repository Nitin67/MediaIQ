package com.graph;

import java.util.Scanner;

class graphNode{
	int src;
	int dest;
	int weight;
	
	public void addConnection(int src,int dest,int weight)
	{
		this.src=src;
		this.dest=dest;
		this.weight=weight;
	}
}
public class BellmanFord {

	
	public int [] bellmanFord(graphNode []graph,int e,int v,int src)
	{
		int dist[]=new int[v];
		dist[src]=0;
		for(int i=1;i<v;i++)
		{
			dist[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<v-1;i++)
		{
			for(int j=0;j<e;j++)
			{
				int weight=graph[j].weight;
				int sr=graph[j].src;
				int dest=graph[j].dest;
				if(dist[sr]!=Integer.MAX_VALUE && dist[dest]>dist[sr]+weight)
					dist[dest]=dist[sr]+weight;
			}
		}
		
		//check for next edge

		for(int i=0;i<e;i++)
		{
			int weight=graph[i].weight;
			int sr=graph[i].src;
			int dest=graph[i].dest;
			if(dist[sr]!=Integer.MAX_VALUE && dist[dest]>(dist[sr]+weight))
			{
				System.out.println("Negative Cycle exist");
				return null;
			}
		}
		return dist;
	}
	
	public static void main(String []args)
	{
		Scanner scanner = new Scanner(System.in);
		int v=scanner.nextInt();
		int e=scanner.nextInt();
		graphNode []graph=new graphNode[e];
		for(int i=0;i<e;i++)
		{
			int src=scanner.nextInt();
			int dest=scanner.nextInt();
			int weight=scanner.nextInt();
			graph[i]=new graphNode();
			graph[i].addConnection(src, dest, weight);
		}
		BellmanFord ford=new BellmanFord();
		int dist[]=ford.bellmanFord(graph, e, v,0);
		
	}
}
