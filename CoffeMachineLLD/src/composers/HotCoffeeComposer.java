package composers;

import java.util.Map;
import static constants.BeverageConstants.BEVERAGE_HOT_COFFEE;

public class HotCoffeeComposer implements IComposer {

	Map<String,Integer> ingredientsRulesForHotCoffee;
	
	@Override
	public String getBeverageType() {
		return BEVERAGE_HOT_COFFEE;
	}

	@Override
	public Map<String, Integer> getRulesForComposer() {
		// TODO Auto-generated method stub
		return ingredientsRulesForHotCoffee;
	}

	@Override
	public void setRulesForComposer(Map<String, Integer> ingredientsMap) {
			this.ingredientsRulesForHotCoffee=ingredientsRulesForHotCoffee;
	}

}
