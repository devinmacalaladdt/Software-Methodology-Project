package application;

import javafx.scene.control.TextArea;

/**
 * Representation of an Account Database including list of accounts, increment value, size and necessary methods
 * @author Devin Macalalad, David Gasperini
 */
public class AccountDatabase {
	private Account[] accounts;
	private static final int increment = 5;
	private int size;
	
	
	/**
	 * Constructor for Account Database
	 * @param initialCapacity : initial capacity of accounts list
	 */
	public AccountDatabase(int initialCapacity) {
		
		accounts = new Account[initialCapacity];
		size = 0;
		
	}
	
	/**
	 * Find the account and return its account index if found
	 * @param account : account to search for in accounts
	 * @return int : index if index of the match, -1 if account not found
	 */
	private int find(Account account) 
	{
		for(int i = 0; i<size; i++) {	
			if((accounts[i]).equals(account)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Grows the array linearly by a constant increment
	 */
	private void grow()
	{
		Account[] biggerAccounts = new Account[accounts.length+increment];
		for(int x = 0; x < size; x++)
			biggerAccounts[x] = accounts[x];
		accounts = biggerAccounts;
	}
	
	/**
	 * Add a new account to the database
	 * @param account : adds a new account to the database
	 * @return boolean : true if account added successfully, false if account already exists
	 */
	public boolean add(Account account)
	{
		if(size >= accounts.length)
			grow();
		if(find(account) != -1)
			return false;
		accounts[size] = account;
		size++;
		return true;
	}
	
	/**
	 * removes an account from the database
	 * @param account : account to remove
	 * @return boolean : true if removed successfully, false if account not found
	 */
	public boolean remove(Account account)
	{
		int index = find(account);
		if(index != -1) {
			accounts[index] = accounts[size-1];
			accounts[size-1] = null;
			size--;
			
			/*if statement to check size vs capacity and shrink here if necessary*/
			
			return true;
		}
		return false;
	}
	
	/**
	 * deposit funds to account
	 * @param account : account to deposit into
	 * @param amount : quantity to deposit
	 * @return boolean : true if success, false if account not found
	 */
	public boolean deposit(Account account, double amount) 
	{
		int accountno = find(account);
		if(accountno == -1 || amount <= 0)
			return false;
		accounts[accountno].credit(amount);
		return true;
	}
	
	/**
	 * withdrawal funds from account 
	 * @param account : account to withdrawal from
	 * @param amount : quantity to withdrawal
	 * @return int : 1 if insufficient balance, -1 if account not found, 0 if success
	 */
	public int withdrawal(Account account, double amount)
	{
		int accountno = find(account);
		if(accountno == -1)
			return -1;
		if(accounts[accountno].getBalance() < amount)
			return 1;
		accounts[accountno].debit(amount);
		if(account instanceof MoneyMarket) {
			
			((MoneyMarket)(accounts[accountno])).incrementWithdrawals();
			
		}
		return 0;
	}
	
	/**
	 * Sorts the account database by date opened
	 */
	private void sortByDateOpen()
	{
		bubbleSort(true);
	}
	
	/**
	 * Sorts the account database by holder's last name
	 */
	private void sortByLastName()
	{
		bubbleSort(false);
	}
	
	/**
	 * Sorts the account database by date opened
	 * prints accounts and relevant information, then changes balance according to fee and interest
	 */
	public void printByDateOpen(TextArea display)
	{
		sortByDateOpen();
		for(Account a: accounts) {
			
			if(a != null) {
				
				display.appendText("\n");
				display.appendText(a.toString()+"\n");
				display.appendText("-interest: $ " + String.format("%,.2f",(a.monthlyInterest()*a.getBalance())/12)+"\n");
				display.appendText("-fee: $ " + String.format("%,.2f",a.monthlyFee())+"\n");
				double lastBalance = a.getBalance();
				a.debit(a.monthlyFee());
				a.credit((a.monthlyInterest()*lastBalance)/12.00);
				display.appendText("-new balance: $ " + String.format("%,.2f",a.getBalance())+"\n");
				
			}
			
		}
	}
	
	/**
	 * Sorts the account database by holder's last name
	 * prints accounts and relevant information, then changes balance according to fee and interest
	 */
	public void printByLastName(TextArea display)
	{
		sortByLastName();
		for(Account a: accounts) {
			
			if(a != null) {
				
				display.appendText("\n");
				display.appendText(a.toString()+"\n");
				display.appendText("-interest: $ " + String.format("%,.2f",(a.monthlyInterest()*a.getBalance())/12)+"\n");
				display.appendText("-fee: $ " + String.format("%,.2f",a.monthlyFee())+"\n");
				double lastBalance = a.getBalance();
				a.debit(a.monthlyFee());
				a.credit((a.monthlyInterest()*lastBalance)/12.00);
				display.appendText("-new balance: $ " + String.format("%,.2f",a.getBalance())+"\n");
				
			}
			
		}
	}
	
	/**
	 * prints accounts
	 */
	public void printAccounts(TextArea display)
	{
		for(Account a:accounts) {
			
			if(a != null) {
				
				display.appendText(a.toString()+"\n");
				
			}
			
		}
			
	}
	
	/**
	 * accessor for size
	 * @return size : size of list of accounts
	 */
	public int getSize() {
		
		return size;
		
	}
	
	/**
	 * Helper method to perform the sorting for sortByDate and sortByLastName
	 * @param byDate : if true sorts by date opened, if false sorts by holders last name
	 */
	private void bubbleSort(boolean byDate)
    {
		if(accounts == null) return;
         boolean isSorted = false;
         while(isSorted == false)
         {
             isSorted = true;
             for(int x = 0; x < size - 1; x++)
             {
                 if((byDate && accounts[x].getDate().compareTo(accounts[x + 1].getDate()) > 0) || 
                		 (!byDate && accounts[x].getHolder().compareTo(accounts[x + 1].getHolder()) > 0)){
                     Account temp = accounts[x + 1];
                     accounts[x + 1] = accounts[x];
                     accounts[x] = temp;
                     isSorted = false;
                 }
             }
         }
    }
}