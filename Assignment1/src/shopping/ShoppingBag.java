package shopping;


/**
 * ShoppingBag is a representation of a bag containing store items (GroceryItems).
 * It contains a GroceryItem array to represent all items, a current size, and a dynamic capacity.
 * Items can be added and removed, and the bag itself can grow in size and capacity when
 * capacity is reached.
 * @author Devin Macalalad, David Gasperini
 */

public class ShoppingBag {

	private GroceryItem[] bag;
	private int size;
	private int capacity;
	
	
	/**
	 * Constructor for a shopping bag object. Sets default values for members.
	 * @param initial capacity of the shopping bag.
	 */
	public ShoppingBag(int capacity) {
		
		bag = new GroceryItem[capacity];
		this.size = 0;
		this.capacity = capacity;	
		
	}
	
	/**
	 * Iterates through bag array searching for specified GroceryItem. Compares via 'equals' method.
	 * @param GroceryItem to be searched for in bag array.
	 * @return index of the found GroceryItem in the bag array, -1 if the item was not found.
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
	 * Creates a new bag array with an increased size by 5 and copies all current items into it.
	 * Resets bag member to point to this new array.
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
	 * Adds specified GroceryItem to the bag array by first checking if it will exceed capacity.
	 * If so, the 'grow' method is called first.
	 * @param item GroceryItem to be added to the shopping bag.
	 */
	public void add(GroceryItem item) 
	{
		if(size >= capacity)
			grow();
		bag[size] = item;
		size++;
	}
	
	/**
	 * Removes specified GroceryItem from the bag array after searching for it using the 'find' method.
	 * @param item GroceryItem to be removed from the shopping bag.
	 * @return true was able to remove the item
	 * false was unable to find the item and hence it could not be removed.
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
	 * Iterates over the bag array to sum up the prices for all items.
	 * @return summation of all prices currently in the bag array.
	 */
	public double salesPrice() {
		
		double result = 0;
		
		for(int i = 0; i<size; i++) {
			
			result += (bag[i]).getPrice();
			
		}
		
		return result;
		
	}
	
	/**
	 * Iterates over the bag array to sum up the tax amounts for each item by taking the product of
	 * the price and tax amount (0.06625).
	 * @return summation of all taxes currently in the bag array.
	 */
	public double salesTax() {
		
		double result = 0;
		double tax = 0.06625;
		
		for(int i = 0; i<size; i++) {
			
			if((bag[i]).getTaxable()) {
				
				result += (bag[i]).getPrice()*tax;
				
			}
			
		}
		
		return result;
		
	}
	
	/**
	 * Prints information for all items currently in the bag array via the 'toString' method.
	 */
	public void print() {
		
		for(int i = 0; i<size; i++) {
			
			System.out.println("· "+ (bag[i]).toString());
			
		}
		
		
	}
	
	/**
	 * Getter for the private member 'size'.
	 * @return size of the shopping bag.
	 */
	public int getSize() {
		
		return size;
		
	}


}
