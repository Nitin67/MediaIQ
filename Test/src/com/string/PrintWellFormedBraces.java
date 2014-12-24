package com.string;

public class PrintWellFormedBraces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count = 5;
		if(args!=null&&args.length!=0){
			 count = Integer.valueOf(args[0]);
		}
			print("",0,0,3);
		
	}

	private static String print(String string, int open, int close,int count) {
		if(open==count && close==count){
			System.out.println(string+"||||");
			string = "";
		}
		if(open<count)
			string=print(string+"{",open+1,close,count);
		if(close<open)
			string=print(string+"}",open,close+1,count);
		return string;
	}

}
