package Game2048;

import java.util.Scanner;
import java.util.Random;

public class Grid {
	
	int gridSize;
	String Grid[][];
	Scanner input;
	Move obj;
	
	public Grid() {
	}
	
	public Grid(int gridSize) {
		this.gridSize = gridSize;
		this.Grid = new String[gridSize][gridSize];
		initialiseGrid(Grid);
		System.out.println("Initial State of the Grid");
		input = new Scanner(System.in);
	}
	
		private void initialiseGrid(String Grid[][]){
			
			   for(int i=0; i<Grid.length; i++)
				   for(int j=0;j<Grid[0].length; j++)
				   {
					   Grid[i][j]="-";
				   }
			   Random rand = new Random();
//			   int row = rand.nextInt(gridSize-1);
//			   int col = rand.nextInt(gridSize-1);
//			   Grid[row][col]="2";
			   Grid[0][1]="16";
			   Grid[0][3]="16";
			   Grid[0][0]="16";
			   Grid[1][2]="2";
			   Grid[2][0]="8";
			   Grid[3][3]="2";
			   Grid[2][2]="2";
			   Grid[2][3]="2";
								   
	   }
	   
	   private void printGrid() {
		   
		   for(int i=0; i<Grid.length; i++) {
			   for(int j=0;j<Grid[0].length; j++){
				   System.out.print(Grid[i][j]);
			   }
			   System.out.println();
		   }
	   }
	   
	   public void startGame() {
		   printGrid();
		   int count =0;
		   
//		   while(true) {
//			   count++;
//		   }
		   
		   if(count==gridSize*gridSize-1){
			   System.out.println();
		   } 
		   int move=-1;
		   while(move!=9) {
			   System.out.println("Enter Move 0:LEFT 1:RIGHT 2:TOP 3:BOTTOM");
			   move = input.nextInt();
			   obj = new Move();
			   obj.makeMove(move, Grid);
			   printGrid();
		   }
		   
	   }
}
