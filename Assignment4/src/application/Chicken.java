package application;

import java.util.ArrayList;

public class Chicken extends Sandwich{
	
	private final double sandwich_Price = 8.99;
	final static String[] basicIngredients = {"Fried Chicken", "Spicy Sauce", "Pickles"};


	@Override
	public double price() {
		return sandwich_Price+Sandwich.PER_EXTRA*this.extras.size();
	}
	
	@Override
	public String toString() {
		
		String ingredients = "";
		for(String s: basicIngredients) {
			
			ingredients += s + ", ";
			
		}
		for(Extra e: this.extras) {
			
			ingredients += e.getType() + ", ";
			
		}
		return super.toString() + ingredients + "Price $" + String.format("%.2f", price());
		
	}
	
	public Chicken() {
		
		this.extras = new ArrayList<Extra>();
		
	}

	@Override
	protected Sandwich copy() {
		return new Chicken();
	}

}
