 package com.graph;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import com.walmart.demo.Graph;




public class DFS {

	private static boolean []visited;
	public static void dfs(Graph g,int v)
	{
		visited = new boolean[v];
		for(int i=0;i<v;i++)
			visited[i]=false;
		dfsUtil(g,0);
	}
	
	private static void dfsUtil(Graph g,int u) {
		visited[u]=true;
		System.out.println(u + "-->");
		
		Iterator<Integer> ioe= g.adj[u].iterator();
		while(ioe.hasNext())
		{
			int val=ioe.next().intValue();
			if(!visited[val])
			{
					dfsUtil(g,val);
			}
		}
		
	}

	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter num of nodes");
		int s = in.nextInt();
		Graph graph= new Graph(s);	
		graph.adj[0].add(1);
		graph.adj[0].add(2);
		graph.adj[1].add(0);
		graph.adj[1].add(3);
		graph.adj[2].add(0);
		graph.adj[2].add(3);
		graph.adj[3].add(1);
		graph.adj[3].add(2);
		dfs(graph,s);
	}
}

