package SnakesAndLadder;

public class Player {
	private String pName;
	private int pID;
	int currPos;
	
	public Player(String pName, int pID, int currPos) {
//		super();
		this.pName = pName;
		this.pID = pID;
		this.currPos = currPos;
	}

	public String getpName() {
		return pName;
	}

//	public void setpName(String pName) {
//		this.pName = pName;
//	}

	public int getpID() {
		return pID;
	}

//	public void setpID(String pID) {
//		this.pID = pID;
//	}

	public int getCurrPos() {
		return currPos;
	}

	public void setCurrPos(int currPos) {
		this.currPos = currPos;
	}
}
