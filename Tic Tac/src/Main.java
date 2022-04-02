// Single function code for Tic Tac Toe

import java.util.Scanner;

class Main{
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		//Get the Player names
		System.out.print("Player 1 pls enter name?");
		String p1 = in.nextLine();
				
		System.out.print("Player 2 pls enter name?");
		String p2 = in.nextLine();
		
//		3*3 Board print  - 0 X -
		char board[][] = new char[3][3];
		
//		Fill board with dashes
		for(int i=0;i<board.length; i++)
		{
			for(int j=0;j<board[0].length; j++)
			{
				board[i][j]='-';
			}
		}
		
		boolean gameEnded = false;
		
		
		boolean isPlayer1=true;
		
		//while not some one won or game tied keep playing
		while(!gameEnded ){
			
				//draw initial board
				drawBoard(board);
	
				//keep track of the symbol you are using
				char symbol = ' ';
				if(isPlayer1)
					symbol='X';
				else
					symbol='O';
				
				//Print which player's turn
				if(isPlayer1){
					System.out.println("player1 turn (X)");
				}
				else {
					System.out.println("player2 turn (O)");				
				}
				
				int row =0;
				int col=0;
				
				while(true) {
					
					//Get row and col from user
					System.out.println("Enter value for row col 0 1 2");
					row = in.nextInt();
					col = in.nextInt();
					
					//put and validate values
					if(row<0 ||col<0 ||row>2||col>2||board[row][col]!='-')
						System.out.println("Invalid Move ");
					else
						break;  //Asking for a valid move till entered by user
					
				}
				board[row][col]=symbol;
//				drawBoard(board);
				
				if(hasWon(board)=='X') {
					System.out.println(" Player "+p1+" has Won the Game"); 
					gameEnded=true;
				}
				else if(hasWon(board)=='O') {
					System.out.println(" Player "+p2+" has Won the Game"); 
					gameEnded=true;
				}
				else if(hasTied(board)) {
					System.out.println("Game is Tied");
					gameEnded=true;
				}
				else {
					//Continue players and toggle turn
					isPlayer1 = !isPlayer1;
				}	
		}
	  //print Final Board
		drawBoard(board);
	}
	
	public static void drawBoard(char board[][]) {
		
		int row = board.length;
		int col = board[0].length;
		
		for(int i=0;i<row; i++)
		{
			for(int j=0;j<col; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}	 
	}
	
	public static char hasWon(char board[][]) {

//		Check rows on board for validity
		for(int i=0;i<board.length; i++)
			 if(board[i][0]==board[i][1] && board[i][1]==board[i][2] && board[i][0]!='-')
				 return board[i][0];
		
//		Check cols on board for validity
		for(int i=0;i<board[0].length; i++)
			 if(board[0][i]==board[1][i] && board[1][i]==board[2][i] && board[i][0]!='-')
				 return board[0][i];
		
		//Check diagnols for validity
		for(int i=0;i<board[0].length; i++)
			 if(board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[0][0]!='-')
				 return board[0][0];
		
		for(int i=0;i<board[0].length; i++)
			 if(board[2][0]==board[1][1] && board[1][1]==board[0][2] && board[1][1]!='-')
				 return board[0][0];
		
		return '-';
	}
	
	public static boolean hasTied(char board[][]) {
		
		for(int i=0;i<board.length; i++)
			for(int j=0; j<board[0].length;j++)
				if(board[i][j]=='-')
					return false; 
		
		return true;
	}
	
}