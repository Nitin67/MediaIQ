public class Braces{
	
	public static void main(String args[]){
		
		printWellFormedBraces(2,2,"");
	}
	public static void printWellFormedBraces(int start, int end, String outStr){
		if(start==0 && end==0){
			System.out.println(outStr);
			return;
		}
		
		if(end>=start){
			if(start>0){
				printWellFormedBraces(start-1,end,outStr+'{');
			}
			printWellFormedBraces(start,end-1,outStr+'}');
		}
	}
}