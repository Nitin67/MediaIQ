public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 1, 24, 12, -12, 23, 1, 57, 234 };
		quickSort(array, 0, array.length-1);
		for (int a : array)
			System.out.println(a);

	}

	private static void quickSort(int[] array, int start, int end) {
		if (start > end) {
			return;
		} else {
			int pivot = partition(array, start, end);
			quickSort(array, start, pivot - 1);
			quickSort(array, pivot + 1, end);
		}
		return;
	}

	private static int partition(int[] array, int start, int end) {
		if (start > end)
			return end;
		int pivot = start;
		int pivotValue = array[pivot];
		start++;
		while (start <= end) {
			while (pivotValue > array[start] && start <= end)
				start++;
			while (pivotValue <= array[end] && start <= end)
				end--;
			if (start > end)
				swap(array, pivot, end);
			else
				swap(array, start, end);
		}
		return end;
	}

	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

}
