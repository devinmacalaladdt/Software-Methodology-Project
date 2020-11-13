package application;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable{

	static final int MAX_EXTRAS = 6;
	static final double PER_EXTRA = 1.99;
	protected ArrayList<Extra> extras;
	public abstract double price();
	
	/*For purposes of tableview, object has line associated*/
	protected int lineNo = -1;
	public int getLineNo() {
		return lineNo;
	}
	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}
	
	public boolean add(Object obj) {
		
		if(obj instanceof Extra) {
			
			if(extras.size() >= MAX_EXTRAS) {
				
				return false;
				
			}
			extras.add((Extra) obj);
			
		}
		return true;
		
	}
	
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
	
	public String toString() { 
		
		return this.getClass().getName().replace("application.", "") + " Sandwich: ";
		
	}
	
}
