package com.backtracking;

public class KnightTourProblem {

	static int k=8;
	Boolean isSafe()
	{
		return true;
	}
	public static void printChessBoard(int [][]chessBoard)
	{
		for(int i=0;i<k;i++)
		{
			for(int j=0;j<k;j++)
			{
				System.out.print(chessBoard[i][j] + "  ");
			}
			System.out.println();
		}
	}
	public static Boolean knightTourUtils(int xmove[],int ymove[],int mov,int x,int y,int [][]chessBoard)
	{
		if(mov==k*k)
		{
			printChessBoard(chessBoard);
			return true;
		}
		else
		{
			
			for(int i=0;i<xmove.length;i++)
			{
				int x1=x+xmove[i];
				int y1=y+ymove[i];
				if(isSafe(x1,y1,chessBoard))
				{
				
				chessBoard[x1][y1]=mov;
			
				if(knightTourUtils(xmove, ymove, mov+1, x1, y1, chessBoard)==true)
				{
					return true;
				}
				else
				{
					chessBoard[x1][y1]=-1;
				}
				}
				
			}
			
		}
		return false;
	}
	private static boolean isSafe(int x, int y, int[][] chessBoard) {
		if(x>=0&& y>=0 && x<k && y<k && chessBoard[x][y]==-1)
			return true;
		else
		return false;
	}
	public static void knightTour()
	{
		int xmove[]={2, 1, -1, -2, -2, -1,  1,  2};
		int ymove[]={1, 2,  2,  1, -1, -2, -2, -1};
		int [][]chessBoard=new int[k][k];
		for(int i=0;i<k;i++)
		{
			for(int j=0;j<k;j++)
			{
				chessBoard[i][j]=-1;
			}
		}
		chessBoard[0][0]=0;
		knightTourUtils(xmove, ymove, 1, 0, 0, chessBoard);
		
	}
	public static void main(String []args)
	{
		knightTour();
	}

}
 