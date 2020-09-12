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
	
	private int find(GroceryItem item) {
		
		for(int i = 0; i<size;i++) {
			
			if((bag[i]).equals(item)) {
				
				return i;
				
			}
			
		}
		
		return -1;
		
	}
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
	
	public double salesPrice() {
		
		double result = 0;
		
		for(int i = 0; i<size; i++) {
			
			result += (bag[i]).getPrice();
			
		}
		
		return result;
		
	}
	/**
	 *
	 *@param
	 *@return
	 */
	public double salesTax() {
		
		double result = 0;
		
		for(int i = 0; i<size; i++) {
			
			if((bag[i]).getTaxable()) {
				
				result += (bag[i]).getPrice()*0.06625;
				
			}
			
		}
		
		return result;
		
	}
	/**
	 *
	 *@param
	 *@return
	 */
	
	public void print() {
		
		System.out.println("**You have 3 items in the bag.");
		
		for(int i = 0; i<size; i++) {
			
			System.out.println("· "+ (bag[i]).toString());
			
		}
		
		System.out.println("**End of list");
		
	}
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
