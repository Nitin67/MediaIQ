import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPalindrome {

	static int getNextPalindrome(int a) {
		List<Integer> integers = new ArrayList<Integer>();
		while (a != 0) {
			integers.add(a % 10);
			a = a / 10;
		}
		Collections.reverse(integers);
		return a;
		
	}
	
	public static void main(String[] args) {

	}
}
