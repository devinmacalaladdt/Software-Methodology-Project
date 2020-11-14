package application;

import java.util.ArrayList;

/**
 * Class to represent a Chicken sandwich and methods to edit and represent it
 * @author Devin Macalalad, David Gasperini
 */
public class Chicken extends Sandwich{
	
	private final double sandwich_Price = 8.99;
	final static String[] basicIngredients = {"Fried Chicken", "Spicy Sauce", "Pickles"};

	/**
	 * Calculates the price of the current Chicken sandwich using default price and current extras
	 * @return price of the sandwich
	 */
	@Override
	public double price() {
		return sandwich_Price+Sandwich.PER_EXTRA*this.extras.size();
	}
	
	/**
	 * Method to construct string to represent a Chicken sandwich
	 * @return string representation of a Chicken sandwich
	 */
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
	
	/**
	 * constructor for a chicken sandwich
	 */
	public Chicken() {
		
		this.extras = new ArrayList<Extra>();
		
	}

}
