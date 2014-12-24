/**
 * Classic knapsack problem implementation
 * 
 * Given items n size/weight Si and Values Vi
 * 
 * Given knapsack of capacity C
 * 
 * Find the values which fills exactly in C with maximum value
 * 
 * 
 */
public class Knapsack {

	/**
	 * Driver function
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int c = 20;
		Item[] items = { new Item(0, 0), new Item(12, 2), new Item(4, 8),
				new Item(7, 6), new Item(1, 10), new Item(2, 34) };
		// Assuming array starts from index 1
		solveKnapsack(items, c);
	}

	/**
	 * Given n items and knapsack of capacity c
	 * 
	 * Recursive function:
	 * 
	 * M(i,j) = Max(M(i-1,j), M(i-1,j-Si) + Vi) // Means either the value will
	 * be from directly above cell (that means current item can not be added to
	 * the knapsack)
	 * 
	 * or it will be the index, where you subtract items with weight Si and add
	 * Vith value.
	 * 
	 * 
	 * Currently I am just storing the maximum value, but the data structure of
	 * Matrix can be modified to store Max value till this point as well as the
	 * previous index.
	 * 
	 * Only j needs to be stored, through which we can deduce the value
	 * 
	 * @param items
	 * @param c
	 */
	public static void solveKnapsack(Item[] items, int c) {
		if (c <= 0)
			throw new NullPointerException("knapsack illegal");
		int sol[][] = new int[items.length][c + 1];
		for (int i = 1; i < items.length; i++) {
			for (int j = 1; j < c + 1; j++) {
				if (j - items[i].weight < 0) {
					sol[i][j] = sol[i - 1][j];
				} else {
					sol[i][j] = Math.max(sol[i - 1][j], sol[i - 1][j
							- items[i].weight]
							+ items[i].value);
				}
			}
		}
		int max = 0;
		for (int i = 1; i < items.length; i++) {
			if (max < sol[i][c])
				max = sol[i][c];
		}

		System.out.println("max value is " + max);
	}
}

class Item {
	int weight;
	int value;

	public Item(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
}