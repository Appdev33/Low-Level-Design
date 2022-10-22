package ingredients;

import java.util.HashMap;
import java.util.Map;

public class IngredientsHolder {
	
	private Map<String, Integer> ingredientStock;
	
	public IngredientsHolder(Map<String, Integer> ingredientStock) {
        this.ingredientStock = ingredientStock;
    }
	
	public Boolean isIngredientSupported(String ingredientType) {
		return ingredientStock.containsKey(ingredientType);
	}
	
	public int getIngredientQuantity(String ingredientType) {
		return ingredientStock.get(ingredientType);
	}
	
	public void setIngredientQuantity(String ingredientType,int quantity) {
		ingredientStock.put(ingredientType, quantity);
	}
}
