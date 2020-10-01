package transaction;


import java.util.Scanner;
import java.util.InputMismatchException;


/**
 * Class to handle incoming commands, print output, and handle any errors
 * @author Devin Macalalad, David Gasperini
 */
public class TransactionManager {

	/**
	 * Handles I/O, both accepting commands and calling necessary methods as well as
	 * printing results of them. Also handles bad input via InputMismatch and invalid commands.
	 * Continuously accepts commands until given Q command
	 */
	public void run() {
		
		System.out.println("Transaction processing starts.....");
		AccountDatabase account_db = new AccountDatabase(5);
		Scanner in = new Scanner(System.in);
		String[] line = (in.nextLine()).split("[ \t\n]");
		String[] valid_commands = {"OC","OS","OM","CC","CS","CM","DC","DS","DM","WC","WS","WM","PA","PD","PN"};
		
		
		
		while(!(line[0].equals("Q"))) {
			
			//Check for valid command
			boolean valid_command = false;
			for(String s: valid_commands) {
				
				if(line[0].equals(s)) {
					
					valid_command = true;
					
				}
				
			}
			
			if(!valid_command) {
				
				System.out.println("Command "+"\'" + line[0] + "\' not supported!");
				line = (in.nextLine()).split("[ \t\n]");
				continue;
			
			}
			
			if(line.length > 5 && !line[5].equalsIgnoreCase("true") && !line[5].equalsIgnoreCase("false")) {
				
				System.out.println("Input data type mismatch.");
				line = (in.nextLine()).split("[ \t\n]");
				continue;
				
			}
			
			if(line.length > 3) {
				
				try {
					
					Double.parseDouble(line[3]);
					
				}catch(NumberFormatException e) {
					
					System.out.println("Input data type mismatch.");
					line = (in.nextLine()).split("[ \t\n]");
					continue;
					
				}
				
			}
			
			
			switch(line[0].charAt(0)) {
			
				//Case for opening an account
				case 'O': 
					
					//Construct new date
					Date dateOpen = new Date(line[4]);
					if(!dateOpen.isValid()) {
						
						System.out.println(line[4] + " is not a valid date!");
						line = (in.nextLine()).split("[ \t\n]");
						continue;
						
					}
					
					switch(line[0].charAt(1)) {
					
						case 'C':
							
							if(!account_db.add(new Checking(new Profile(line[1],line[2]),
									Double.parseDouble(line[3]),dateOpen,Boolean.parseBoolean(line[5])))) {
								
								System.out.println("Account is already in the database.");
								line = (in.nextLine()).split("[ \t\n]");
								continue;
								
								
							}
							break;
							
						case 'S':
							
							if(!account_db.add(new Savings(new Profile(line[1],line[2]),
									Double.parseDouble(line[3]),dateOpen,Boolean.parseBoolean(line[5])))) {
								
								System.out.println("Account is already in the database.");
								line = (in.nextLine()).split("[ \t\n]");
								continue;
								
								
							}
							break;
							
						case 'M':
							
							if(!account_db.add(new MoneyMarket(new Profile(line[1],line[2]),
									Double.parseDouble(line[3]),dateOpen))) {
								
								System.out.println("Account is already in the database.");
								line = (in.nextLine()).split("[ \t\n]");
								continue;
								
								
							}
							break;
							
							
					}
					
					System.out.println("Account opened and added to the database.");
					break;
				
				//Case for closing an account
				case 'C':
					
					switch(line[0].charAt(1)) {
					
						case 'C':
							
							if(!account_db.remove(new Checking(new Profile(line[1],line[2]),0,new Date(""),false))) {
								
								System.out.println("Account does not exist.");
								line = (in.nextLine()).split("[ \t\n]");
								continue;
								
							}
							break;
							
						case 'S':
							
							if(!account_db.remove(new Savings(new Profile(line[1],line[2]),0,new Date(""),false))) {
								
								System.out.println("Account does not exist.");
								line = (in.nextLine()).split("[ \t\n]");
								continue;
								
							}
							break;
							
						case 'M':
							
							if(!account_db.remove(new MoneyMarket(new Profile(line[1],line[2]),0,new Date("")))) {
								
								System.out.println("Account does not exist.");
								line = (in.nextLine()).split("[ \t\n]");
								continue;
								
							}
							break;
						
						
					}

					System.out.println("Account closed and removed from the database.");
					break;
				
				//Case for depositing into an account
				case 'D':
					
					switch(line[0].charAt(1)) {
					
						case 'C':
							
							if(!account_db.deposit(new Checking(new Profile(line[1],line[2]),0,
									new Date(""),false),Double.parseDouble(line[3]))) {
								
								System.out.println("Account does not exist.");
								line = (in.nextLine()).split("[ \t\n]");
								continue;
								
							}
							break;
							
						case 'S':
							
							if(!account_db.deposit(new Savings(new Profile(line[1],line[2]),0,
									new Date(""),false),Double.parseDouble(line[3]))) {
								
								System.out.println("Account does not exist.");
								line = (in.nextLine()).split("[ \t\n]");
								continue;
								
							}
							break;
							
						case 'M':
							
							if(!account_db.deposit(new MoneyMarket(new Profile(line[1],line[2]),0,
									new Date("")),Double.parseDouble(line[3]))) {
								
								System.out.println("Account does not exist.");
								line = (in.nextLine()).split("[ \t\n]");
								continue;
								
							}
							break;
						
						
					}

					System.out.println(String.format("%.2f",Double.parseDouble(line[3])) + " deposited to account.");
					break;
					
				//Case for withdrawing from an account
				case 'W':
					
					switch(line[0].charAt(1)) {
					
						case 'C':
							
							int resultChecking = account_db.withdrawal(new Checking(new Profile(line[1],line[2]),
									0,new Date(""),false), Double.parseDouble(line[3]));
							if(resultChecking == 1) {
								
								System.out.println("Insufficient funds.");
								line = (in.nextLine()).split("[ \t\n]");
								continue;
								
							}else if(resultChecking == -1) {
								
								System.out.println("Account does not exist.");
								line = (in.nextLine()).split("[ \t\n]");
								continue;
								
							}
							
							break;
							
						case 'S':
							
							int resultSavings = account_db.withdrawal(new Savings(new Profile(line[1],line[2]),
									0,new Date(""),false), Double.parseDouble(line[3]));
							if(resultSavings == 1) {
								
								System.out.println("Insufficient funds.");
								line = (in.nextLine()).split("[ \t\n]");
								continue;
								
							}else if(resultSavings == -1) {
								
								System.out.println("Account does not exist.");
								line = (in.nextLine()).split("[ \t\n]");
								continue;
								
							}
							
							break;
							
						case 'M':
							
							int resultMoneyMarket = account_db.withdrawal(new MoneyMarket(new Profile(line[1],line[2]),
									0,new Date("")), Double.parseDouble(line[3]));
							if(resultMoneyMarket == 1) {
								
								System.out.println("Insufficient funds.");
								line = (in.nextLine()).split("[ \t\n]");
								continue;
								
							}else if(resultMoneyMarket == -1) {
								
								System.out.println("Account does not exist.");
								line = (in.nextLine()).split("[ \t\n]");
								continue;
								
							}
							
							break;
					
					
					}

					System.out.println(String.format("%.2f",Double.parseDouble(line[3])) + " withdrawn from account.");
					break;
					
				//Case for printing accounts
				case 'P':
					
					if(account_db.getSize() == 0) {
						
						System.out.println("Database is empty.");
						line = (in.nextLine()).split("[ \t\n]");
						continue;
						
					}
					
					switch(line[0].charAt(1)) {
					
						case 'A':
							
							System.out.println("--Listing accounts in the database--");
							account_db.printAccounts();
							System.out.println("--end of listing--");
							
							break;
							
						case 'D':
							
							System.out.println("--Printing statements by date opened--");
							account_db.printByDateOpen();;
							System.out.println("--end of printing--");
							
							break;
							
						case 'N':
							
							System.out.println("--Printing statements by last name--");
							account_db.printByLastName();
							System.out.println("--end of printing--");
							
							break;
					
					
					}
					
					break;
					
				default:
					
			
			}
			

			
			line = (in.nextLine()).split("[ \t\n]");
			
		}
		
		in.close();
		System.out.println("Transaction processing completed.");
		
	}
	
}
