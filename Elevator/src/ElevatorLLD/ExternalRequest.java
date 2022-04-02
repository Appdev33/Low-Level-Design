package ElevatorLLD;



public class ExternalRequest {
	
	private int sourceFloor;
	private Direction directionToGo;
	
	
	public ExternalRequest(Direction directionToGo,int sourceFloor) {
		this.sourceFloor = sourceFloor;
		this.directionToGo = directionToGo;
	}
	
	public int getSourceFloor() {
		return sourceFloor;
	}
	public void setSourceFloor(int sourceFloor) {
		this.sourceFloor = sourceFloor;
	}
	public Direction getDirectionToGo() {
		return directionToGo;
	}
	public void setDirectionToGo(Direction directionToGo) {
		this.directionToGo = directionToGo;
	}
	
}
