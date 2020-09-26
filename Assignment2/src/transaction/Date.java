package transaction;


public class Date {

	private int year;
	private int month;
	private int day;
	
	public Date(String date) {
		
		String[] dates = date.split("[/]");
		if(dates.length==3) {
			
			month = Integer.parseInt(dates[0]);
			day = Integer.parseInt(dates[1]);
			year = Integer.parseInt(dates[2]);
			
		}
		
	}
	
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
		
	} //return 0, 1, or -1
	public String toString() { 
		
		return month+"/"+day+"/"+year;
		
	} //in the format mm/dd/yyyy
	public boolean isValid() { 
		
		if((year > 0) && (month > 0 && month < 13) && (day > 0 && day < 32)) {
			
			boolean thirtyDayMonth = (month == 4 || month == 6 || month == 9 || month == 11);
			boolean thirtyoneDayMonth = (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12);
			boolean leapYear = (year % 4 == 0);
			
			if(thirtyDayMonth && day < 31) {
				
				return true;
				
			}else if(month == 2 && ((leapYear && day < 30) || (!leapYear && day < 29))) {
				
				return true;
				
			}else if(thirtyoneDayMonth) {
				
				return true;
				
			}
			
			
		}
		
		return false;
		
	}
	
}
