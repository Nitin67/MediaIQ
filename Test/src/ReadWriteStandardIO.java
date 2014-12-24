import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReadWriteStandardIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Console c = System.console();
		String str = c.readLine("Enter Name: ");
		char[] password = c.readPassword();
		System.out.println("Name :" + str);
		System.out.println("Password :"+Arrays.toString(password));*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String sr = br.readLine();
			String sr2 = br.readLine();
			System.out.println("Entered String : "+sr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
