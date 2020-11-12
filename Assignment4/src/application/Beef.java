package application;

import java.util.ArrayList;

public class Beef extends Sandwich{
	
	private final double sandwich_Price = 10.99;
	final static String[] basicIngredients = {"Roast Beef", "Provolone Cheese", "Mustard"};

	@Override
	public double price() {
		return sandwich_Price+Sandwich.PER_EXTRA*this.extras.size();
	}
	
	@Override
	public String toString() {
		
		return "";
		
	}
	
	public Beef() {
		
		this.extras = new ArrayList<Extra>();
		
	}

	@Override
	protected Sandwich copy() {
		return new Beef();
	}


}
