package Game2048;

public class Move {
	
	int direction;
	Grid board;
	Grid ob = new Grid();
	
//	public Move(int direction) {
//		this.direction=direction;
//		
//	}
	
	public void makeMove(int direction,String Grid[][]) {
		
		switch(direction) {
			//LEFT
			case 0:{
				shiftAndAddLeft(Grid);
				break;
			}
			//RIGHT
			case 1:{
				shiftAndAddRight(Grid);
				break;
			}
			//TOP
			case 2:{
				shiftAndAddTop(Grid);
				break;
			}
			//BOTTOM
			case 3:{
				shiftAndAddBottom(Grid);
				break;
			}
		}	
	}
	private void shiftAndAddLeft(String Grid[][]){
		StringBuilder sbHorizontal = new StringBuilder();
		
		for(int row=0; row<Grid.length; row++) {
			for(int col=0;col<Grid[0].length; col++){
				if(Grid[row][col]!="-") {
					sbHorizontal.append(Grid[row][col]);
					Grid[row][col]="-";
				}
			}

			String str = sbHorizontal.toString();
			//left
			for(int i=0;i<sbHorizontal.length();i++) {
				Grid[row][i]=Character.toString(str.charAt(i) );
			}
			
			sbHorizontal.setLength(0);
		}
		
		boolean flag = false;
		
		//	Add Adjacent to the Left Sides
		for(int row=0;row<Grid.length; row++) {
			for(int col=1; col<Grid[0].length;col++) {
				if(Grid[row][col].equals(Grid[row][col-1]) && Grid[row][col]!="-") {
					flag=true;
					int curr = Integer.valueOf(Grid[row][col]);
//					System.out.println("fsfs"+Integer.valueOf("16"));
					Grid[row][col]="-";
					curr = curr*2;
					
					
					Grid[row][col]="-";
					Grid[row][col-1]=String.valueOf(curr);
				}
			}
		}
		
		if(flag==true) {
			sbHorizontal = new StringBuilder();
			
			for(int row=0; row<Grid.length; row++) {
				for(int col=0;col<Grid[0].length; col++){
					if(Grid[row][col]!="-") {
						sbHorizontal.append(Grid[row][col]);
						Grid[row][col]="-";
					}
				}

				String str = sbHorizontal.toString();
				if(str.length()>Grid.length)
					continue;
				else {
					//left
					for(int i=0;i<sbHorizontal.length();i++) {
						Grid[row][i]=Character.toString(str.charAt(i) );
					}
				}
				sbHorizontal.setLength(0);
			}
		}	
	}
	
	private void shiftAndAddRight(String Grid[][]){
		StringBuilder sbHorizontal = new StringBuilder();
		
		for(int row=0; row<Grid.length; row++) {
			for(int col=0;col<Grid[0].length; col++){
				if(Grid[row][col]!="-") {
					sbHorizontal.append(Grid[row][col]);
					Grid[row][col]="-";
				}
			}
			String str = sbHorizontal.toString();
			if(str.length()>Grid.length)
				continue;
			else {			
				//right
				for(int i=0;i<sbHorizontal.length();i++) {
					Grid[row][Grid[0].length-i-1]=Character.toString(str.charAt(i) );
				}	
			}
			sbHorizontal.setLength(0);
		}
		
		boolean flag = false;
		//	Add Adjacent to the Left Sides
		for(int row=0;row<Grid.length; row++) {
			for(int col=Grid[0].length-2; col>=0;col--) {
				if(Grid[row][col]==Grid[row][col+1] && Grid[row][col]!="-") {
					flag=true;
					int curr = Integer.valueOf(Grid[row][col]);
					Grid[row][col]="-";
					curr = curr*2;
					Grid[row][col]="-";
					Grid[row][col-1]=String.valueOf(curr);
				}
			}
		}
		if(flag) {
			sbHorizontal = new StringBuilder();
			for(int row=0; row<Grid.length; row++){
				for(int col=0;col<Grid[0].length; col++){
					if(Grid[row][col]!="-") {
						sbHorizontal.append(Grid[row][col]);
						Grid[row][col]="-";
					}
				}
				String str = sbHorizontal.toString();
				if(str.length()>Grid.length)
					continue;
				else {			
					//right
					for(int i=0;i<sbHorizontal.length();i++) {
						Grid[row][Grid[0].length-i-1]=Character.toString(str.charAt(i) );
					}	
				}
				sbHorizontal.setLength(0);
			}
		}
	}
	private void shiftAndAddTop(String Grid[][]) {
		
		StringBuilder sbVertical = new StringBuilder();
		for(int row=0; row<Grid.length; row++) {
			for(int col=0;col<Grid[0].length; col++){
				if(Grid[col][row]!="-") {
					sbVertical.append(Grid[col][row]);
					Grid[col][row]="-";
				}
			}

			String str = sbVertical.toString();
//			System.out.println(str);
			
			if(str.length()>Grid.length)
				continue;
			else {
				//Top
				for(int i=0;i<sbVertical.length();i++) {
					Grid[i][row]=Character.toString(str.charAt(i) );
				}
				sbVertical.setLength(0);
			}
			
		}
	}
	private void shiftAndAddBottom(String Grid[][]){
		
		StringBuilder sbVertical = new StringBuilder();
		for(int row=0; row<Grid.length; row++) {
			for(int col=0;col<Grid[0].length; col++){
				if(Grid[col][row]!="-") {
					sbVertical.append(Grid[col][row]);
					Grid[col][row]="-";
				}
			}

			String str = sbVertical.toString();
			if(str.length()>Grid.length)
				continue;
			else {			
				//bottom
				for(int i=0;i<sbVertical.length();i++) {
					Grid[Grid[0].length-i-1][row]=Character.toString(str.charAt(i) );
				}	
				sbVertical.setLength(0);
			}
			
		}
		/*StringBuilder sbHorizontal = new StringBuilder();
		
		for(int row=0; row<Grid.length; row++) {
			for(int col=0;col<Grid[0].length; col++){
				if(Grid[row][col]!="-") {
					sbHorizontal.append(Grid[row][col]);
					Grid[row][col]="-";
				}
			}

			String str = sbHorizontal.toString();
			if(str.length()>=Grid.length)
				continue;
			else {
				
				//left
//				for(int i=0;i<sbHorizontal.length();i++) {
//					Grid[row][i]=sbHorizontal.chartAt(i).toString();
//				}
				
				//right
				for(int i=0;i<sbHorizontal.length();i++) {
					Grid[row][Grid[0].length-i-1]=sbHorizontal.chartAt(i).toString();
				}	
			}
			sbHorizontal.setLength(0);
		}*/
		
//		for(int row=0;row<Grid.length; row++)
//			if(Grid[row][0]!="-")
//				continue; 
		
		/*
		for(int row=0; row<Grid.length; row++) {
			for(int col=0;col<Grid.length; col++){
				//corner on left move occupied do nothing
				if(Grid[row][0]!="-" || Grid[row][col]=="-")
					continue; 
				//current not empty but cannot left also occupied
				if(Grid[row][col]!="-" && Grid[row][col-1]!="-" )						
					continue;
				
				if(Grid[row][col]!="-" && Grid[row][col-1]=="-")
				{
					String c = Grid[row][col];
					Grid[row][col]="-";
					int left = col-1;
					while(Grid[row][left]=="-" && left>0)
						left--;
					Grid[row][left]=c;
				}
			}	
		}*/
	}
	
}
