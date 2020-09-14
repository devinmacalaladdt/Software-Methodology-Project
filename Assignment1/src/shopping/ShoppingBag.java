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
	
	private void grow()
	{
		GroceryItem[] biggerBag = new GroceryItem[bag.length+5];
		for(int x = 0; x < size; x++)
			biggerBag[x] = bag[x];
		bag = biggerBag;
		capacity = biggerBag.length;
	}
	/**
	 *
	 *@param item GroceryItem to be added to the shopping bag
	 *@return
	 */
	
	public void add(GroceryItem item) 
	{
		if(size >= capacity)
			grow();
		bag[size] = item;
		size++;
	}
	/**
	 *
	 *@param item GroceryItem to be removed from the shopping bag
	 *@return true was able to remove the item
	 *@return false was unable to find the item and hence it could not be removed
	 */
	
	public boolean remove(GroceryItem item)
	{
		int index = find(item);
		if(index != -1) {
			bag[index]=bag[size-1];
			bag[size-1] = null;
			size--;
			
			/*if statement to check size vs capacity and shrink here if necessary*/
			
			return true;
		}
		return false;
	}
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
		
		for(int i = 0; i<size; i++) {
			
			System.out.println("· "+ (bag[i]).toString());
			
		}
		
		
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
