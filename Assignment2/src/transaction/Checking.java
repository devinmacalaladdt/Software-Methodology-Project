package transaction;


/**
 * Representation of a Checking account including if its direct deposit and necessary methods
 * extends Account class
 * @author Devin Macalalad, David Gasperini
 */
public class Checking extends Account{
	
	private boolean directDeposit;
	
	
	/**
	 * Constructor for Checking
	 * @param holder : Profile object for account holder
	 * @param balance : double representing initial balance of account
	 * @param dateOpen : Date object for account open date
	 * @param directDeposit : Boolean representing whether or not account is direct deposit
	 */
	public Checking(Profile holder, double balance, Date dateOpen, boolean directDeposit) {
		
		super(holder,balance,dateOpen);
		this.directDeposit = directDeposit;
		
	}
	
	/**
	 * accessor for monthlyInterest
	 * @return monthlyInterestChecking : monthly interest for Checking account
	 */
	@Override
	public double monthlyInterest() {
		
		double monthlyInterestChecking = 0.0005;
		return monthlyInterestChecking;
		
	}
	
	/**
	 * accessor for monthlyFee
	 * @return double : noFee if account is direct deposit or balance >= 1500, monthlyFeeSavings if otherwise
	 */
	@Override
	public double monthlyFee() {
		
		double noFeeBalance = 1500.0;
		double monthlyFeeChecking = 25.0;
		double noFee = 0.0;
		return (super.getBalance() >= noFeeBalance) || (directDeposit) ? noFee : monthlyFeeChecking;
		
	}
	
	/**
	 * toString method for current instance of an checking account
	 * @return checkingString : string with information of the account including if its direct deposit 
	 */
	@Override
	public String toString() {
		
		String dd = (directDeposit) ? "*direct deposit account*" : "";
		
		return super.toString() + dd;            
		
	}

	/**
	 * equals method to compare current instance of checking to another
	 * @param account : account to compare to the current instance
	 * @return boolean: true if checking holders are equal, false if checking holders are not equal
	 */
	@Override
	public boolean equals(Object account) {
		
		if(account instanceof Checking) {
			
			if(super.equals(account)) {
				
				return true;
				
			}
			
		}
		
		return false;
	}

}
