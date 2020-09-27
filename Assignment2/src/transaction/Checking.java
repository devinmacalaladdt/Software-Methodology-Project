package transaction;

public class Checking extends Account{
	
	private boolean directDeposit;
	
	public Checking(Profile holder, double balance, Date dateOpen, boolean directDeposit) {
		
		super.setHolder(holder);
		super.setBalance(balance);
		super.setDateOpen(dateOpen);
		this.directDeposit = directDeposit;
		
	}
	
	public double monthlyInterest() {
		
		return 0.0005;
		
	}
	public double monthlyFee() {
		
		return (super.getBalance() >= 1500) || (directDeposit) ? 0:25.00;
		
	}
	
	public String toString() {
		
		String dd = (directDeposit)?"*direct deposit account*":"";
		
		return "*Checking*"+(super.getHolder()).getfname()+" "+(super.getHolder()).getlname()+
				"* $"+String.format("%.2f",super.getBalance())+"*"+(super.getDate()).toString()+dd;            
		
	}

	@Override
	public boolean equals(Account account) {
		
		if(account instanceof Checking) {
			
			if(((account.getHolder()).getfname()).equals(((super.getHolder()).getfname())) && 
					((account.getHolder()).getlname()).equals(((super.getHolder()).getlname()))){
				
				return true;
				
			}
			
		}
		
		return false;
	}

}
