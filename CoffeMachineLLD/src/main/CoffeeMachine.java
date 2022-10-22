package main;

import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

import beverages.IBeverage;
import composers.IComposer;
import ingredients.IngredientsHolder;

public class CoffeeMachine {
	
	private MachineInfo machineInfo;
	private IngredientsHolder ingredientHolder;
	private Boolean isSwitchOn;
	private Map<String,IComposer> composers;   //Check this Interface as input
	private Logger logger = Logger.getLogger("CoffeeMachine");
	private CoffeeCustomThreadExecutor coffeeCustomThreadExecutor;
	private Semaphore semaphore;
	
	public CoffeeMachine(Builder builder) {                //Coffee Constructor initialisation
        machineInfo = new MachineInfo();
        machineInfo.setBrandName(builder.brandName);
        machineInfo.setNoOfSlots(builder.noOfSlots);
        this.composers = builder.composers;
        this.ingredientHolder = builder.ingredientHolder;
        this.isSwitchOn = builder.isSwitchOn;
        coffeeCustomThreadExecutor = new CoffeeCustomThreadExecutor(builder.noOfSlots);
        this.semaphore = new Semaphore(builder.noOfSlots);
	}
	
	public static class Builder{
		
		private String brandName;
		private int noOfSlots;
		private Map<String,IComposer> composers;
		private IngredientsHolder ingredientHolder;
		private Boolean isSwitchOn;
		
		private Builder() {}
		
		public static Builder getNewInstance() {
			return new Builder();
		}

		public String getBrandName() {
			return brandName;
		}

		public Builder setBrandName(String brandName) {
			this.brandName = brandName;
			return this;
		}

		public Builder setNoOfSlots(int noOfSlots) {
			this.noOfSlots = noOfSlots;
			return this;
		}

		public Builder setComposers(Map<String, IComposer> composers) {
			this.composers = composers;
			return this;
		}

		public Builder setIngredientHolder(IngredientsHolder ingredientHolder) {
			this.ingredientHolder = ingredientHolder;
			return this;
		}

		public Builder setIsSwitchOn(Boolean isSwitchOn) {
			this.isSwitchOn = isSwitchOn;
			return this;
		}
		
		public CoffeeMachine build() {                 // Awesome line that allows chaining
			return new CoffeeMachine(this);
		}
	}
	
	
	 public IBeverage requestBeverage(String beverageType) {
		 
		 if(!getIsSwitchOn()) {
			 System.out.println("\nMachine Not On");
			 return null;
		 }
			 
		 if(!composers.containsKey(beverageType)) {
			 System.out.println("\nMachine Does not support particular beverage: " + beverageType);
	            return null;
		 }
		 
		 System.out.println("\nThread name: " + Thread.currentThread().getName());
		 
		 boolean isAvailableSlot = semaphore.tryAcquire();
		 
		 if(!isAvailableSlot) {
	            System.out.println("\nNo available slots found for thread : " + Thread.currentThread().getName());
	            return null;
	     } else {
	            System.out.println("\n Lock acquired by thread" + Thread.currentThread().getName());
	     }
		 
		 IBeverage beverage = null;
		 
		 return null;
	 }
	
	
	
	public MachineInfo getMachineInfo() {
		return machineInfo;
	}
	public void setMachineInfo(MachineInfo machineInfo) {
		this.machineInfo = machineInfo;
	}
	public IngredientsHolder getIngredientHolder() {
		return ingredientHolder;
	}
	public void setIngredientHolder(IngredientsHolder ingredientHolder) {
		this.ingredientHolder = ingredientHolder;
	}
	public Boolean getIsSwitchOn() {
		return isSwitchOn;
	}
	public void setIsSwitchOn(Boolean isSwitchOn) {
		this.isSwitchOn = isSwitchOn;
	}
	public Map<String, IComposer> getComposers() {
		return composers;
	}
	public void setComposers(Map<String, IComposer> composers) {
		this.composers = composers;
	}
}
