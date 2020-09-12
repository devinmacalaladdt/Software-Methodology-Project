package shopping;


/**
 * 
 * @author devin
 */

public class GroceryItem {

	private String name;
	private double price;
	private boolean taxable;
	
	public GroceryItem(String name, double price, boolean taxable) {
		
		this.name = name;
		this.price = price;
		this.taxable = taxable;
		
	}
	/**
	 *
	 *@param
	 *@return
	 */
	
	public boolean equals(Object obj) {return false;}
	/**
	 *
	 *@param
	 *@return
	 */
	
	public String toString() {return "";}
	/**
	 *
	 *@param
	 *@return
	 */
	
	public double getPrice() {
		
		return price;
		
	}
	/**
	 *
	 *@param
	 *@return
	 */
	
	public boolean getTaxable() {
		
		return taxable;
		
	}
	/**
	 *
	 *@param
	 *@return
	 */
	
	public String getName() {
		
		return name;
		
	}
	
}
