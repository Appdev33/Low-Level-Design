public class Slot {
	
	private int slotNumber;
	private int floorNumber;
	private String slotType;
	private Vehicle vehicle;
	private boolean isBooked;
	
	public Slot(int slotNumber, int floorNumber, String slotType) {
		this.slotNumber = slotNumber;
		this.floorNumber = floorNumber;
		this.slotType = slotType;
		isBooked=false;
	}
	
	public int getSlotNumber() {
		return slotNumber;
	}

	public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
		
    public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
    
    public boolean getBooked() {
    	return isBooked;
    }	
    
    public String getSlotType() {
        return slotType;
    }

    public boolean isBooked() {
        return isBooked;
    }
	
    public String generateTicketID() {
    	return "_"+(floorNumber+1)+"_"+(slotNumber+1);
    }
    
    public Vehicle freeSlot() {
    	isBooked= false;
    	Vehicle freedVehicle = vehicle;
    	setVehicle(null);
    	
    	return freedVehicle;
    }
}
