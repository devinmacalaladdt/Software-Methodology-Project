package transaction;

public class Savings extends Account{

	private boolean isLoyal;
	
	public Savings(Profile holder, double balance, Date dateOpen, boolean isLoyal) {
		
		super.setHolder(holder);
		super.setBalance(balance);
		super.setDateOpen(dateOpen);
		this.isLoyal = isLoyal;
		
	}
	
	public double monthlyInterest() {
		
		return (isLoyal) ? 0.0035:0.0025;
		
	}
	public double monthlyFee() {
		
		return (super.getBalance() >= 300) ? 0:5.00;
		
	}
	
	public String toString() {
		
		String loyal = (isLoyal)?"*special Savings account*":"";
		
		return "*Savings*"+(super.getHolder()).getfname()+" "+(super.getHolder()).getlname()+
				"* $"+String.format("%,.2f",super.getBalance())+"*"+(super.getDate()).toString()+loyal;            
		
	}
	
	@Override
	public boolean equals(Account account) {
		
		if(account instanceof Savings) {
			
			if(((account.getHolder()).getfname()).equals(((super.getHolder()).getfname())) && 
					((account.getHolder()).getlname()).equals(((super.getHolder()).getlname()))){
				
				return true;
				
			}
			
		}
		
		return false;
	}
	
}
