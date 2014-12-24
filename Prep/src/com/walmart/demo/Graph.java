package com.walmart.demo;

import java.util.Vector;

import com.test.prob1;

public class Graph {

	public final int V;
	public int E;
	public Vector<Integer>[] adj;

	public Graph(int V) {
		if (V < 0) {
			throw new IllegalArgumentException(
					"Number of vertices must be nonnegative");
		}
		this.V = V;
		this.E = 0;
		adj =  new Vector[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Vector<Integer>();
		}
	}
	public Graph(int V,int E)
	{
		if(V<0)
		{
			throw new IllegalArgumentException("Number of vertices must be nonneagtive");
		}
		if(E<0)
		{
			throw new IllegalArgumentException("Number of Edges should be nonnegative");
		}
		this.E=E;
		this.V=V;
		this.adj=new Vector[V];
		for (int i=0;i<V;i++) {
			this.adj[i]=new Vector<Integer>();
		}
		
	}
	public void addConnection(int src,int dest)
	{
		this.adj[src].add(dest);
	}
	public void removeConnection(int src,int dest)
	{
		this.adj[src].remove(dest);
	}

}
