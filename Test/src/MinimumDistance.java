import java.text.DecimalFormat;
import java.util.Scanner;

public class MinimumDistance {
	private static DecimalFormat df = new DecimalFormat("#.000000");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int[] a = new int[3];
			int sum = 0;
			for (int j = 0; j < 3; j++) {
				a[j] = sc.nextInt();
				if (j < 2)
					sum += a[j];
				else {
					if (a[j] <= sum)
						System.out.println(0.0);
					else if (sum > a[0] && sum > a[1])
						System.out.println(df.format(new Double(a[j] - sum)));
					else {
						System.out.println(df.format(new Double(Math.max(a[1], a[0])-Math.min(a[1], a[0]))));
					}
				}

			}

		}

	}

}
