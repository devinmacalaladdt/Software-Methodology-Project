package transaction;


/**
 * Representation of a Money Market account including the number of withdrawals and necessary methods
 * extends Account class
 * @author Devin Macalalad, David Gasperini
 */
public class MoneyMarket extends Account{

	private int withdrawals;
	
	/**
	 * Constructor for MoneyMarket
	 * @param holder : Profile object for account holder
	 * @param balance : double representing initial balance of account
	 * @param dateOpen : Date object for account open date
	 */
	public MoneyMarket(Profile holder, double balance, Date dateOpen) {
		
		super(holder,balance,dateOpen);
		withdrawals = 0;
		
	}
	
	/**
	 * accessor for monthlyInterest
	 * @return monthlyInterestMoneyMarket : monthly interest for MoneyMarket account
	 */
	@Override
	public double monthlyInterest() {
		
		double monthlyInterestMoneyMarket = 0.0065;
		return monthlyInterestMoneyMarket;
		
	}
	
	/**
	 * accessor for monthlyFee
	 * @return double : noFee if balance >= 2500 and withdrawals <= 6, monthlyFeeMoneyMarket if otherwise
	 */
	@Override
	public double monthlyFee() {
		
		double monthlyFeeMoneyMarket = 12.0;
		double noFeeBalance = 2500.0;
		double noFee = 0.0;
		int noFeeMaxWithdrawals = 6;
		
		return (super.getBalance() >= noFeeBalance) && (withdrawals<=noFeeMaxWithdrawals) ? noFee : monthlyFeeMoneyMarket;
		
	}
	
	/**
	 * toString method for current instance of an money market account
	 * @return moneyMarketString : string with information of the account including number of withdrawals 
	 */
	@Override
	public String toString() {
		
		return super.toString() + "*" + withdrawals + " withdrawals*";            
		
	}
	
	/**
	 * increments number of withdrawals
	 */
	public void incrementWithdrawals() {
		
		withdrawals++;
		
	}
	
	/**
	 * equals method to compare current instance of money market to another
	 * @param account : account to compare to the current instance
	 * @return boolean : true if checking holders are equal, false if checking holders are not equal
	 */
	@Override
	public boolean equals(Object account) {
		
		if(account instanceof MoneyMarket) {
			
			if(super.equals(account)) {
				
				return true;
				
			}
			
		}
		
		return false;
	}
	
}
