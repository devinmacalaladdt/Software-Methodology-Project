package transaction;

public class Profile {

	private String fname;
	private String lname;
	
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
	
	public String getfname() {
		
		return fname;
		
	}

	/**
	 * compares two holder last names for sorting purposes in AccountDatabase
	 * @param holder : Profile to compare
	 * @return 1 : If parameter is less 
	 * @return -1 : If parameter is greater
	 * @return 0 : If equal
	 * */
	public int compareTo(Profile holder) {
		// TODO Auto-generated method stub
		if(lname.toLowerCase().equals(holder.getlname().toLowerCase()))
				return 0;
		for(int x = 0; x < lname.length(); x++) {
			if(lname.toLowerCase().charAt(x) > holder.getlname().toLowerCase().charAt(x))
				return 1;
			else if(lname.toLowerCase().charAt(x) < holder.getlname().toLowerCase().charAt(x))
				return -1;
		}
		return -1; //checked they are not equal, hence the parameter must be a longer string and thus greater
	}
}
