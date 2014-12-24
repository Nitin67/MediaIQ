package com.walmart.demo;

import java.util.Arrays;

public class HamiltonianCycle {

	public boolean isSafe(int v, int graph[][], int path[], int pos) {
		if (graph[path[pos - 1]][v] == 0)
			return false;

		for (int i = 0; i < pos; i++) {
			if (path[i] == v)
				return false;
		}

		return true;

	}

	public boolean hamCycleUtil(int graph[][], int path[], int pos) {
		if (pos == path.length) {
			if (graph[path[pos - 1]][path[0]] == 1) {
				return true;
			} else
				return false;

		}

		for (int v = 1; v < path.length; v++) {

			if (isSafe(v, graph, path, pos)) {
				path[pos] = v;

				if (hamCycleUtil(graph, path, pos + 1) == true) {
					return true;
				}
				path[pos] = -1;

			}

		}

		return false;

	}

	public void hamCycle(int graph[][]) {
		int size = graph[0].length;
		int path[] = new int[size];
		Arrays.fill(path, -1);
		path[0] = 0;
		if (hamCycleUtil(graph, path, 1) == true) {
			for (int i = 0; i < path.length; i++)
				System.out.println(path[i] + "-->");
			return;
		}
		System.out.println("NO hamiltonian cycle possible");

	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 },
				{ 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, };
		HamiltonianCycle hamiltonianCycle = new HamiltonianCycle();
		hamiltonianCycle.hamCycle(graph);

	}

}
