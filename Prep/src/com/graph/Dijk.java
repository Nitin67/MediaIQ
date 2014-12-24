package com.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
	
	ConnectEdge []adjacencies;
	public final String name;
	Node previous;
	public double minDistance=Double.POSITIVE_INFINITY;
	public Node(String name) {
		this.name=name;
	}
	@Override
	public int compareTo(Node o) {
		return Double.compare(this.minDistance, o.minDistance);
	}
}

class ConnectEdge{
	public final double edgeWeight;
	public final Node target;
	public ConnectEdge(double weight,Node target) {
		this.edgeWeight=weight;
		this.target=target;
	}
}



public class Dijk {

	
	public static void main(String []args)
	{
		Node node1 =new Node("Delhi");
		Node node2=new Node("Bangalore");
		Node node3=new Node("Mumbai");
		Node node4=new Node("Allahabad");
		Node node5=new Node("Goa");
		node1.adjacencies=new ConnectEdge[]{
				new ConnectEdge(4, node2)
				,new ConnectEdge(8, node3)
				,new ConnectEdge(10, node5)
		};
		node2.adjacencies=new ConnectEdge[]{new ConnectEdge(6, node1),new ConnectEdge(9, node4)};
		node3.adjacencies=new ConnectEdge[]{new ConnectEdge(9, node2),new ConnectEdge(1, node4)};
		node4.adjacencies=new ConnectEdge[]{new ConnectEdge(10, node5),new ConnectEdge(2, node1)};
		node5.adjacencies=new ConnectEdge[]{new ConnectEdge(12, node4),new ConnectEdge(3, node3)};
		Node nodes[]={node1,node2,node3,node4,node5};
		computePath(node1);
		for(Node n:nodes)
		{
			System.out.println("Min Distance to " + n.name +"is : " + n.minDistance);
			shortestPath(n);
			
		}
		
	}
	private static void shortestPath(Node node) {
		List<String> path=new ArrayList<String>();
		for(Node n=node;n!=null;n=n.previous)
		{
			path.add(n.name);
		}
		Collections.reverse(path);
		for(String str: path)
		{
			System.out.print(str+"-->");
		}
		System.out.println();
	}
	public static void computePath(Node src)
	{
		src.minDistance=0;
		PriorityQueue<Node> priorityQueue=new PriorityQueue<Node>();
		priorityQueue.add(src);
		
		while(!priorityQueue.isEmpty())
		{
			Node node=priorityQueue.poll();
			for(ConnectEdge e:node.adjacencies)
			{
				Node n=e.target;
				double weight=e.edgeWeight;
				double totalWeight=node.minDistance+weight;
				if(totalWeight<n.minDistance)	
				{
					priorityQueue.remove(n);
					n.minDistance=totalWeight;
					n.previous=node;
					priorityQueue.add(n);
					
				}
			}
		}
		
		
	}
}


