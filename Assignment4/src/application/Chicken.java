package application;

public class Chicken extends Sandwich{
	
	private final double sandwich_Price = 8.99;
	private final String basicIngredients = "Fried Chicken," + " Spicy Sauce," + " Pickles";
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
	
	public Chicken() {
		
	}
	
	@Override
	public double getTotal() {
		return sandwich_Price; //don't forget extras
	}
	
	@Override
	public String getSandwich() {
		return "Chicken";
	}
	
	@Override
	public String getExtras() {
		return basicIngredients + " - " + extras;
	}

	@Override
	protected Sandwich copy() {
		return new Chicken();
	}

}
