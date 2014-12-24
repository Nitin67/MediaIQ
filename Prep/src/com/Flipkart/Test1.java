package com.Flipkart;


public class Test1 {
	 static int getDNAAlignment(String dna1, String dna2) {
		 int arr[][]={{5,-1,-2,-1,-1},
				 {-1,5,-3,-2,-4},
				 {-2,-3,5,-2,-2},
				 {-1,-2,-2,5,-1},
				 {-3,-4,-2,-1,0}
		 };	
		 if(dna1==null && dna2==null)
			 return arr[4][4];
		 else if(dna1==null)
		 {
			 int y=val(dna2.charAt(dna2.length()-1));
			 return arr[4][y];
		 }
		 else if(dna2==null)
		 {
			 int x=val(dna1.charAt(dna1.length()-1));
			 return arr[x][4];
		 }
		 int kl=0;
		 if(dna1.length()>0 && dna2.length()>0)
		 {
		 int x=val(dna1.charAt(dna1.length()-1));
		 int y=val(dna2.charAt(dna2.length()-1));
		 kl= arr[x][y]+getDNAAlignment(dna1.substring(0, dna1.length()-1),dna2.substring(0,dna2.length()-1));
		 kl=max(kl,getDNAAlignment(dna1.substring(0, dna1.length()),dna2.substring(0,dna2.length()-1))+arr[4][y]);
		 kl=max(kl,getDNAAlignment(dna1.substring(0, dna1.length()-1),dna2.substring(0,dna2.length()))+arr[x][4]);
		 }
		return kl;


	    }

	private static int max(int kl, int i) {
		return (kl>i)?kl:i;
	}
	private static int val(char c)
	{
		if(c=='A')
			return 0;
		else if(c=='C')
			return 1;
			else if(c=='G')
				return 2;
				else if(c=='T')
					return 3;
		return c;
					
			
			
	}
	public static void main(String []args)
	{
		System.out.println(getDNAAlignment("ATGTTG","GTCG"));
	}
	 
	
}
