package shopping;
import java.util.*;


/**
 * Shopping contains the necessary functionality to handle I/O for the application. 
 * It continuously accepts commands from the console and handles them accordingly 
 * by calling relevant methods to specific commands.
 * @author Devin Macalalad, David Gasperini
 */

public class Shopping {
	
	/**
	 * Accepts input commands from console and calls helper methods accordingly until user quits.
	 * Invalid commands are handled by outputting an error message, valid commands give validation output.
	 */
	public void run() {
		
		System.out.println("Let\'s start shopping!");
		ShoppingBag bag = new ShoppingBag(5);
		Scanner in = new Scanner(System.in);
		String[] line = (in.nextLine()).split("[ \t\n]");
		
		
		while(!(line[0].equals("Q"))) {
			
			switch(line[0]) {
			
				case "A": 
					
					add(bag,line);
					break;
				
				case "R":

					remove(bag,line);
					break;
					
				case "P":
					
					print(bag);
					break;
					
				case "C":
					
					checkout(bag);
					bag = new ShoppingBag(5);
					break;
					
				default:
					
					System.out.println("Invalid command!");
					
			
			}
			
			line = (in.nextLine()).split("[ \t\n]");
			
		}
		
		if(bag.getSize()!=0) {
			
			checkout(bag);
			
		}
		
		in.close();
		System.out.println("Thanks for shopping with us!");
		
	}
	
	/**
	 * Checks out the bag by first checking for a non-empty bag, printing each item, then displaying the
	 * total of the prices and taxes and summing for the total amount paid.
	 * If the bag is empty, and error is displayed.
	 * @param shopping bag object to be checked out.
	 */
	private void checkout(ShoppingBag bag) {
		
		if(bag.getSize()==0) {
			
			System.out.println("Unable to check out, the bag is empty!");
			return;
			
		}
		
		System.out.println("**Checking out "+bag.getSize()+" item(s):");
		bag.print();
		double salesTotal = bag.salesPrice();
		double salesTax = bag.salesTax();
		double totalAmount = salesTotal+salesTax;
		System.out.println("*Sales total: $"+String.format("%.2f",salesTotal));
		System.out.println("*Sales total: $"+String.format("%.2f",salesTax));
		System.out.println("*Total amount paid: $"+String.format("%.2f",totalAmount));
		
		
	}
	
	/**
	 * Prints the bag by first checking if its non-empty, then calls the 'print' method.
	 * If the bag is empty, and error is displayed.
	 * @param shopping bag object to be printed.
	 */
	private void print(ShoppingBag bag) {
		
		if(bag.getSize()==0) {
			
			System.out.println("The bag is empty!");
			return;
			
		}
		System.out.println("**You have " + bag.getSize() + " items in the bag.");
		bag.print();
		System.out.println("**End of list");
		
	}
	
	/**
	 * Adds specified item from input to bag via the 'add' method.
	 * @param shopping bag to add to.
	 * @param input line to extract command from.
	 */
	private void add(ShoppingBag bag, String[] line) {
		
		GroceryItem item;
		if(line[3].equals("false"))
			item = new GroceryItem(line[1], Double.parseDouble(line[2]), false);
		else
			item = new GroceryItem(line[1], Double.parseDouble(line[2]), true);
		bag.add(item);
		System.out.println(line[1] + " was added to the bag.");
		
	}
	
	/**
	 * Removes specified item from the bag. If the item is not found, an error is displayed.
	 * @param shopping bag to remove item from
	 * @param input line to extract command from.
	 */
	private void remove(ShoppingBag bag, String[] line) {
		
		GroceryItem item;
		if(line[3].equals("false"))
			item = new GroceryItem(line[1], Double.parseDouble(line[2]), false);
		else
			item = new GroceryItem(line[1], Double.parseDouble(line[2]), true);
		if(!bag.remove(item))
			System.out.println("Unable to remove, this item is not in the bag.");
		else
			System.out.println(line[1] + " " + line[2] + " removed.");
		
	}
	
}
