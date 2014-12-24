package com.careercup;

class GraphNode1 {
	int data;
	GraphNode1 left;
	GraphNode1 right;
}

public class CloneGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GraphNode1 root = null;
		GraphNode1 gnode = cloneGraphNode(root);
	}

	private static GraphNode1 cloneGraphNode(GraphNode1 root) {
		if (root == null)
			return null;
		GraphNode1 gnode = new GraphNode1();
		gnode.data = root.data;
		gnode.left = cloneGraphNode(root.left);
		gnode.right = cloneGraphNode(root.right);
		return gnode;
	}

}
