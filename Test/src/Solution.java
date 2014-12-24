import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String string1 = br.readLine();
			String[] size = string1.split(",");
			Integer n = Integer.valueOf(size[0]);
			Integer m = Integer.valueOf(size[1]);
			int i = 0;
			String[][] stringArray = new String[m][n];
			while (i < m) {
				String elements = br.readLine();
				String[] stringElementsArray = elements.split(",");
				stringArray[i] = stringElementsArray;
				i++;
			}
			printDiagonal(stringArray, m, n);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printDiagonal(String[][] stringArray, int m, int n) {
		if (stringArray != null) {
			int flag;
			StringBuffer sb = new StringBuffer();
			for (int i = 1; i <= m + n - 1; i++) {
				int startcol = Math.max(0, i - n);
				int count = Math.min(i, m - startcol);
				flag = i < n ? i : n;
				for (int j = 0; j < count; j++) {
					flag--;
					sb.append((stringArray[startcol + j][flag]));
					if (j != count - 1) {
						sb.append(",");
					}
				}
				if(i!=m+n-1)
					sb.append("\n");
			}
			System.out.println(sb.toString());
		}
	}
}
