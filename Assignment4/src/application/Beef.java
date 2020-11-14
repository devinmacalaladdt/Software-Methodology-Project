package application;

import java.util.ArrayList;

/**
 * Class to represent a Beef sandwich and methods to edit and represent it
 * @author Devin Macalalad, David Gasperini
 */

public class Beef extends Sandwich{
	
	private final double sandwich_Price = 10.99;
	final static String[] basicIngredients = {"Roast Beef", "Provolone Cheese", "Mustard"};

	/**
	 * Calculates the price of the current Beef sandwich using default price and current extras
	 * @return price of the sandwich
	 */
	@Override
	public double price() {
		return sandwich_Price+Sandwich.PER_EXTRA*this.extras.size();
	}
	
	/**
	 * Method to construct string to represent a Beef sandwich
	 * @return string representation of a Beef sandwich
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
	public Beef() {
		
		this.extras = new ArrayList<Extra>();
		
	}

}
