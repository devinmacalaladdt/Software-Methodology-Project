package transaction;

/**
 * Representation for an Account including holder, balance, open date and necessary methods
 * @author Devin Macalalad, David Gasperini
 */
public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	/**
	 * Constructor for Account
	 * @param holder : Profile of the account holder
	 * @param balance : initial balance of the account
	 * @param dateOpen : Date that account was opened
	 */
	public Account(Profile holder, double balance, Date dateOpen) {
		
		this.holder = holder;
		this.balance = balance;
		if(balance < 0)
			this.balance = 0;
		this.dateOpen = dateOpen;
		
	}
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
	
	
	
	/**
	 * toString method for current instance of an account
	 * @return accountString : string with information of the account including type, holder, balance and date opened
	 */
	@Override
	public String toString() {
		
		return "*" + this.getClass().getSimpleName() + "*" + holder.getfname() + " " + holder.getlname() + 
				"* $" + String.format("%,.2f",balance) + "*" + dateOpen.toString();
		
	}
	
	/**
	 * equals method to compare current instance of account to another
	 * @param account : account to compare to the current instance
	 * @return boolean : true if account holders are equal, false if account holders are not equal
	 */
	@Override
	public boolean equals(Object account) {
		
		if(((((Account)account).getHolder()).getfname()).equals((holder.getfname())) && 
				((((Account)account).getHolder()).getlname()).equals((holder.getlname()))){
			
			return true;
			
		}
		
		return false;
		
	}
	
	
	public abstract double monthlyInterest();
	public abstract double monthlyFee();
}
