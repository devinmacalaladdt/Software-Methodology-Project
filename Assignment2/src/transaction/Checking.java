package transaction;

public class Checking extends Account{
	
	private boolean directDeposit;
	
	public Checking(Profile owner, double amount, Date date, boolean directDeposit) {
		
		holder = owner;
		balance = amount;
		dateOpen = date;
		this.directDeposit = directDeposit;
		
	}
	
	public double monthlyInterest() {
		
		return 0.0005;
		
	}
	public double monthlyFee() {
		
		return (balance >= 1500) || (directDeposit) ? 0:25.00;
		
	}

}
