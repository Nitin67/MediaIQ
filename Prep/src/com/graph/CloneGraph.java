package com.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;

import com.walmart.demo.Graph;


public class CloneGraph {
	

	
	public Graph cloneGraph(Graph g,int src,int v)
	{
		Graph graph=new Graph(v);
		Map<Integer,Vector<Integer>> map=new HashMap<Integer, Vector<Integer>>();
		map.put(src, new Vector<Integer>());
		Queue<Integer> queue=new ArrayBlockingQueue<Integer>(v);
		queue.add(src);
		while(!queue.isEmpty())
		{
			int node=queue.peek();
			Iterator<Integer> it=g.adj[node].iterator();
			queue.remove();
			while(it.hasNext())
			{
				int val=it.next();
				if(!map.containsKey(val))
				{
					queue.add(val);
				}
			if(map.containsKey(node))
			{
				map.get(node).add(val);
			}
			else
			{
				map.put(node, new Vector<Integer>());
				map.get(node).add(val);	
			}
			
			}
		}
		Iterator mapIt=map.entrySet().iterator();
		
		while(mapIt.hasNext())
		{
			Map.Entry pairs=(Map.Entry) mapIt.next();
			Iterator<Integer> vectIt= ((Vector<Integer>)pairs.getValue()).iterator();
			while(vectIt.hasNext())
			{
				graph.adj[(Integer) pairs.getKey()].add(vectIt.next());
			}
			
		}
		
		return graph;
	}
	public static void main(String []args)
	{
		Scanner scanner=new Scanner(System.in);
		int v=scanner.nextInt();
		int e=scanner.nextInt();
		Graph graph=new Graph(v,e);
		for(int i=0;i<e;i++){
			int src=scanner.nextInt();
			int dest=scanner.nextInt();
			graph.addConnection(src, dest);
		
		}
		CloneGraph cloneGraph=new CloneGraph();
		Graph g=cloneGraph.cloneGraph(graph, 0, v);
		
	}

}
