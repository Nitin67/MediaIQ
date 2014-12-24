public class Test {

	static Integer i = 1;

	/**
	 * @param args
	 */
	static{
		if(true)
			throw new RuntimeException();
	}
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		int i = 2;
		System.out.println(i);
		test2(i);
	}

	private static void test2(int i) {
		System.out.println(i);

	}
}
