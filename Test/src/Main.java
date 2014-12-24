import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main{
	
	public static int patternMatch(String s1, String s2){
		int count =0;
		
		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++){
				if (s1.charAt(i)==s2.charAt(j)){
					count++;
					s2 = s2.replaceFirst(s2.substring(j,j+1),"`");
					break;
				}	
			}
		}
		return count;
	}
	
	public static void main(String args[]) throws java.lang.Exception{
				
		int i=0,inCnt=0;
				
		//Read input string from command line
		System.out.println("Enter the input string: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Capture the number of test cases
		inCnt = Integer.parseInt(br.readLine());
			
		//Declaring output
		int[] longPat = new int[inCnt];
			
		while(inCnt!=0){
			//read the strings to be compared
			String str1 = br.readLine();
			String str2 = br.readLine();
		
			//send the strings for pattern match
			longPat[i] = patternMatch(str1,str2);
			i++;
			inCnt--;
		}
		
		//Output
		
		//Check test cases constraint
		if(longPat.length>=1 && longPat.length<=100){
			System.out.println("\nTestCases within limit");
		}
		else{
			System.out.println("TestCases Not in limit");
		}
		
		for(i=0;i<longPat.length;i++){
			System.out.println("Longest pattern for input "+(i+1)+" is: "+longPat[i]);
		}
	}
} 
