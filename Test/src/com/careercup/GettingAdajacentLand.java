package com.careercup;

public class GettingAdajacentLand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] grid = { { 'l', 'w', 'w', 'w' }, 
						  { 'l', 'l', 'l', 'w' },
						  { 'l', 'w', 'l', 'w' }, 
						  { 'l', 'w', 'l', 'w' } };

		int t = findContagious(grid, 'l');
		System.out.println(t);
	}

	private static int findContagious(char[][] grid, char c) {
		int length = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == c) {
					int temp = findContagious(grid, c, i, j);
					length = length > temp ? length : temp;
				}
			}
		}
		return length;
	}

	private static int findContagious(char[][] grid, char c, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
				|| grid[i][j] != c) {
			return 0;
		} else {
			grid[i][j] = 'a';
			return 1 + findContagious(grid, c, i + 1, j)
					+ findContagious(grid, c, i - 1, j)
					+ findContagious(grid, c, i, j + 1)
					+ findContagious(grid, c, i, j - 1);
		}
	}

}
