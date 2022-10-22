//https://github.com/NagabhushanS/CoffeeMachineLLD/tree/master/src
//https://leetcode.com/discuss/interview-question/object-oriented-design/1031034/Design-a-Coffee-Machine
//https://www.geeksforgeeks.org/dunzo-interview-experience-4-years-experienced/
package main;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import composers.BlackTeaComposer;
import composers.GreenTeaComposer;
import composers.HotCoffeeComposer;
import composers.HotTeaComposer;
import composers.IComposer;
import constants.IngredientsConstants;
import constants.BeverageConstants;
import ingredients.IngredientsHolder;

public class DemoApplication {

	public static void main(String[] args) {
		int count_n = 6 ;	
		HashMap<String,Integer> total_items_quantity = new HashMap<String,Integer>() {
			{
				put(IngredientsConstants.GINGER_SYRUP,5000);
				put(IngredientsConstants.GREEN_MIXTURE,5000);
				put(IngredientsConstants.HOT_MILK,8000);
				put(IngredientsConstants.HOT_WATER,9000);
				put(IngredientsConstants.SUGAR_SYRUP,8000);
				put(IngredientsConstants.TEA_LEAVES_SYRUP,8000);
			}
		};
		 HashMap<String, Integer> hotTeaData = new HashMap<String, Integer>() {
	            {
	                put(IngredientsConstants.HOT_WATER, 200);
	                put(IngredientsConstants.HOT_MILK, 100);
	                put(IngredientsConstants.GINGER_SYRUP, 10);
	                put(IngredientsConstants.SUGAR_SYRUP, 10);
	                put(IngredientsConstants.TEA_LEAVES_SYRUP, 30);
	            }
	        };

	        HashMap<String, Integer> hotCoffeeData = new HashMap<String, Integer>() {
	            {
	                put(IngredientsConstants.HOT_WATER, 100);
	                put(IngredientsConstants.HOT_MILK, 400);
	                put(IngredientsConstants.GINGER_SYRUP, 30);
	                put(IngredientsConstants.SUGAR_SYRUP, 50);
	                put(IngredientsConstants.TEA_LEAVES_SYRUP, 30);
	            }
	        };

	        HashMap<String, Integer> blackTeaData = new HashMap<String, Integer>() {
	            {
	                put(IngredientsConstants.HOT_WATER, 300);
	                put(IngredientsConstants.GINGER_SYRUP, 30);
	                put(IngredientsConstants.SUGAR_SYRUP, 50);
	                put(IngredientsConstants.TEA_LEAVES_SYRUP, 30);
	            }
	        };

	        HashMap<String, Integer> greenTeaData = new HashMap<String, Integer>() {
	            {
	                put(IngredientsConstants.HOT_WATER, 100);
	                put(IngredientsConstants.GINGER_SYRUP, 30);
	                put(IngredientsConstants.SUGAR_SYRUP, 50);
	                put(IngredientsConstants.GREEN_MIXTURE, 30);
	            }
	        };
		
	     //Recipee Class
	     IComposer  hotCoffeeComposer = new HotCoffeeComposer();
	     hotCoffeeComposer.setRulesForComposer(hotTeaData);
	     
	     IComposer  blackTeaComposer= new BlackTeaComposer();
	     blackTeaComposer.setRulesForComposer(hotCoffeeData);
	     
	     IComposer  hotTeaComposer= new HotTeaComposer();
	     hotTeaComposer.setRulesForComposer(hotTeaData);
	     
	     IComposer  greenTeaComposer= new GreenTeaComposer();
	     greenTeaComposer.setRulesForComposer(greenTeaData);
	     
	     
	     Map<String, IComposer> composerMap = new HashMap<String, IComposer>(){
	            {
	                put(BeverageConstants.BEVERAGE_BLACK_TEA, blackTeaComposer);
	                put(BeverageConstants.BEVERAGE_GREEN_TEA, greenTeaComposer);
	                put(BeverageConstants.BEVERAGE_HOT_COFFEE, hotCoffeeComposer);
	                put(BeverageConstants.BEVERAGE_HOT_TEA, hotTeaComposer);
	            }
	        };
	     
        CoffeeMachine coffeeMachine = CoffeeMachine.Builder.getNewInstance()
	    		 .setBrandName("CoffeeMaker")
	    		 .setNoOfSlots(count_n)
	    		 .setIngredientHolder(new IngredientsHolder(total_items_quantity))
	    		 .setComposers(composerMap)
	    		 .build();
        coffeeMachine.setIsSwitchOn(true);
		
       
     // Parallel Running Multiple Threads
        Runnable greenTeaRunnable  = new Runnable() {
            @Override
            public void run() {
                coffeeMachine.requestBeverage(BeverageConstants.BEVERAGE_GREEN_TEA);
            }
        };

        Runnable hotTeaRunnable  = new Runnable() {
            @Override
            public void run() {
                coffeeMachine.requestBeverage(BeverageConstants.BEVERAGE_HOT_TEA);
	            System.out.print("TEA");
            }
        };

        Runnable blackTeaRunnable  = new Runnable() {
            @Override
            public void run() {
                coffeeMachine.requestBeverage(BeverageConstants.BEVERAGE_BLACK_TEA);
                System.out.print("BLACK_TEA");
            }
        };

        Runnable hotCoffeeRunnable  = new Runnable() {
            @Override
            public void run() {
                coffeeMachine.requestBeverage(BeverageConstants.BEVERAGE_HOT_COFFEE);
            }
        };        

        Runnable arr[] = new Runnable[]{hotTeaRunnable,blackTeaRunnable,blackTeaRunnable};
        
        for(int i=0;i<10;i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
            Thread t = new Thread(arr[randomNum]);
            t.setName("["+ "Thread "+ i +"]");
            t.start();
        }
        while(true) {
//             For Holding threads execution.
        }
        
        
	}
}

