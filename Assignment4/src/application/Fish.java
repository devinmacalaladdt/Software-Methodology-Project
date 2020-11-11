package application;

public class Fish extends Sandwich{
	
	private final double sandwich_Price = 12.99;
	private final String basicIngredients = "Grilled Snapper," + " Cilantro," + " Lime";
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
	
	public Fish() {
		
	}

	@Override
	public double getTotal() {
		return sandwich_Price; //don't forget extras
	}
	
	@Override
	public String getSandwich() {
		return "Fish";
	}
	@Override
	public String getExtras() {
		return basicIngredients + " - " + extras;
	}

	@Override
	public Sandwich copy() {
		return new Fish();
	}

}
