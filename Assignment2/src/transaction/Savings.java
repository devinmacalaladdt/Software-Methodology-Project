package transaction;

public class Savings extends Account{

	private boolean isLoyal;
	
	public Savings(Profile owner, double amount, Date date, boolean isLoyal) {
		
		holder = owner;
		balance = amount;
		dateOpen = date;
		this.isLoyal = isLoyal;
		
	}
	
	public double monthlyInterest() {
		
		return (isLoyal) ? 0.0035:0.0025;
		
	}
	public double monthlyFee() {
		
		return (balance >= 300) ? 0:5.00;
		
	}
	
}
