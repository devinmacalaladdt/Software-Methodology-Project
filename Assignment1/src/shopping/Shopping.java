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
					break;
				
				case "R":
					break;
					
				case "P":
					break;
					
				case "C":
					break;
					
				default:
					
			
			}
			
			line = (in.nextLine()).split("[ \t\n]");
			
		}
		
		if(bag.getSize()!=0) {
			
			
			
		}
		
		System.out.println("Thanks for shopping with us!");
		
	}
	
}
