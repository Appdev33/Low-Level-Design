package SnakesAndLadder;
import java.util.*;;

public class Board {
	int boardSize;
	boolean board[];
	Map<Integer,Integer> Snakes;
	Map<Integer,Integer> Ladders;
	Queue<Player> nextTurn;
	Scanner input;
	int snakesCount;
	int laddersCount;
	ArrayList<Player> players;
	
	public Board(int boardSize) {
		this.boardSize = boardSize;
		input = new Scanner(System.in);
		Snakes = new HashMap<>();
		Ladders = new HashMap<>();
		nextTurn = new LinkedList<>();
		players= new ArrayList<>();
		initialiseBoard();	
	}
	
//	public Board(int boardSize, int snakesCount, int laddersCount,Player[] players) {
//		this.boardSize = boardSize;
//		this.snakesCount=snakesCount;
//		this.laddersCount=laddersCount;
//		input = new Scanner(System.in);
//		Snakes = new HashMap<>();
//		Ladders = new HashMap<>();
//		initialiseBoard();
//		nextTurn = new LinkedList<>();
//	}
	
	private void SnakesFill() {
//		System.out.print("Enter Snakes Count");
		int snakesCount =input.nextInt();
//		System.out.print("Enter Start and End Positions For Snakes");
		while(snakesCount-->0) {
			int start = input.nextInt();
			int end = input.nextInt();
			Snakes.put(start, end);
		}
	}
	private void LaddersFill() {
//		System.out.print("Enter Ladder Count");
		int LadderCount =input.nextInt();
//		System.out.print("Enter Start and End Positions For Ladder");
		while(LadderCount-->0) {
			int start = input.nextInt();
			int end = input.nextInt();
			Ladders.put(start, end);
		}
	}
	private void PlayersFill() {
//		System.out.print("Enter Player Count");
		int pCount = input.nextInt();
		int id = 1;
		Player ob;
		while(pCount-->=0) {
//			System.out.print("Enter Player Name");
			String name = input.nextLine();
			ob = new Player(name,id++,0);
			players.add(ob);
			nextTurn.add(ob);
			
		}
	}
	
	private void initialiseBoard() {
		 SnakesFill();
		 LaddersFill();
		 PlayersFill();

//		board = new boolean[boardSize];
//		Arrays.fill(board, false);
	}
	
	public void printBoard() {
		System.out.println(Snakes);
		System.out.println(Ladders);
		System.out.println(nextTurn);
	}
	
	public void gameStart() {
		int MaxBoard=0;
		while(true)
		{
//			if(MaxBoard==100) {
//				some one won
				for(Player p: players)
					 if(p.getCurrPos()==100) {
						 System.out.print(p.getpName()+" Has Won the Game ");
						 break;
					 }
//				break;
//			}
			Player curr = nextTurn.poll();
			
//			System.out.println(curr.getpName());
			
			int origPos = curr.getCurrPos();
			int dieValue = throwDie();
			
			int newPos = dieValue+origPos;
			if(newPos<100){
				//check for Snakes or Ladders
				
				if(Snakes.containsKey(newPos))
					newPos=Snakes.get(newPos);
				else if(Ladders.containsKey(newPos))
					newPos=Ladders.get(newPos);

				//update position curr Player
				curr.currPos=newPos;
//				MaxBoard= Math.max(newPos, MaxBoard);
//				System.out.println(MaxBoard);
			
				System.out.println(curr.getpName() + " rolled a " + dieValue + " and moved from " + origPos + " to " + newPos);
				//Put next player in the queue
				nextTurn.offer(curr);
			}
			else if(newPos>100){
				nextTurn.offer(curr);
			}
			else
				break; 
		}
	}
	
	public int throwDie() {
		return (int)(Math.random() * 6) + 1;
	}
}
