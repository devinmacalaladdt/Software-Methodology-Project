package application;

import java.util.ArrayList;

/**
 * Class to represent a sandwich and methods to edit and represent it
 * @author Devin Macalalad, David Gasperini
 */
public abstract class Sandwich implements Customizable{

	static final int MAX_EXTRAS = 6;
	static final double PER_EXTRA = 1.99;
	protected ArrayList<Extra> extras;
	public abstract double price();
	
	/**
	 * Adds specified extra to extras list
	 * @return true if added correctly, false otherwise
	 */
	public boolean add(Object obj) {
		
		if(obj instanceof Extra) {
			
			if(extras.size() >= MAX_EXTRAS) {
				
				return false;
				
			}
			extras.add((Extra) obj);
			
		}
		return true;
		
	}
	
	/**
	 * Removes specified extra from extras list
	 * @return true if removed correctly, false otherwise
	 */
	public boolean remove(Object obj) {
		
		if(obj instanceof Extra) {
			
			for(int c = 0; c < extras.size(); c++) {
				
				if((extras.get(c).getType()).equals(((Extra)obj).getType())) {
					
					extras.remove(c);
					return true;
					
				}
				
			}
			
		}
		return false;
		
	}
	
	/**
	 * Method to construct string to represent a sandwich
	 * @return string representation of a sandwich
	 */
	public String toString() { 
		
		return this.getClass().getName().replace("application.", "") + " Sandwich: ";
		
	}
	
}
