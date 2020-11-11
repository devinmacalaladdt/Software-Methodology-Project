package application;

public class Beef extends Sandwich{
	
	private final double sandwich_Price = 10.99;
	private final String basicIngredients = "Roast Beef," + " Provolone Cheese," + " Mustard";
	private String extras = "";

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		
		return "";
		
	}
	
	public Beef() {
		
	}

	@Override
	public double getTotal() {
		return sandwich_Price; //don't forget extras
	}
	
	@Override
	public String getSandwich() {
		return "Beef";
	}
	@Override
	public String getExtras() {
		return basicIngredients + " - " + extras;
	}

	@Override
	protected Sandwich copy() {
		return new Beef();
	}

}
