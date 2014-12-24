package com.graph;

import java.util.Iterator;
import java.util.Scanner;

import com.walmart.demo.Graph;

public class PracticeDFS {

	public void dfsUtil(Graph g,int src,boolean []visited)
	{
		visited[src]=true;
		System.out.print(src+"-->");
		Iterator<Integer> it = g.adj[src].iterator();
		while(it.hasNext())
		{
			int val=it.next();
			if(!visited[val])
			{
				dfsUtil(g, val, visited);
			}
		}
		
	}
	public void dfs(Graph g,int src,int V)
	{
		boolean []visited=new boolean[V];
	
		for(int i=0;i<V;i++)
			if(!visited[i])
		dfsUtil(g, i, visited);
	}
	
	public static void main(String []args)
	{
		Scanner scanner=new Scanner(System.in);
		int v=scanner.nextInt();
		int e=scanner.nextInt();
		Graph graph=new Graph(v,e);
		for(int i=0;i<e;i++)
		{
			int src=scanner.nextInt();
			int dest=scanner.nextInt();
			graph.addConnection(src, dest);
		}
		PracticeDFS practiceDFS=new PracticeDFS();
		practiceDFS.dfs(graph,0,v);		
	}
}
