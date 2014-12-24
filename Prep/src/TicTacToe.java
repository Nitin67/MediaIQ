
public class TicTacToe {

	private char [][]board;
	private char currentplayermove;
	
	public TicTacToe(int size)
	{
		board=new char[size][size];
		intializeBoard(size);
		currentplayermove='X';
	}
	public void intializeBoard(int size)
	{
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<3;j++)
			{
				board[i][j]='-';
			}
		}
	}
	
	public void changePlayerMove()
	{
		if(currentplayermove=='X')
			currentplayermove='O';
		else
			currentplayermove='O';
	}
	
	public boolean isFull()
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				if(board[i][j]=='-')
					return false;
			}
		}
		return true;
	}
	public boolean isWin()
	{
		return (isRowWin() || isColWin() || isDiagonalWin());
		
	}
	
	
	public boolean checkRolColumnForWin(char c1,char c2,char c3)
	{
		if(c1!='-' && c1==c2 && c2==c3)
		{
			return true;
		}
		return false;
	}
	
	
	
	private boolean isDiagonalWin() {
		return ((checkRolColumnForWin(board[0][0], board[1][1], board[2][2]))||(checkRolColumnForWin(board[0][2], board[1][1], board[2][0])));
	}
	private boolean isColWin() {
		for(int i=0;i<board[0].length;i++)
		{
			if(checkRolColumnForWin(board[0][i],board[1][i],board[2][i])==true)
				return true;
		}
		return false;
	}
	private boolean isRowWin() {
		for(int i=0;i<board[0].length;i++)
		{
			if(checkRolColumnForWin(board[i][0],board[i][1],board[i][2])==true)
				return true;
		}
		return false;
	}
	public static void main(String []args)
	{
		
	}
}
