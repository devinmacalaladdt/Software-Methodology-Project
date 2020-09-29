package transaction;

public class AccountDatabase {
	private Account[] accounts;
	private static final int increment = 5;
	private int size;
	
	
	public AccountDatabase(int initialCapacity) {
		
		accounts = new Account[initialCapacity];
		size = 0;
		
	}
	
	/**
	 * Find the account and return its account index if found
	 * @param account : account to search for in accounts
	 * @return index : index of the match
	 * @return -1 : account not found
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
	 * @return true : account added successfully
	 * @return false : account already exists
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
	 * @return true : removed successfully
	 * @return false : account not found
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
	 * @return true : success
	 * @return false : account not found
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
	 * @return 1 : insufficient balance
	 * @return -1 : account not found
	 * @return 0 : success
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
	 * prints accounts
	 */
	public void printByDateOpen()
	{
		sortByDateOpen();
		for(Account a: accounts) {
			
			if(a!=null) {
				
				System.out.println();
				System.out.println(a.toString());
				System.out.println("-interest: $ " + String.format("%.2f",(a.monthlyInterest()*a.getBalance())/12));
				System.out.println("-fee: $ " + String.format("%.2f",a.monthlyFee()));
				a.debit(a.monthlyFee());
				a.credit((a.monthlyInterest()*a.getBalance())/12);
				System.out.println("-new balance: $ " + String.format("%.2f",a.getBalance()));
				
			}
			
		}
	}
	
	/**
	 * Sorts the account database by holder's last name
	 * prints accounts
	 */
	public void printByLastName()
	{
		sortByLastName();
		for(Account a: accounts) {
			
			if(a!=null) {
				
				System.out.println();
				System.out.println(a.toString());
				System.out.println("-interest: $ " + String.format("%.2f",(a.monthlyInterest()*a.getBalance())/12));
				System.out.println("-fee: $ " + String.format("%.2f",a.monthlyFee()));
				a.debit(a.monthlyFee());
				a.credit((a.monthlyInterest()*a.getBalance())/12);
				System.out.println("-new balance: $ " + String.format("%.2f",a.getBalance()));
				
			}
			
		}
	}
	
	/**
	 * prints accounts
	 */
	public void printAccounts()
	{
		for(Account a:accounts) {
			
			if(a!=null) {
				
				System.out.println(a.toString());
				
			}
			
		}
			
	}
	
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