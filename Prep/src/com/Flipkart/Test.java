package com.Flipkart;

public class Test {

	 static int getMinSplit(int width, int height, int nTiles) {
		
		 long widthbreak=-1,heightbreak=-1;
		 long widthl=(long)width;
		 long heightl=(long)height;		 
		 
		 if(heightl*widthl>nTiles)
		 {
		 for(int i=1;i<width;i++)
		 {
			 if(heightl*(widthl-i)==nTiles)
				 widthbreak= 1;
			 else
			 {
				 if(getMinSplit(width-i, height, nTiles)!=-1)
				 {
					 widthbreak=min(getMinSplit(width-i, height, nTiles)+1,widthbreak);
				 }
			 }
				 
			 
		 }
		 for(int i=1;i<height;i++)
		 {
			 if((heightl-i)*(widthl)==nTiles)
				 heightbreak= 1;
			 else
			 {
				 if(getMinSplit(width, height-i, nTiles)!=-1)
				 {
					 heightbreak=min(getMinSplit(width, height-i, nTiles)+1,heightbreak);
				 }
			 }
			 
		 }
		 }
		 else if(heightl*widthl<nTiles)
			 return -1;
		 else if(heightl*widthl==nTiles)
		 {
			 return 0;
		 }
		 
		 
		 
		 if(heightbreak!=-1 && widthbreak!=-1)
		 {
		 if(heightbreak<widthbreak)
		 {
		 return (int)heightbreak;
		 }
		 else{
			return (int)widthbreak;
		 }
		 }
		 else if(heightbreak!=-1)
		 {
			 return (int)heightbreak;
		 }
		 else if(widthbreak!=-1)
		 {
			 return (int)widthbreak;
		 }
		 else
		 return -1;


	    }

	private static long min(long i, long widthbreak) {
		if(widthbreak==-1)
			return i;
		return (i<widthbreak)?i:widthbreak;
	}

	private static boolean isPrime(int nTiles) {
		if(nTiles==0)
			return true;
		
		for(int i=2;i<nTiles/2+1;i++)
		{
			if(nTiles%i==0)
				return false;
		}
		return true;
			
	}
	public static void main(String []args)
	{
		System.out.println(getMinSplit(12, 10, 120));
	}
	
}
