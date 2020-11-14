package application;

/**
 * Class to represent an extra
 * @author Devin Macalalad, David Gasperini
 */
public class Extra {

	private String type;
	
	/**
	 * Constructor for Extra
	 * @param type/name of the extra
	 */
	public Extra(String type) {
		
		this.type = type;
		
	}
	
	/**
	 * getter for extra type
	 * @return type of the extra
	 */
	public String getType() {
		
		return type;
		
	}
	
}
