package transaction;


/**
 * Representation of a Savings account including if its loyal and necessary methods
 * extends Account class
 * @author Devin Macalalad, David Gasperini
 */
public class Savings extends Account{

	private boolean isLoyal;
	
	
	/**
	 * Constructor for Savings
	 * @param holder : Profile object for account holder
	 * @param balance : double representing initial balance of account
	 * @param dateOpen : Date object for account open date
	 * @param isLoyal : Boolean representing whether or not account is loyal
	 */
	public Savings(Profile holder, double balance, Date dateOpen, boolean isLoyal) {
		
		super(holder,balance,dateOpen);
		this.isLoyal = isLoyal;
		
	}
	
	/**
	 * accessor for monthlyInterest
	 * @return double : loyalInterest if account is loyal, regularInterest if otherwise
	 */
	@Override
	public double monthlyInterest() {
		
		double loyalInterest = 0.0035;
		double monthlyInterestSavings = 0.0025;
		
		return (isLoyal) ? loyalInterest : monthlyInterestSavings;
		
	}
	
	/**
	 * accessor for monthlyFee
	 * @return double : noFee if balance >= 300, monthlyFeeSavings if otherwise
	 */
	@Override
	public double monthlyFee() {
		
		double monthlyFeeSavings = 5.0;
		double noFeeBalance = 300.0;
		double noFee = 0.0;
		return (super.getBalance() >= noFeeBalance) ? noFee : monthlyFeeSavings;
		
	}
	
	
	/**
	 * toString method for current instance of an savings account
	 * @return savingsString : string with information of the account including if its loyal 
	 */
	@Override
	public String toString() {
		
		String loyal = (isLoyal) ? "*special Savings account*" : "";
		
		return super.toString() + loyal;            
		
	}
	

	/**
	 * equals method to compare current instance of savings to another
	 * @param account : account to compare to the current instance
	 * @return boolean : true if checking holders are equal, false if checking holders are not equal
	 */
	@Override
	public boolean equals(Object account) {
		
		if(account instanceof Savings) {
			
			if(super.equals(account)) {
				
				return true;
				
			}
			
		}
		
		return false;
	}
	
}
