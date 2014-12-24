package com.graph;


import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import com.walmart.demo.Graph;

public class BFS {
	
	static boolean visited[];
	public static void main(String []args)
	{
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter No. of Vertices");
		int s=scanner.nextInt();
		Graph graph= new Graph(s);
		graph.adj[0].add(1);
		graph.adj[0].add(2);
		graph.adj[1].add(0);
		graph.adj[1].add(3);
		graph.adj[2].add(0);
		graph.adj[2].add(3);
		graph.adj[3].add(1);
		graph.adj[3].add(2);
		bfs(graph,s);
		
		
	}

	private static void bfs(Graph graph, int v) {
		// TODO Auto-generated method stub
		visited=new boolean[v];
		for(int i=0;i<v;i++)
		{
			visited[i]=false;
		}
		bfsUtil(graph,0,v);
	}
	

	private static void bfsUtil(Graph graph, int i,int v) {
		Queue<Integer> q= new ArrayBlockingQueue<Integer>(v);
		q.add(i);
		visited[i]=true;
		while(!q.isEmpty())
		{
			int e=q.peek();
			
			q.remove();
			System.out.print(e+"-->");
			Iterator<Integer> ioe= graph.adj[e].iterator();
			while(ioe.hasNext())
			{ 
				int val=ioe.next().intValue();
				if(!visited[val])
				{
					q.add(val);	
					visited[val]=true;
				}
			}
			
		}
	}

}
