

public class LongestPalindrom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "atbsjdraadwesdsffgntrrtrrljasdhfjs";
		System.out.println(longestPalindrom(s));
	}

	private static int longestPalindrom(String s) {
		if(s==null)
			return 0;
		if(s.length()<1)
			return 0;
		if(s.length()==1)
			return 0;
		if(isPalindrom(s))
			return s.length();
		return Math.max(longestPalindrom(s.substring(0, s.length()-1)), longestPalindrom(s.substring(1,s.length())));
	}

	private static boolean isPalindrom(String s) {
		int i=0,j=s.length()-1;
		boolean isPalindrom = false;
		while(i<j){
			if(s.charAt(i)==s.charAt(j)){
				i++;j--;
				isPalindrom=true;
			}else{
				isPalindrom = false;
				break;
			}
				
				
		}
		
		return isPalindrom;
	}

}
