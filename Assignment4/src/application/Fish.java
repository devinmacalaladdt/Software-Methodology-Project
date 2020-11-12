package application;

import java.util.ArrayList;

public class Fish extends Sandwich{
	
	private final double sandwich_Price = 12.99;
	final static String[] basicIngredients = {"Grilled Snapper", "Cilantro", "Lime"};

	@Override
	public double price() {
		return sandwich_Price+Sandwich.PER_EXTRA*this.extras.size();
	}
	
	@Override
	public String toString() {
		
		return "";
		
	}
	
	public Fish() {
		
		this.extras = new ArrayList<Extra>();
		
	}

	@Override
	protected Sandwich copy() {
		return new Fish();
	}


}
