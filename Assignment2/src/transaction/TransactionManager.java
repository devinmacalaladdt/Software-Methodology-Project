package transaction;

import java.util.StringTokenizer;
import java.util.Scanner;


public class TransactionManager {

	public void run() {
		
		System.out.println("Transaction processing starts.....");
		AccountDatabase account_db = new AccountDatabase(5);
		Scanner in = new Scanner(System.in);
		String[] line = (in.nextLine()).split("[ \t\n]");
		String[] valid_commands = {"OC","OS","OM","CC","CS","CM","DC","DS","DM","WC","WS","WM","PA","PD","PN"};
		
		
		while(!(line[0].equals("Q"))) {
			
			boolean valid_command = false;
			for(String s: valid_commands) {
				
				valid_command = s.equals(line[0]);
				
			}
			
			if(!valid_command) {
				
				System.out.println("Command "+"\'"+line[0]+"\' not supported!");
				line = (in.nextLine()).split("[ \t\n]");
				continue;
			
			}
			
			try {
			
				switch(line[0].charAt(0)) {
				
					case 'O': 
						
						Date date = new Date(line[4]);
						if(!date.isValid()) {
							
							System.out.println(line[4]+" is not a valid date!");
							line = (in.nextLine()).split("[ \t\n]");
							continue;
							
						}
						
						Profile owner = new Profile(line[1],line[2]);
						
						switch(line[0].charAt(1)) {
						
							case 'C':
								
								
								break;
								
							case 'S':
								
								
								break;
								
							case 'M':
								
								
								break;
								
								
						}
						
	
						break;
					
					case 'C':
						
						switch(line[0].charAt(1)) {
						
							case 'C':
								
								
								break;
								
							case 'S':
								
								
								break;
								
							case 'M':
								
								
								break;
							
							
						}
	
	
						break;
						
					case 'D':
						
						switch(line[0].charAt(1)) {
						
							case 'C':
								
								
								break;
								
							case 'S':
								
								
								break;
								
							case 'M':
								
								
								break;
						
						
						}
	
						break;
						
					case 'W':
						
						switch(line[0].charAt(1)) {
						
							case 'C':
								
								
								break;
								
							case 'S':
								
								
								break;
								
							case 'M':
								
								
								break;
						
						
						}
	
						break;
						
					case 'P':
						
						switch(line[0].charAt(1)) {
						
							case 'A':
								
								
								break;
								
							case 'D':
								
								
								break;
								
							case 'N':
								
								
								break;
						
						
						}
						
						break;
						
					default:
						
				
				}
			
			}catch(Exception e) {
				
				
				
			}
			
			line = (in.nextLine()).split("[ \t\n]");
			
		}
		
		in.close();
		System.out.println("Transaction processing completed.");
		
	}
	
}
