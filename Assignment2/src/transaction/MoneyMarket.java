package transaction;

public class MoneyMarket extends Account{

	private int withdrawls;
	
	public MoneyMarket(Profile owner, double amount, Date date) {
		
		holder = owner;
		balance = amount;
		dateOpen = date;
		withdrawls = 0;
		
	}
	
	public double monthlyInterest() {
		
		return 0.0065;
		
	}
	public double monthlyFee() {
		
		return (balance >= 2500) && (withdrawls<=6) ? 0:25.00;
		
	}
	
}
