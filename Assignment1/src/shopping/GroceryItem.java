package shopping;

/**
 * GroceryItem is a representation of an item in a store.
 * Contains the items name, price, and whether or not it is taxable.
 * @author Devin Macalalad, David Gasperini
 */

public class GroceryItem {

	private String name;
	private double price;
	private boolean taxable;
	
	/**
	 * Constructor for a GroceryItem.
	 * @param name of the GroceryItem.
	 * @param price of the GroceryItem.
	 * @param whether or not the GroceryItem is taxable.
	 */
	public GroceryItem(String name, double price, boolean taxable) {
		
		this.name = name;
		this.price = price;
		this.taxable = taxable;
		
	}
	
	/**
	 * Comparator for a specified GroceryItem to the current one.
	 * @param GroceryItem to compare to this one.
	 * @return true if all members of specified GroceryItem match the current one, false otherwise.
	 */
	public boolean equals(Object obj) {
		
		return ((((GroceryItem)obj).name).equals(name) && 
				((GroceryItem)obj).price == price && ((GroceryItem)obj).taxable == taxable);
		
	}
	
	/**
	 * Converts members of GroceryItem to readable String.
	 * @return String representation of GroceryItem.
	 */
	public String toString() {
		
		
		return name+": $" + String.format("%.2f",price) + " : " + (taxable?"is taxable":"tax free");
		
	}
	
	/**
	 * Getter for private member 'price'.
	 * @return price of GroceryItem.
	 */
	public double getPrice() {
		
		return price;
		
	}
	
	/**
	 * Getter for private member 'taxable'.
	 * @return whether GroceryItem is taxable or not.
	 */
	public boolean getTaxable() {
		
		return taxable;
		
	}
	
	/**
	 * Getter for private member 'name'.
	 * @return name of GroceryItem.
	 */
	public String getName() {
		
		return name;
		
	}
	
}
