package application;


/**
 * Representation of Profile including first name, last name and necessary methods
 * @author Devin Macalalad, David Gasperini
 */
public class Profile {

	private String fname;
	private String lname;
	
	/**
	 * Constructor for profile
	 * @param fname : first name of account holder
	 * @param lname : last name of account holder
	 */
	public Profile(String fname, String lname) {
		
		this.fname = fname;
		this.lname = lname;
		
	}
	
	/**
	 * accessor for last name
	 * @return lname : last name of holder
	 * */
	public String getlname()
	{
		return lname;
	}
	
	/**
	 * accessor for last name
	 * @return fname: first name of holder
	 */
	public String getfname() {
		
		return fname;
		
	}

	/**
	 * compares two holder last names for sorting purposes in AccountDatabase
	 * @param holder : Profile to compare
	 * @return int : 1 if If parameter is less , -1 if If parameter is greater, 0 if equal
	 * */
	public int compareTo(Profile holder) {

		if(lname.toLowerCase().equals(holder.getlname().toLowerCase()))
				return 0;
		for(int x = 0; x < lname.length(); x++) {
			if(x>(holder.getlname()).length()-1) {
				
				return 1;
				
			}
			if(lname.toLowerCase().charAt(x) > holder.getlname().toLowerCase().charAt(x))
				return 1;
			else if(lname.toLowerCase().charAt(x) < holder.getlname().toLowerCase().charAt(x))
				return -1;
		}
		return -1; //checked they are not equal, hence the parameter must be a longer string and thus greater
	}
}
