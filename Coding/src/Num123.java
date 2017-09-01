public class Num123 {
	public static void main(String[] args) {
		NumPrint x = new NumPrint();
        new Thread(x,"Even").start();
        new Thread(x,"Odd").start();
	}
}
