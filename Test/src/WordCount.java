import java.util.Scanner;

public class WordCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer wordCount = 0;
		Integer emptyStringCount = 0;
		while (sc.hasNextLine()) {
			String lineStr = sc.nextLine();
			if (lineStr.isEmpty())
				emptyStringCount++;
			else {
				emptyStringCount = 0;
				wordCount = wordCount + wordCount(lineStr);
			}
			if (emptyStringCount == 2)
				break;

		}
		System.out.println(wordCount);
	}

	private static Integer wordCount(String lineStr) {
		Integer wordCount = 0;
		boolean wordFound = false;
		for (int i = 0; i < lineStr.length(); i++) {
			char c = lineStr.charAt(i);
			if (('a' <= c && c >= 'z') || ('A' <= c && c >= 'Z')) {
				wordFound = true;
			} else if (wordFound) {
				wordCount = wordCount + 1;
				wordFound = false;
			}
		}
		return wordFound ? wordCount + 1 : wordCount;
	}
}
