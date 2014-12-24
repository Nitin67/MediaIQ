package com.careercup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class GraphNode {
	public int val;
	public List<GraphNode> adjacentNodes = new ArrayList<GraphNode>();
}

public class FindingPathInGraph {
	// (1,2)(1,3)(2,4)(3,5)(4,5)(5,6)
	/**
	 * @param args
	 */
	private static Set<String> path = new HashSet<String>();

	public static void main(String[] args) {
		GraphNode _6 = new GraphNode();
		_6.val = 6;
		GraphNode _5 = new GraphNode();
		_5.val = 5;
		_5.adjacentNodes.add(_6);
		GraphNode _4 = new GraphNode();
		_4.val = 4;
		_4.adjacentNodes.add(_5);
		GraphNode _3 = new GraphNode();
		_3.val = 3;
		_3.adjacentNodes.add(_5);
		GraphNode _2 = new GraphNode();
		_2.val = 2;
		_2.adjacentNodes.add(_4);
		GraphNode _1 = new GraphNode();
		_1.val = 1;
		_1.adjacentNodes.add(_2);
		_1.adjacentNodes.add(_3);
		findPath(_1, "", 6,false,3);
		Iterator<String> itr = path.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

	public static void findPath(GraphNode source, String str, int dest,boolean intermediateFound,int intermediate) {
		if (source != null) {
			if (source.val == dest) {
				if(intermediateFound)
					path.add(str + source.val);
				return;
			} else {
				List<GraphNode> adjacent = source.adjacentNodes;
				Iterator<GraphNode> itr = adjacent.iterator();
				while (itr.hasNext()) {
					if(source.val==intermediate)
						intermediateFound = true;
					findPath(itr.next(), str + source.val, dest,intermediateFound,intermediate);
				}
			}
		} else {
			return;
		}
	}
}
