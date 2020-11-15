/**
 * OrderLine object class
 * @author Devin Macalalad, David Gasperini
 */

package application;

public class OrderLine {

	private int lineNumber; //a serial number created when a sandwich is added to the order
	private Sandwich sandwich;
	private double price;
	/**
	 * Constructor for a new order line
	 * @param sandwich : sandwich object
	 * @param price : price of sandwich
	 */
	public OrderLine(Sandwich sandwich, double price) {
		
		this.sandwich = sandwich;
		this.price = price;
		
		
	}
	
	/**
	 * accessor for price
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Accessor for sandwich object
	 * @return sandwich object
	 */
	public Sandwich getSandwich() {
		return sandwich;
	}
	
	/**
	 * mutator for line number
	 * @param new line number (usually old minus 1)
	 */
	public void setLineNo(int No) {
		lineNumber = No;
	}
	
	/**
	 * accessor for line number
	 * @return line number
	 */
	public int getLineNo() {
		return lineNumber;
	}
		
}
