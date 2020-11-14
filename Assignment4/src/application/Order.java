package application;

import java.util.ArrayList;

public class Order implements Customizable{
	
	public static int lineNumber; //reset for each new order;
	private ArrayList<OrderLine> orderlines;

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
	
	public ArrayList<OrderLine> getOrderLine() {
		return orderlines;
	}
	
	public Order() {
		
		orderlines = new ArrayList<OrderLine>(); 
		lineNumber = 0;
		
	}

}
