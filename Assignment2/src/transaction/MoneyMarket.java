package transaction;

public class MoneyMarket extends Account{

	private int withdrawals;
	
	public MoneyMarket(Profile holder, double balance, Date dateOpen) {
		
		super.setHolder(holder);
		super.setBalance(balance);
		super.setDateOpen(dateOpen);
		withdrawals = 0;
		
	}
	
	public double monthlyInterest() {
		
		return 0.0065;
		
	}
	public double monthlyFee() {
		
		return (super.getBalance() >= 2500) && (withdrawals<=6) ? 0:12.00;
		
	}
	
	public String toString() {
		
		return "*Money Market*"+(super.getHolder()).getfname()+" "+(super.getHolder()).getlname()+
				"* $"+String.format("%,.2f",super.getBalance())+"*"+(super.getDate()).toString()+"*"+withdrawals+" withdrawals*";            
		
	}
	
	public void incrementWithdrawals() {
		
		withdrawals++;
		
	}
	
	@Override
	public boolean equals(Account account) {
		
		if(account instanceof MoneyMarket) {
			
			if(((account.getHolder()).getfname()).equals(((super.getHolder()).getfname())) && 
					((account.getHolder()).getlname()).equals(((super.getHolder()).getlname()))){
				
				return true;
				
			}
			
		}
		
		return false;
	}
	
}
