package shopping;
import java.text.DecimalFormat;

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
		
		DecimalFormat df2 = new DecimalFormat("#.##");
		
		return name+": $"+df2.format(price)+" : "+ (taxable?"is taxable":"tax free");
		
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
