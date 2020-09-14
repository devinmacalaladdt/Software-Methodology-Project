package shopping;

/**
 * 
 * @author devin
 */

public class GroceryItem {

	private String name;
	private double price;
	private boolean taxable;
	
	/**
	 *
	 *@param
	 *@return
	 */
	
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
	
	public boolean equals(Object obj) {
		
		return ((((GroceryItem)obj).name).equals(name) && 
				((GroceryItem)obj).price==price && ((GroceryItem)obj).taxable==taxable);
		
	}
	/**
	 *
	 *@param
	 *@return
	 */
	
	public String toString() {
		
		
		return name+": $"+String.format("%.2f",price)+" : "+ (taxable?"is taxable":"tax free");
		
	}
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
