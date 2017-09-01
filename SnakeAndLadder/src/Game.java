import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Game {

	Board board;
	List<Player> players;
	
	public Game() {
		board = new Board();
		players = new ArrayList<Player>();
	}
	
	public void addPlayer(Player player){
		players.add(player);
	}
	
	public void startGame(){
		
		int i=0;
		Player player = null;
		do{
			i = i% players.size();
			player = players.get(i);
			int nxtLct = nextLocation(player.getLocation());
			player.setLocation(nxtLct);
			i++;
		}while (checkIfWinAndEndGame(player));
		
	}
	
	public boolean checkIfWinAndEndGame(Player player){
		if(player.getLocation() >= 100){
			System.out.println("Congrats Player " + player.getName() + " has won!!!!!!.");
			return false;
		}
		else{
			System.out.println("Player " + player.getName() + " is at location: "+ player.getLocation());
		}
		return true;
	}
	
	public int nextLocation(int currentLocation){
		Random random= new Random();
		int rand = random.nextInt(6) + 1;
		while(currentLocation + rand > 100){
			rand = random.nextInt(6) + 1;
		}
		int nxtLct = currentLocation + rand;
		if( this.board.ladders.containsKey(nxtLct) ){
			nxtLct = this.board.ladders.get(nxtLct);
			System.out.println("Ladder detected");
		}
		if( this.board.snakes.containsKey(nxtLct) ){
			nxtLct = this.board.snakes.get(nxtLct);
			System.out.println("Snake detected");
		}
		return nxtLct;
	}
	
	public static void main(String[] args) {
		Game game=new Game();
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(37, 13);
		hashMap.put(11, 4);
		hashMap.put(45, 23);
		hashMap.put(56, 35);
		hashMap.put(97, 67);
		HashMap<Integer, Integer> hashMap2 = new HashMap<Integer, Integer>();
		hashMap2.put(7, 16);
		hashMap2.put(11, 34);
		hashMap2.put(19, 58);
		hashMap2.put(43, 78);
		hashMap2.put(64, 93);
		game.board.ladders = hashMap2;
		game.board.snakes = hashMap;
		Player player= new Player();
		player.setName("Nitin");
		player.setPlayerId(1);
		player.setLocation(0);
		Player player1= new Player();
		player1.setName("Jack");
		player1.setPlayerId(2);
		player1.setLocation(0);
		game.addPlayer(player);
		game.addPlayer(player1);
		game.startGame();
	}
	
}
