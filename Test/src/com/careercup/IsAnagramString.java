package com.careercup;

public class IsAnagramString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "tom marvolo riddle";
		String str2 = "i am lord voldemort";
		// TODO Auto-generated method stub
		boolean isAnagram = isAnagram(str1,str2);

	}

	private static boolean isAnagram(String str1, String str2) {
		int[] charArray = new int[256];
		for(int i=0;i<str1.length();i++)
			charArray[str1.charAt(i)]++;
		for(int i=0;i<str2.length();i++)
			charArray[str2.charAt(i)]--;
		for(int i:charArray){
			if(i!=0)
				return false;
		}
			
		return true;
	}

}
