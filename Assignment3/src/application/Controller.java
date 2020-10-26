package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;



public class Controller {
	
	AccountDatabase account_db;
	@FXML
	private TextArea display;
	@FXML
	private TextArea txtFile;
	@FXML
	private Button btnFileOpen;
	@FXML
	private TextArea txtFileOut;
	@FXML
	private Button btnFileOut;
	
	private String display_string;
	
	//deposit/withdrawal tab
	
	@FXML
	private RadioButton depowith_savings;
	@FXML
	private RadioButton depowith_checking;
	@FXML
	private RadioButton depowith_money_market;
	@FXML
	private Button deposit_button;
	@FXML
	private Button withdrawal_button;
	@FXML
	private TextField depowith_firstname;
	@FXML
	private TextField depowith_lastname;
	@FXML
	private TextField depowith_amount;
	@FXML
	private TextField txtOCFirstName;
	@FXML
	private TextField txtOCLastName;
	@FXML
	private TextField txtOCAmount;
	@FXML
	private TextField txtOCMonth;
	@FXML
	private TextField txtOCDay;
	@FXML
	private TextField txtOCYear;
	@FXML
	private RadioButton radOCSavings;
	@FXML
	private RadioButton radOCChecking;
	@FXML
	private RadioButton radOCMoneyMarket;
	@FXML
	private CheckBox chkbxOCIsLoyal;
	@FXML
	private CheckBox chkbxOCIsDirectDeposit;
	@FXML
	private Button btnOCOpen;
	@FXML
	private Button btnOCClose;

	public void deposit_action() {
		
		try {
			
			Double.parseDouble(depowith_amount.getText());
			
		}catch(NumberFormatException e) {
			
			display.appendText("Please enter a valid amount"+"\n");
			return;
			
		}
		
		if(depowith_savings.isSelected()) {

			if(!account_db.deposit(new Savings(new Profile(depowith_firstname.getText(),depowith_lastname.getText()),0,
					new Date(""),false),Double.parseDouble(depowith_amount.getText()))) {
				display.appendText("Account does not exist."+"\n");
				return;
			}
			
		}else if(depowith_checking.isSelected()) {
			
			if(!account_db.deposit(new Checking(new Profile(depowith_firstname.getText(),depowith_lastname.getText()),0,
					new Date(""),false),Double.parseDouble(depowith_amount.getText()))) {
				display.appendText("Account does not exist."+"\n");	
				return;
			}
			
		}else if (depowith_money_market.isSelected()){
			
			if(!account_db.deposit(new MoneyMarket(new Profile(depowith_firstname.getText(),depowith_lastname.getText()),0,
					new Date("")),Double.parseDouble(depowith_amount.getText()))) {
				display.appendText("Account does not exist."+"\n");
				return;
			}
			
		}else {
			
			display.appendText("Please select an account type."+"\n");
			return;
			
		}
		
		display.appendText(String.format("%.2f",Double.parseDouble(depowith_amount.getText())) + " deposited to account."+ "\n");
		
	}
	
	public void withdrawal_action() {
		
		try {
			
			Double.parseDouble(depowith_amount.getText());
			
		}catch(NumberFormatException e) {
			
			display.appendText("Please enter a valid amount"+"\n");
			return;
			
		}
		
		if(depowith_savings.isSelected()) {
			
			int resultChecking = account_db.withdrawal(new Savings(new Profile(depowith_firstname.getText(),depowith_lastname.getText()),
					0,new Date(""),false), Double.parseDouble(depowith_amount.getText()));
			if(resultChecking == 1) {
				
				display.appendText("Insufficient funds."+"\n");
				return;
				
			}else if(resultChecking == -1) {
				
				display.appendText("Account does not exist."+"\n");
				return;
				
			}
			
		}else if(depowith_checking.isSelected()) {
			
			int resultChecking = account_db.withdrawal(new Checking(new Profile(depowith_firstname.getText(),depowith_lastname.getText()),
					0,new Date(""),false), Double.parseDouble(depowith_amount.getText()));
			if(resultChecking == 1) {
				
				display.appendText("Insufficient funds."+"\n");
				return;
				
			}else if(resultChecking == -1) {
				
				display.appendText("Account does not exist."+"\n");
				return;
				
			}
			
		}else if(depowith_money_market.isSelected()) {
			
			int resultChecking = account_db.withdrawal(new MoneyMarket(new Profile(depowith_firstname.getText(),depowith_lastname.getText()),
					0,new Date("")), Double.parseDouble(depowith_amount.getText()));
			if(resultChecking == 1) {
				
				display.appendText("Insufficient funds."+"\n");
				return;
				
			}else if(resultChecking == -1) {
				
				display.appendText("Account does not exist."+"\n");
				return;
				
			}
			
		}else {
			
			display.appendText("Please select an account type."+"\n");
			return;
			
		}
		
		display.appendText(String.format("%.2f",Double.parseDouble(depowith_amount.getText())) + " withdrawn from account."+ "\n");
		
	}
	
