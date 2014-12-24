import java.util.Stack;

public class TSP {

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
		tsp(adjacency);
	}

	private static void tsp(int[][] adjacency) {
		int[] visited = new int[adjacency.length];
		Stack<Integer> stack = new Stack<Integer>();
		int dst = 0;
		stack.push(dst);
		for (int i = 0; i < adjacency.length; i++) {
			int min = Integer.MAX_VALUE;
			int element = stack.peek();
			for (int j = 0; j < adjacency[element].length; j++) {
				if (min > adjacency[element][j] && visited[j] == 0) {
					dst = j;
					min = adjacency[element][j];
				}
			}
			if (min < Integer.MAX_VALUE) {
				stack.push(dst);
				visited[dst] = 1;
				System.out.print(dst + "\t");
			} else
				stack.pop();
		}
	}

}
