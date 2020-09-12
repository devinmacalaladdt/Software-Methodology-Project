package shopping;


/**
 * 
 * @author devin
 */

public class ShoppingBag {

	private GroceryItem[] bag;
	private int size;
	private int capacity;
	
	
	/**
	 *
	 *@param
	 *@return
	 */
	
	public ShoppingBag(int capacity) {
		
		bag = new GroceryItem[capacity];
		this.size = 0;
		this.capacity = capacity;	
		
	}
	/**
	 *
	 *@param
	 *@return
	 */
	
	private int find(GroceryItem item) {return 0;}
	/**
	 *
	 *@param
	 *@return
	 */
	
	private void grow() {}
	/**
	 *
	 *@param
	 *@return
	 */
	
	public void add(GroceryItem item) {}
	/**
	 *
	 *@param
	 *@return
	 */
	
	public boolean remove(GroceryItem item) {return false;}
	/**
	 *
	 *@param
	 *@return
	 */
	
	public double salesPrice() {return 0;}
	/**
	 *
	 *@param
	 *@return
	 */
	public double salesTax() {return 0;}
	/**
	 *
	 *@param
	 *@return
	 */
	
	public void print() {}
	/**
	 *
	 *@param
	 *@return
	 */
	
	public int getSize() {
		
		return size;
		
	}
	/**
	 *
	 *@param
	 *@return
	 */
	
	public int getCapacity() {
		
		return capacity;
		
	}


}
