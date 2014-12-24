package com.graph;

import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import com.walmart.demo.Graph;

public class PracticeBFS {
	
	public void bfs(Graph g,int src,int v)
	{
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++)
		{
		if(!visited[i])
		{
		Queue<Integer> queue=new ArrayBlockingQueue<Integer>(v);
		queue.add(i);
		visited[src]=true;
		while(!queue.isEmpty())
		{
			int node=queue.peek();
			System.out.print(node+"-->");
			queue.remove();
			Iterator<Integer> it=g.adj[node].iterator();
			while(it.hasNext())
			{
				int val=it.next();
				if(!visited[val])
				{
					visited[val]=true;
					queue.add(val);
				}
			}
			
		}
		}
		}
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
		PracticeBFS practiceBFS=new PracticeBFS();
		practiceBFS.bfs(graph, 0, v);
	}

}
