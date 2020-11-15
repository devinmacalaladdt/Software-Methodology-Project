/**
 * Order object class
 * @author Devin Macalalad, David Gasperini
 */

package application;

import java.util.ArrayList;

public class Order implements Customizable{
	
	public static int lineNumber; //reset for each new order;
	private ArrayList<OrderLine> orderlines;

	/**
	 * Add OrderLine to order
	 * @param Object to add
	 * @return true : success, false : failure
	 */
	@Override
	public boolean add(Object obj) {
		if(obj instanceof OrderLine) {
			OrderLine line = (OrderLine) obj;
			line.setLineNo(lineNumber++);
			orderlines.add(line);
			return true;
		}
		return false;
	}

	/**
	 * Removes orderline from order
	 * @param Object to find and remove
	 * @return true : success, false : failure
	 */
	@Override
	public boolean remove(Object obj) {
		if(obj instanceof OrderLine) {
			OrderLine line = (OrderLine) obj;
			int index = orderlines.indexOf(line);
			if(index < 0) return false;
			orderlines.remove(orderlines.get(index));
			return true;
		}
		return false;
	}
	
	/**
	 * accessor for orderlines
	 * @return orderline array
	 */
	public ArrayList<OrderLine> getOrderLine() {
		return orderlines;
	}
	
	/**
	 * Constructor for new order
	 */
	public Order() {
		
		orderlines = new ArrayList<OrderLine>(); 
		lineNumber = 0;
		
	}

}
