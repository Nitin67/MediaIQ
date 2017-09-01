package coding.dp;

public class LongestCommonSubsequence {

	public static int lengthOfLongestCommonSubsequence(String str1, String str2){
		
		int str1Index = 0;
		int str2Index = 0;
		
		int dp[][] = new int[str1.length() + 1][str2.length() + 1];
		for(int i=0;i<=str1.length();i++){
			dp[i][0] = 0;
		}
		for(int i=0;i<str2.length();i++){
			dp[0][i] = 0;
		}
		for(int i=1;i<=str1.length();i++){
			for (int j = 1; j <= str2.length(); j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				dp[i][j] =Integer.max(Integer.max(dp[i][j-1], dp[i-1][j]), dp[i][j]);
			}
		}
		return dp[str1.length()][str2.length()];
	}
	
	public static void main(String[] args) {
		String a= "skddsn";
		String b= "afddsn";
		System.out.println(lengthOfLongestCommonSubsequence(a, b));
	}
}
