import java.text.DecimalFormat;
import java.util.Scanner;

public class ManyChef {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int emptyStringCount = 0;
			String s = sc.next();
			for (int j = 0; j < s.length(); j++) {
				if ('?' == s.charAt(j)) {
					emptyStringCount += 1;
				} else if ('C' == s.charAt(j)) {
					if (emptyStringCount > 0) {
						String temp = "";
						if (emptyStringCount > 0) {
							if (emptyStringCount / 4 >= 1) {
								int countA = emptyStringCount % 4;
								int countChef = emptyStringCount / 4;
								while (countA > 0) {
									temp = temp + 'A';
									countA--;
								}
								while (countChef > 0) {
									temp = temp + "CHEF";
									countChef--;
								}
							} else {
								int tc = emptyStringCount;
								while (tc > 0) {
									temp = temp + 'A';
									tc--;
								}
							}
							s = s.substring(0, j - emptyStringCount) + temp
									+ s.substring(j);
						}
					}
				} else if ('H' == s.charAt(j)) {
					if (emptyStringCount > 0) {
						String temp = "";
						if (emptyStringCount > 0) {
							if ((emptyStringCount > 1)) {
								int countA = (emptyStringCount - 1) % 4;
								int countChef = (emptyStringCount - 1) / 4;
								while (countA > 0) {
									temp = temp + 'A';
									countA--;
								}
								while (countChef > 0) {
									temp = temp + "CHEF";
									countChef--;
								}
								temp += "C";
							} else
								temp += 'A';
							s = s.substring(0, j - emptyStringCount) + temp
									+ s.substring(j);
						}
					}
				} else if ('E' == s.charAt(j)) {
					if (emptyStringCount > 0) {
						String temp = "";
						if (emptyStringCount > 0) {
							if (emptyStringCount > 2) {
								int countA = (emptyStringCount - 2) % 4;
								int countChef = (emptyStringCount - 2) / 4;
								while (countA > 0) {
									temp = temp + 'A';
									countA--;
								}
								while (countChef > 0) {
									temp = temp + "CHEF";
									countChef--;
								}
								temp += "CH";
							} else {
								int tc = emptyStringCount;
								while (tc > 0) {
									temp += 'A';
									tc--;
								}
							}
							s = s.substring(0, j - emptyStringCount) + temp
									+ s.substring(j);
						}
					}

				} else if ('F' == s.charAt(j)) {
					if (emptyStringCount > 0) {
						String temp = "";
						if (emptyStringCount > 0) {
							if (emptyStringCount > 3) {
								int countA = (emptyStringCount - 3) % 4;
								int countChef = (emptyStringCount - 3) / 4;
								while (countA > 0) {
									temp = temp + 'A';
									countA--;
								}
								while (countChef > 0) {
									temp = temp + "CHEF";
									countChef--;
								}
								temp += "CHE";
							} else {
								int tc = emptyStringCount;
								while (tc > 0) {
									temp += 'A';
									tc--;
								}
							}
						}
						s = s.substring(0, j - emptyStringCount) + temp
								+ s.substring(j);
					}
				} else {
					String temp = "";
					int tc = emptyStringCount;
					while (tc > 0) {
						temp = temp + 'A';
						tc--;
					}
					s = s.substring(0, j - emptyStringCount) + temp
							+ s.substring(j);
				}

			}
			System.out.println(s);
		}

	}
}
