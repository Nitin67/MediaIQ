package com.careercup;

import java.util.List;

public class GNode {
	private List<GNode> adjacentNode;
	private int val;
	private int inDegree;

	public List<GNode> getAdjacentNode() {
		return adjacentNode;
	}

	public void setAdjacentNode(GNode adjacentNode) {
		this.adjacentNode.add(adjacentNode);
		adjacentNode.setInDegree(adjacentNode.getInDegree()+1);
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int getInDegree() {
		return inDegree;
	}

	public void setInDegree(int inDegree) {
		this.inDegree = inDegree;
	}

}
