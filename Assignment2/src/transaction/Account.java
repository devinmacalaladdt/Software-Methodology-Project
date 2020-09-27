package transaction;

public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	
	/**
	 * Removes amount from the holder's balance
	 * @param amount : quantity to debit
	 */
	public void debit(double amount) 
	{
		if(balance >= amount)
			balance -= amount;
	}
	
	/**
	 * Adds amount to the holder's balance
	 * @param amount : quantity to credit
	 */
	public void credit(double amount) 
	{
		if(amount > 0)
			balance += amount;
	}
	
	
	/**
	 * accessor for balance
	 * @return balance : account balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * accessor for date
	 * @return Date : date of account 
	 */
	public Date getDate() {
		return dateOpen;
	}
	
	/**
	 * accessor for holder
	 * @return Profile : holder of this account
	 */
	public Profile getHolder() {
		return holder;
	}
	
	public void setHolder(Profile holder) {
		
		this.holder = holder;
		
	}
	
	public void setBalance(double balance) {
		
		this.balance = balance;
		
	}
	
	public void setDateOpen(Date dateOpen) {
		
		this.dateOpen = dateOpen;
		
	}
	
	
	public abstract double monthlyInterest();
	public abstract double monthlyFee();
	public abstract String toString();
	public abstract boolean equals(Account account);
}
