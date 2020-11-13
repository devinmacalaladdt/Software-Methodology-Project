package application;

public class OrderLine {

	private int lineNumber; //a serial number created when a sandwich is added to the order
	private Sandwich sandwich;
	private double price;
	
	public OrderLine(Sandwich sandwich, double price) {
		
		this.sandwich = sandwich;
		this.price = price;
		
		
	}
	
	public double getPrice() {
		return price;
	}
	
	public Sandwich getSandwich() {
		return sandwich;
	}
	
	public void setLineNo(int No) {
		lineNumber = No;
	}
	
	public int getLineNo() {
		return lineNumber;
	}
		
}
