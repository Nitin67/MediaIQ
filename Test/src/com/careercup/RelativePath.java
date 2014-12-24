package com.careercup;

import java.util.Stack;

public class RelativePath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String currentPath = "/usr/bin/tel";
		String relativePath = "../../../etc/the/../abc";
		printAbsolutePath(currentPath, relativePath);
	}

	private static void printAbsolutePath(String currentPath,
			String relativePath) {
		String[] currentPathArray = currentPath.substring(1,
				currentPath.length()).split("/");
		Stack<String> pathStack = new Stack<String>();
		for (String str : currentPathArray) {
			pathStack.push(str);
		}
		String[] relativePathArray = relativePath.split("/");
		for (String str : relativePathArray) {
			if ("..".equals(str)) {
				if (pathStack.isEmpty()) {
					System.out.println("Invalid Relative Path");
					return;
				}
				pathStack.pop();
			} else
				pathStack.push(str);
		}
		String path = "";
		while (!pathStack.isEmpty()) {
			String pathElement = pathStack.pop();
			path = "/" + pathElement + path;
		}
		System.out.println(path);
	}
}
