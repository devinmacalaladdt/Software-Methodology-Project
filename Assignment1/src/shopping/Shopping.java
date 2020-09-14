package shopping;
import java.util.*;


/**
 * 
 * @author devin
 */

public class Shopping {
	
	/**
	 *
	 *@param
	 *@return
	 */
	
	public void run() {
		
		System.out.println("Let\'s start shopping!");
		ShoppingBag bag = new ShoppingBag(5);
		Scanner in = new Scanner(System.in);
		String[] line = (in.nextLine()).split("[ \t\n]");
		
		
		while(!(line[0].equals("Q"))) {
			
			switch(line[0]) {
			
				case "A": 
					if(line.length > 3) {
					GroceryItem item;
					if(line[3].equals("false"))
						item = new GroceryItem(line[1], Double.parseDouble(line[2]), false);
					else
						item = new GroceryItem(line[1], Double.parseDouble(line[2]), true);
					bag.add(item);
					System.out.println(line[1] + " was added to the bag.");
					}
					break;
				
				case "R":
					if(line.length > 3) {
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
					break;
					
				case "P":
					
					print(bag);
					break;
					
				case "C":
					
					checkout(bag);
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
	
	private void print(ShoppingBag bag) {
		
		if(bag.getSize()==0) {
			
			System.out.println("The bag is empty!");
			return;
			
		}
		System.out.println("**You have " + bag.getSize() + " items in the bag.");
		bag.print();
		System.out.println("**End of list");
		
	}
	
}
