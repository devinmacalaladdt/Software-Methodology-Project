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
	 * @return false was unable to find the item and hence it could not be removed.
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

	/** Testbed main method designed to test the methods included in this class */
	public static void main(String[] args) {
		final int sampleSize = 100;
		System.out.println("Initialize bags at capacity " + sampleSize);
		ShoppingBag bag1 = new ShoppingBag((int) ((Math.random()*(sampleSize/2))+1));
		ShoppingBag bag2 = new ShoppingBag((int) ((Math.random()*(sampleSize/2))+1));
		ShoppingBag bag3 = new ShoppingBag((int) ((Math.random()*(sampleSize/2))+1));
		
		System.out.println("Sequential Add");
		for(int x = 0; x < sampleSize; x++) {
			GroceryItem item = new GroceryItem("test_item"+x, x, (x%2==1));
			bag1.add(item);
			bag2.add(item);
			bag3.add(item);
		}
		
		System.out.println("Find test:");
		boolean failed = false;
		for(int x = 0; x < sampleSize; x+=5) {
			GroceryItem item = new GroceryItem("test_item"+x, x, (x%2==1));
			if(bag1.find(item) == -1) {
				failed = true;
				System.out.println("Find failed to find " + item + " in bag1");}
			if(bag2.find(item) == -1) {
				failed = true;
				System.out.println("Find failed to find " + item + " in bag2");}
			if(bag3.find(item) == -1) {
				failed = true;
				System.out.println("Find failed to find " + item + " in bag3");}
		}
		if(!failed) System.out.println("[Passed]");
		
		System.out.println("Size check:");
		if(bag1.getSize() != sampleSize) System.out.println("Size test failed for bag1");
		if(bag2.getSize() != sampleSize) System.out.println("Size test failed for bag2");
		if(bag3.getSize() != sampleSize) System.out.println("Size test failed for bag3");
		if(bag1.getSize() == sampleSize && bag2.getSize() == sampleSize && bag3.getSize() == sampleSize) System.out.println("[Passed]");
		
		
		System.out.println("bag1: " + "sales tax - " + Math.round(bag1.salesTax()*100.0)/100.0 + "  sales price - " + Math.round((bag1.salesPrice())*100.0)/100.0);
		System.out.println("bag2: " + "sales tax - " + Math.round(bag2.salesTax()*100.0)/100.0 + "  sales price - " + Math.round((bag2.salesPrice())*100.0)/100.0);
		System.out.println("bag3: " + "sales tax - " + Math.round(bag3.salesTax()*100.0)/100.0 + "  sales price - " + Math.round((bag3.salesPrice())*100.0)/100.0);
		double price = 0, tax = 0;
		for(int x = 0; x < sampleSize; x++) {
			price += x;
			if(x % 2 == 1)
				tax += 0.06625*x;
		}
		System.out.println("Expected tax: " + Math.round(tax*100.0)/100.0 + "  Expected price: " + Math.round((price)*100.0)/100.0);
		
		System.out.println("Sequential remove front to back (bag1)");
		for(int x = 0; x < sampleSize; x++) {
			GroceryItem item = new GroceryItem("test_item"+x, x, (x%2==1));
			bag1.remove(item);
		}
		
		System.out.println("Sequential remove back to front (bag2)");
		for(int x = sampleSize-1; x >= 0; x--) {
			GroceryItem item = new GroceryItem("test_item"+x, x, (x%2==1));
			bag2.remove(item);
		}
		
		System.out.println("Random remove (bag3)");
		for(int x = 0; x < sampleSize*2; x++) {
			int rand = (int) ((Math.random()*(sampleSize-1))+1);
			GroceryItem item = new GroceryItem("test_item"+rand, rand, (rand%2==1));
			bag3.remove(item);
		}
		
		System.out.println("bag1 contents: ");
		bag1.print();
		System.out.println("bag2 contents: ");
		bag2.print();
		System.out.println("bag3 contents: ");
		bag3.print();
	}

}
