package com.careercup;

public class CompareString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "asbdkjhf";
		String str2 = "asjdjdsapw";
		int[] str1Array = new int[26];
		int[] str2Array = new int[26];
		int i=0;
		while(i<str1.length()){
			int j = str1.charAt(i)-'a';
			str1Array[j] = 1;
			i++;
		}
		i=0;
		while(i<str2.length()){
			int j = str2.charAt(i)-'a';
			str2Array[j] = 1;
			i++;
		}
		i=0;
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		while(i<26){
			if(str1Array[i]==1&&str2Array[i]!=1)
				sb1.append(Character.valueOf((char) ('a'+i)));
			if(str2Array[i]==1&&str1Array[i]!=1)
				sb2.append(Character.valueOf((char) ('a'+i)));
			i++;
		}
		System.out.println(sb1.toString());
		System.out.println(sb2.toString());
	}

}
