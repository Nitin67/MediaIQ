import java.util.HashMap;

public class Board {

	int snakeAndLadder[][] =new int [101][7];
	
	HashMap<Integer, Integer> snakes = new HashMap<>();
	HashMap<Integer, Integer> ladders = new HashMap<>();
	public Board() {
		for(int i=0;i<101;i++){
			for(int j=1;j<=6;j++){
				snakeAndLadder[i][j] = i + j;
			}
		}
	}
	
	public void initialiseSnakeAndLadder(HashMap<Integer, Integer> snakes, HashMap<Integer, Integer> ladders){
		this.snakes = snakes;
		this.ladders = ladders;	
	}

}
