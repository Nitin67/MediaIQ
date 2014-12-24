package com.careercup;

public class ReverseWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "This is a cat";
		char[] charArray = str.toCharArray();
		int i =0 ;
		char c = 'a';
		int a = c - 48;
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		
		while(i<charArray.length){
			StringBuffer wordStr = new StringBuffer();
			
			while(i<charArray.length&&charArray[i]!=' '){
				wordStr.append(charArray[i]);
				i++;
			}
			sb.insert(0,wordStr.toString());
			if(i<charArray.length&&charArray[i]==' '){
				wordStr = new StringBuffer();
				wordStr.append(charArray[i]);
				i++;
				sb.insert(0,wordStr.toString());
			}
			
		}
		System.out.println(sb.toString());
	}

}