	//open / close tab
	
	public void btnOCOpen_action() {}
	public void btnOCClose_action() {}
	public void isSavings_event(ActionEvent event)
	{
		if(radOCSavings.isArmed()) {
			chkbxOCIsDirectDeposit.setDisable(true);
			chkbxOCIsLoyal.setDisable(false);
			chkbxOCIsDirectDeposit.setSelected(false);
			chkbxOCIsLoyal.setSelected(false);
		}
	}
	public void isChecking_event(ActionEvent event)
	{
		if(radOCChecking.isArmed()) {
			chkbxOCIsDirectDeposit.setDisable(false);
			chkbxOCIsLoyal.setDisable(true);
			chkbxOCIsDirectDeposit.setSelected(false);
			chkbxOCIsLoyal.setSelected(false);
		}
	}
	public void isMoneyMarket_event(ActionEvent event)
	{
		if(radOCMoneyMarket.isArmed()) {
			chkbxOCIsDirectDeposit.setDisable(true);
			chkbxOCIsLoyal.setDisable(true);
			chkbxOCIsDirectDeposit.setSelected(false);
			chkbxOCIsLoyal.setSelected(false);
		}
	}
	
	//print/file input tab
	
	@FXML
	private Button print_accounts;
	@FXML
	private Button by_last_name;
	@FXML
	private Button by_date_open;
	
	
	public void print_accounts_action() {
		
		if(account_db.getSize() == 0) {
			
			display.appendText("Database is empty."+"\n");

			return;
			
		}
		
		display.appendText("--Listing accounts in the database--"+"\n");
		account_db.printAccounts(display);
		display.appendText("--end of listing--"+"\n");

		
	}
	
	public void by_last_name_action() {
		
		if(account_db.getSize() == 0) {
			
			display.appendText("Database is empty."+"\n");
			return;
			
		}
		
		display.appendText("--Printing statements by last name--"+"\n");
		account_db.printByLastName(display);
		display.appendText("--end of listing--"+"\n");
		
	}
	
	public void by_date_open_action() {
		
		if(account_db.getSize() == 0) {
			
			display.appendText("Database is empty."+"\n");
			return;
			
		}
		
		display.appendText("--Printing statements by date opened--"+"\n");
		account_db.printByDateOpen(display);
		display.appendText("--end of listing--"+"\n");
		
	}
	
	public void btnFileOpen_action() {
		String path = txtFile.getText();
		try{
			File f = new File(path);
			if(!f.exists()) {
				display.appendText("File not found, check the file name\n");
				return;
			}
			BufferedReader fin = new BufferedReader(new FileReader(path));
			String s;
			int line = 1;
			while((s = fin.readLine()) != null) {
				String tokens[] = s.split(",");
				if(tokens.length != 6) {
					display.appendText("Error parsing line " + line + "\n");
					continue;
				}
				Profile holder = new Profile(tokens[1], tokens[2]);
				Date date = new Date(tokens[4]);
				Double balance=0.0;
				try{balance = Double.parseDouble(tokens[3]);}
				catch(NumberFormatException nfe) {display.appendText("Error parsing double in line " + line + "\n");}
				if(tokens[0].equals("C")) {
					boolean directDeposit = Boolean.parseBoolean(tokens[5]);
					account_db.add(new Checking(holder, balance, date, directDeposit));
				}
				else if(tokens[0].equals("S")) {
					boolean isLoyal = Boolean.parseBoolean(tokens[5]);
					account_db.add(new Savings(holder, balance, date, isLoyal));
				}
				else if(tokens[0].equals("M")) {
					int withdrawals = Integer.parseInt(tokens[5]);
					MoneyMarket temp = new MoneyMarket(holder, balance, date);
					for(int x = 0; x < withdrawals; x++)
						temp.incrementWithdrawals();
					account_db.add(temp);
				}
				else {
					display.appendText("Error parsing line " + line + "\n");
				}
			}
			fin.close();
		}
		catch(IOException ioe) {
			display.appendText("IO Exception has occured, check the file name\n");
		}
		
		display.appendText("Imported File\n");
	}
	
	public void btnFileOut_action() {
		String path = txtFileOut.getText();
		try{
			File f = new File(path);
			if(!f.exists()) {
				display.appendText("File not found, creating new file.\n");
				f.createNewFile();
				return;
			}
			BufferedWriter fout = new BufferedWriter(new FileWriter(path));
			String write = account_db.formatDatabaseForStorage();
			fout.write(write);
			fout.close();
		}
		catch(IOException ioe) {
			display.appendText("IO Exception has occured, check the file name\n");
		}
		display.appendText("Exported File\n");
	}
	
	public Controller() {
		
		this.display_string = "";
		this.account_db = new AccountDatabase(5);
		
	}
	
	
}