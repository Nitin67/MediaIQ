package com.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;



class graph{
	
	Map<Character, List<Character>> adj;
	graph()
	{
		adj =new HashMap<Character, List<Character>>();
	}
	public void addEdge(char v,char w)
	{
		if(this.adj.containsKey(v))
		{
			List<Character> list=adj.get(v);
			list.add(w);
			this.adj.put(v, list);
		}
		else
		{
			List<Character> list=new ArrayList<Character>();
			list.add(w);
			this.adj.put(v, list);
		}
		if(!this.adj.containsKey(w))
		{
			List<Character> list = new ArrayList<Character>();
			this.adj.put(w, list);
		}
	}
	
}


public class TopologicalSorting {

	public static void topologicalSort(graph g)
	{
		Stack<Character> stack=new Stack<Character>();
		Map<Character, Boolean> visited=new HashMap<Character, Boolean>();

		Iterator it= g.adj.keySet().iterator();
		while(it.hasNext())
		{
		 char c=(char) it.next();
		 visited.put(c, false);
		}
		Iterator iterator=visited.entrySet().iterator();
		while(iterator.hasNext())
		{
			Map.Entry pair= (Entry) iterator.next();
			if(!(boolean) pair.getValue())
			{
				topologicalSortUtil(g,visited,stack,(char)pair.getKey());
			}
		}
		for (Iterator iterator2 = stack.iterator(); iterator2.hasNext();) {
			Character character = (Character) iterator2.next();
			System.out.println(character);
		}

	}
	
	private static void topologicalSortUtil(graph g, Map<Character, Boolean> visited, Stack<Character> stack, char key) {
		// TODO Auto-generated method stub
		visited.put(key, true);
		
		List<Character> list=g.adj.get(key);
		for(int i=0;i<list.size();i++)
		{
			if(!visited.get(list.get(i)))
			{
				topologicalSortUtil(g, visited, stack, list.get(i));
			}
		}
		stack.push(key);
		
	}

	public static void main(String []args)
	{
		
		graph g=new graph();
		g.addEdge('f', 'c');
		g.addEdge('f', 'a');
		g.addEdge('e', 'a');
		g.addEdge('e', 'b');
		g.addEdge('c', 'd');
		g.addEdge('d', 'b');
		topologicalSort(g);
	}
}
