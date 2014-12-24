public class FloodFill3D {
	static int boundary = 0;
	static int corner = 0;
	static int boundaryLine = 0;
	
	public static void main(String[] args){
		 String[] SArray = new String[]{"ooo"};
	        String[] TArray = new String[]{"oo"};
	        String[] UArray = new String[]{"o"};
        System.out.println(countBlack(SArray, TArray, UArray));
	}
	public static long countBlack(String[] SArray, String[] TArray, String[] UArray) {
		String S = concate(SArray);
		String T = concate(TArray);
		String U = concate(UArray);
		return countBoundary(S.toCharArray(),T.toCharArray(),U.toCharArray());
		
	}
	
	private static String concate(String[] tArray) {
		String string = "";
		for(int i=0;i<tArray.length;i++)
			string+=tArray[i];
		return string;
	}
	public static long countBoundary(char[] cs, char[] cs2, char[] cs3){
		int Nx = cs.length;
		int Ny = cs2.length;
		int Nz = cs3.length;
		
		for(int i=0;i<Nx;i++){
			char X = cs[i];
			for(int j = 0;j<Ny;j++){
				char Y = cs2[j];
				char Z1 = cs3[0],Z2=cs3[Nz-1];
				if((X ==Y)&&(X == Z1)){
					if(i==0&&j==0||i==Nx-1&&j==0||i==0&&j==Ny-1||i==Nx-1&&j==Ny-1)
						corner++;
					if(!(i==0&&j==0||i==Nx-1&&j==0||i==0&&j==Ny-1||i==Nx-1&&j==Ny-1)&&(i==0||i==Nx-1||j==0||j==Ny-1))
						boundaryLine++;
					boundary++;
				}
				if(X == Y&&(X==Z2)){
					if(i==0&&j==0||i==Nx-1&&j==0||i==0&&j==Ny-1||i==Nx-1&&j==Ny-1)
						corner++;
					if(!(i==0&&j==0||i==Nx-1&&j==0||i==0&&j==Ny-1||i==Nx-1&&j==Ny-1)&&(i==0||i==Nx-1||j==0||j==Ny-1))
						boundaryLine++;
					boundary++;
				}
			}
		}
		
		for(int i=0;i<Nx;i++){
			char X = cs[i];
			for(int j = 0;j<Nz;j++){
				char Z = cs3[j];
				char Y1 = cs2[0],Y2=cs2[Nz-1];
				if(X==Z&&(X==Y1)){
					if(i==0&&j==0||i==Nx-1&&j==0||i==0&&j==Nz-1||i==Nx-1&&j==Nz-1)
						corner++;
					if(!(i==0&&j==0||i==Nx-1&&j==0||i==0&&j==Nz-1||i==Nx-1&&j==Nz-1)&&(i==0||i==Nx-1||j==0||j==Nz-1))
						boundaryLine++;
					boundary++;
				}
				if((X==Z)&&(X==Y1)){
					if(i==0&&j==0||i==Nx-1&&j==0||i==0&&j==Nz-1||i==Nx-1&&j==Nz-1)
						corner++;
					if(!(i==0&&j==0||i==Nx-1&&j==0||i==0&&j==Nz-1||i==Nx-1&&j==Nz-1)&&(i==0||i==Nx-1||j==0||j==Nz-1))
						boundaryLine++;
					boundary++;
				}
			}
		}
		
		for(int i=0;i<Ny;i++){
			char Y = cs2[i];
			for(int j = 0;j<Nz;j++){
				char Z = cs3[j];
				char X1 = cs[0],X2=cs[Nz-1];
				if((Y==Z)&&(Y==X1)){
					if(i==0&&j==0||i==Ny-1&&j==0||i==0&&j==Nz-1||i==Ny-1&&j==Nz-1)
						corner++;
					if(!(i==0&&j==0||i==Ny-1&&j==0||i==0&&j==Nz-1||i==Ny-1&&j==Nz-1)&&(i==0||i==Ny-1||j==0||j==Nz-1))
						boundaryLine++;
					boundary++;
				}
				if((Y==Z)&&(Y==X2)){
					if(i==0&&j==0||i==Ny-1&&j==0||i==0&&j==Nz-1||i==Ny-1&&j==Nz-1)
						corner++;
					if(!(i==0&&j==0||i==Ny-1&&j==0||i==0&&j==Nz-1||i==Ny-1&&j==Nz-1)&&(i==0||i==Ny-1||j==0||j==Nz-1))
						boundaryLine++;
					boundary++;
				}
			}
		}
		if(Nx==1) corner+=2;
		if(Ny==1) corner+=2;
		if(Nz==1) corner+=2;
		return Nx*Nz*Ny - (boundary - boundaryLine/2 - corner/3);
			
	}

}
