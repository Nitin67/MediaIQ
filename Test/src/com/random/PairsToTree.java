package com.random;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Node {
	public String value;
	public Node left;
	public Node right;

	public Node(String rootValue) {
		value = rootValue;
	}
}

public class PairsToTree {
	public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		if (!(str == null || "".equals(str))) {
			Map<String, String> childToParent = convertFromStringToMap(str);
			Set<String> children = childToParent.keySet();
			Collection<String> parents = childToParent.values();
			Set<String> root = new HashSet<String>();
			for (String parent : parents) {
				root.add(parent);
			}
			root.removeAll(children);
			if (root.size() != 1) {
				out.write("E4");
				return;
			}
			String rootValue = root.iterator().next();
			Node rootNode = new Node(rootValue);
			Map<String, Node> treeMap = new HashMap<String, Node>();
			treeMap.put(rootValue, rootNode);
			for (String child : children) {
				Node childNode = new Node(child);
				String parent = childToParent.get(child);
				if (treeMap.containsKey(parent)) {
					Node parentNode = treeMap.get(parent);
					if (parentNode.left == null) {
						parentNode.left = childNode;
					} else if (parentNode.right == null) {
						Node temp = parentNode.left;
						if (!temp.value.equals(childNode.value))
							parentNode.right = childNode;
					} else {
						Node tempLeft = parentNode.left;
						Node tempRight = parentNode.right;
						if (!tempLeft.value.equals(childNode.value)&&!tempRight.value.equals(childNode.value)) {
							out.write("E1");
							return;
						}
					}
					treeMap.put(parent, parentNode);
					treeMap.put(child, childNode);
				} else {
					Node parentNode = new Node(parent);
					parentNode.left = childNode;
					if (childToParent.containsKey(parent)) {
						Node parentsParentNode = treeMap.get(childToParent
								.get(parent));
						if (parentsParentNode != null) {
							if (parentsParentNode.left == null) {
								parentsParentNode.left = parentNode;
							} else if (parentsParentNode.right == null) {
								Node temp = parentsParentNode.left;
								if (!temp.value.equals(parentNode.value))
									parentsParentNode.right = parentNode;
							} else {
								Node tempLeft = parentsParentNode.left;
								Node tempRight = parentsParentNode.right;
								if (!tempLeft.value.equals(parentNode.value)&&!tempRight.value.equals(parentNode.value)) {
									System.out.println("E1");
									return;
								}
							}
						}
					}
					treeMap.put(parent, parentNode);
					treeMap.put(child, childNode);
				}
			}
			List<String> visited = new ArrayList<String>();
			String output = convertTreeToString(rootNode,visited);
			Iterator<String> itr = visited.iterator();
			Set<String> strSet = new HashSet<String>();
			while(itr.hasNext()){
				if(!strSet.add(itr.next())){
					out.write("E3");
					return;
				}
			}
			out.write("(" + output + ")");
		}

	}

	public static String convertTreeToString(Node rootNode,List<String> visited) {
		if (rootNode == null) {
			return "";
		} else {
			visited.add(rootNode.value);
			StringBuffer sb = new StringBuffer();
			String leftString = convertTreeToString(rootNode.left,visited);
			String rightString = convertTreeToString(rootNode.right,visited);
			sb.append(rootNode.value);
			if (!"".equals(leftString))
				sb.append("(").append(leftString).append(")");
			if (!"".equals(rightString))
				sb.append("(").append(rightString).append(")");
			return sb.toString();
		}
	}

	private static Map<String, String> convertFromStringToMap(String str) {
		Map<String, String> map = new HashMap<String, String>();
		String[] strArray = str.split(" ");
		for (String strTuple : strArray) {
			String parent = strTuple.substring(1, 2);
			String child = strTuple.substring(3, 4);
			map.put(child, parent);
		}
		return map;
	}

}
