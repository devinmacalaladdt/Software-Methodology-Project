package transaction;

/**
 * Representation of a Date including year, month, day and necessary methods
 * @author Devin Macalalad, David Gasperini
 */
public class Date implements Comparable<Date>{

	private int year;
	private int month;
	private int day;
	
	/**
	 * Constructor for date
	 * @param date : date represented as a '/' separated string
	 */
	public Date(String date) {
		
		//split the string into 3 seperate strings by '/', parse each for month,day,year
		String[] dates = date.split("[/]");
		if(dates.length==3) {
			
			try{month = Integer.parseInt(dates[0]);}
			catch(NumberFormatException nfe_month) {month=0;}
			try{day = Integer.parseInt(dates[1]);}
			catch(NumberFormatException nfe_day) {day=0;}
			try{year = Integer.parseInt(dates[2]);}
			catch(NumberFormatException nfe_year) {year=0000;}
			
		}
		
	}
	
	/**
	 * Compares two date objects
	 * @param date : Date object to compare to current instance
	 * @return int : 1 if If parameter is less , -1 if If parameter is greater, 0 if equal
	 */
	@Override
	public int compareTo(Date date) {
		
		boolean dateYearEqual = (date.year == year);
		boolean dateMonthEqual = (date.month == month);
		
		if(date.year > year || ((dateYearEqual) && date.month > month) 
				|| ((dateYearEqual && dateMonthEqual) && date.day > day)) {
			
			return -1;
			
		}else if(date.year < year || ((dateYearEqual) && date.month < month) 
				|| ((dateYearEqual && dateMonthEqual) && date.day < day)) {
			
			return 1;
			
		}
		
		return 0;
		
	}
	
	/**
	 * toString method for current instance of an Date
	 * @return dateString : string representation of Date, '/' separated month, day and year
	 */
	@Override
	public String toString() { 
		
		return month + "/" + day + "/" + year;
		
	}
	
	/**
	 * Validates the month, day, and year of current instance
	 * @return boolean : true if the constructed month, day and year is an actual date, false if the constructed month, day and year is not an actual date
	 */
	public boolean isValid() { 
		
		//variables to make numeric values readable
		short jan = 1, feb  = 2, mar  = 3, apr  = 4, may  = 5,jun  = 6, jul  = 7, aug  = 8, 
				sep  = 9, oct  = 10, nov  = 11, dec  = 12, lowest = 1, highest = 31, leap = 29;
		
		//initial check to make sure values are able to be dates
		if((year >= lowest) && (month >= jan && month <= dec) && (day >= lowest && day <= highest)) {
			
			boolean thirtyDayMonth = (month == apr || month == jun || month == sep || month == nov);
			boolean thirtyoneDayMonth = (month == jan || month == mar || month == may || month == jul || month == aug 
					|| month == oct || month == dec);
			boolean leapYear = (year % 4 == 0);
			
			//check if valid date for a thirty day month
			if(thirtyDayMonth && day < highest) {
				
				return true;
			
			//check if month is February and if its a valid date given leap year or not
			}else if(month == feb && ((leapYear && day < leap+1) || (!leapYear && day < leap))) {
				
				return true;
				
			}else if(thirtyoneDayMonth) {
				
				return true;
				
			}
			
			
		}
		
		return false;
		
	}
	
}
