package com.careercup;

public class FindExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 5 };
		char[] operatorArray = new char[] { '+', '-', '*', '/' };
		printExpression(array, operatorArray, null, 9);
	}

	private static boolean printExpression(int[] array, char[] operatorArray,
			String output, int n) {
		if ((array == null || array.length <= 0) && output != null) {
			int o = ExpressionEvaluator.evaluate(output);
			if (o == n) {
				System.out.println(output);
				return true;
			} else
				return false;

		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < operatorArray.length; j++) {
				int[] array1 = remove(array, i);
				StringBuffer sb = new StringBuffer();
				if (output != null) {
					sb.append(output);
					sb.append(operatorArray[j]);
					sb.append(array[i]);
				} else {
					sb.append(array[i]);
				}
				boolean flag = printExpression(array1, operatorArray,
						sb.toString(), n);
				if (flag)
					return flag;
			}
		}
		return false;
	}

	private static int[] remove(int[] array, int i) {
		int[] newArray = new int[array.length - 1];
		int k = 0;
		for (int j = 0; j < array.length; j++) {
			if (j != i) {
				newArray[k] = array[j];
				k++;
			}
		}
		return newArray;
	}

}
