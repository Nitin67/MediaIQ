package com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Vertex implements Comparable<Vertex>
{
	public final String name;
	public Edge[] adjacencies;
	public double minDistance=Double.POSITIVE_INFINITY;
	public Vertex previous;
	
	public Vertex(String name)
	{
		this.name=name;
	}
	@Override
	public int compareTo(Vertex o) {
		return Double.compare(minDistance, o.minDistance);
	}
	
}
class Edge{
	public final Vertex target;
	public final double weight;
	Edge(Vertex argTarget,double argWeight)
	{
		target=argTarget;
		weight=argWeight;
	}
}
public class DijkstraAlgolist {

	
	public static void main(String []args)
	{
		Vertex v0=new Vertex("Delhi");
		Vertex v1=new Vertex("Bangalore");
		Vertex v2=new Vertex("Allahabad");
		Vertex v3=new Vertex("Hyderabad");
		Vertex v4=new Vertex("Goa");
		v0.adjacencies=new Edge[]{
				new Edge(v1, 5),
				new Edge(v2, 10),
				new Edge(v3, 8)
		};
		v1.adjacencies=new Edge[]{new Edge(v0, 5), new Edge(v2, 3),
                new Edge(v4, 7)};
		v2.adjacencies = new Edge[]{ new Edge(v0, 10),
                new Edge(v1, 3) };
		v3.adjacencies = new Edge[]{ new Edge(v0, 8),
                  new Edge(v4, 2) };
		v4.adjacencies = new Edge[]{ new Edge(v1, 7),
                new Edge(v3, 2) };
		Vertex[] vertices = { v0, v1, v2, v3, v4 };
		computePaths(v0);
		for(Vertex v: vertices)
		{
			System.out.println("Distance to" + v +":"+v.minDistance);
			List<Vertex> path=shortestPath(v);	
		}
	}

	private static List<Vertex> shortestPath(Vertex target) {
		List<Vertex> path=new ArrayList<Vertex>();
		for(Vertex v=target;v!=null;v=v.previous)
		{
			path.add(v);
		}
		Collections.reverse(path);
		return path;
	}

	private static void computePaths(Vertex src) {
		src.minDistance=0;
		PriorityQueue<Vertex> priorityQueue=new PriorityQueue<Vertex>();
		priorityQueue.add(src);
		while(!priorityQueue.isEmpty())
		{
			Vertex u=priorityQueue.poll();
			for(Edge e: u.adjacencies)
			{
				Vertex v=e.target;
				Double wght=e.weight;
				double distanceThroughU=u.minDistance+wght;
				if(distanceThroughU<v.minDistance)
				{
					priorityQueue.remove(v);
					v.minDistance=distanceThroughU;
					v.previous=u;
					priorityQueue.add(v);
				}
			}
		}
		
	}
}
