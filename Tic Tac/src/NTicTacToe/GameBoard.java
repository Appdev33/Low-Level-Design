package NTicTacToe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameBoard {

   char board[][];
   int boardSize;
   Queue<Player> nextTurn;
   Scanner input;
   
   public GameBoard(int boardSize,Player[] players) {
	   this.boardSize=boardSize;
	   this.board = new char[boardSize][boardSize];
	   initialiseBoard(board);
	   printBoard();
	   
	   nextTurn = new LinkedList<>();
	   for(Player currPlayer: players)
		   nextTurn.offer(currPlayer) ;
	   input = new Scanner(System.in);
   }
   
   private void initialiseBoard(char board[][]){
	   for(int i=0; i<board.length; i++)
		   for(int j=0;j<board[0].length; j++)
		   {
			   board[i][j]='-';
		   }
   }
   
   private void printBoard() {
	   for(int i=0; i<board.length; i++) {
		   for(int j=0;j<board[0].length; j++){
			   System.out.print(board[i][j]);
		   }
		   System.out.println();
	   }
   }
   
   public void startGame() {
	   int count=0;
	   while(true) {
		   count++;
		   
		   if(count==(boardSize*boardSize+1)) {
			   System.out.println("Match Drawn");
			   break;
		   }
		   Player p = nextTurn.poll();
//		   int pos = getUserInput(p);
//		   int row  = (pos%boardSize==0)?(pos/boardSize)-1: (pos/boardSize);
//		   int col  = (pos%boardSize==0)?(boardSize-1): (pos%boardSize-1);
		   
		   Location l = getUserInput(p);
		   board[l.xVal][l.yVal]=p.getPlayerSymbol();
		   printBoard();
		   System.out.println("Board after the move");
		   
		   if(count>=boardSize && checkEndGame(p,l.xVal,l.yVal)) break;
		   
           nextTurn.offer(p);  //adding at end of Queue again
		   
		   
	   }
   }
   
   private Location getUserInput(Player p) {
	   
	   printBoard();
	   System.out.println(p.getPlayerName() + " Enter row & col  0 to " + (boardSize-1));
	   int row =0;
	   int col=0;
	   
	   while(true){
	       
		   try {
	    	   row = input.nextInt();
	    	   col = input.nextInt();
	    	   break;
	       }  
		   catch (ArrayIndexOutOfBoundsException e) {
			      System.out.println(e.getMessage());
			      input.next();
			    }
		   catch(Exception  InputMismatchException  ) {
			   System.out.println("check this Input again"); 
			   input.next(); // this consumes the invalid token
			   //https://stackoverflow.com/questions/3572160/how-to-handle-infinite-loop-caused-by-invalid-input-inputmismatchexception-usi
		   } 
	   }
	       
	   Location currMove = new Location(row,col);   
	   
	   while(!validateInput(currMove)) {
		   System.out.println("This is an invalid Input Enter Again");
		   printBoard();
		   currMove.xVal = input.nextInt();
		   currMove.yVal = input.nextInt();
	   }
	   return currMove; 
   }
   
   private boolean validateInput(Location currMove) {
	   
	    if(currMove.xVal<0 ||currMove.xVal>=boardSize) return false;
	    
	    int row  = currMove.xVal;
	    int col  = currMove.yVal;
	    
	    if(board[row][col]!='-') return false;
	    
	    return true;
  }
   
//   private int getUserInput(Player p) {
//	   printBoard();
//	   System.out.println(p.getPlayerName() + " Enter number between 1 to "+boardSize*boardSize);
//	   int pos = input.nextInt();
//	   
//	   while(!validateInput(pos)) {
//		   System.out.println("This is an invalid Input Enter Again");
//		   printBoard();
//		   pos = input.nextInt();
//	   }
//	   return pos; 
//   }
   
//   private boolean validateInput(int val) {
//	    if(val<1 ||val>boardSize*boardSize) return false;
//	    
//	    int row  = (val%boardSize==0)?(val/boardSize)-1: (val/boardSize);
//	    int col  = (val%boardSize==0)?(boardSize-1): (val%boardSize-1);
//	    
//	    if(board[row][col]!='-') return false;
//	    
//	    return true;
//   }
   
   private boolean checkEndGame(Player p,int row, int col) {
	   String winString = "";
	   for(int i=0;i<boardSize;i++)
		   winString+=String.valueOf(p.getPlayerSymbol());
	   
	   String rowString="";
       String colString="";
       String diagonalString="";
       String reverseDiagonalString="";
       for(int i=0;i<board.length;i=i+2){
           rowString += board[row][i];
           colString += board[i][col];
           if(row==col){
               diagonalString += board[i][i];
           }
           if((row+col)== board.length-1){
               reverseDiagonalString += board[board.length-1-i][i];
           }
       }

       if(winString.equals(rowString) || winString.equals(colString) || winString.equals(diagonalString) || winString.equals(reverseDiagonalString)){
           System.out.println(p.getPlayerName()+" has won the Game");
           return true;
       }

       return false;
   }

}