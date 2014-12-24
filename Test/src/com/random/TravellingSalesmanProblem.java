package com.random;

import java.util.Stack;

public class TravellingSalesmanProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] adjacency = new int[][] {
				{ 000, 374, 200, 223, 108, 178, 252, 285, 240, 356 },
				{ 374, 000, 255, 166, 433, 199, 135, 95, 136, 017 },
				{ 200, 255, 000, 128, 277, 128, 180, 160, 131, 247 },
				{ 223, 166, 128, 000, 430, 047, 052, 84, 040, 155 },
				{ 108, 433, 277, 430, 000, 453, 478, 344, 389, 423 },
				{ 178, 199, 128, 047, 453, 000, 91, 110, 064, 181 },
				{ 252, 135, 180, 052, 478, 91, 000, 114, 83, 117 },
				{ 285, 95, 160, 84, 344, 110, 114, 000, 047, 78 },
				{ 240, 136, 131, 040, 389, 064, 83, 047, 000, 118 },
				{ 356, 017, 247, 155, 423, 181, 117, 78, 118, 000 } };
		
		getShortestPath(adjacency);
	}

	private static void getShortestPath(int[][] adjacency) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] visited = new int[adjacency.length];
		int dst = 0;
		stack.push(dst);
		while(!stack.isEmpty()){
			int i=0;
			int element = stack.peek();
			int min = Integer.MAX_VALUE;
			boolean flag = false;
			while(i<adjacency[element].length){
				if(min>adjacency[element][i]&&visited[i]==0){
					min = adjacency[element][i];
					flag=true;
					dst=i;
				}
				i++;
			}
			if(flag){
				stack.push(dst);
				visited[dst]=1;
				System.out.print(dst+"\t");
			}else
				stack.pop();
			
		}
	}

}
