package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;



public class Controller {
	
	AccountDatabase account_db;
	@FXML
	private TextArea display;
	private String display_string;
	@FXML
	private RadioButton savings;
	@FXML
	private RadioButton checking;
	@FXML
	private RadioButton money_market;
	
	//deposit/withdrawal tab
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

	public void deposit_action() {
		
		try {
			
			Double.parseDouble(depowith_amount.getText());
			
		}catch(NumberFormatException e) {
			
			display.appendText("Please enter a valid amount"+"\n");
			return;
			
		}
		
		if(savings.isSelected()) {

			if(!account_db.deposit(new Savings(new Profile(depowith_firstname.getText(),depowith_lastname.getText()),0,
					new Date(""),false),Double.parseDouble(depowith_amount.getText()))) {
				display.appendText("Account does not exist."+"\n");
				return;
			}
			
		}else if(checking.isSelected()) {
			
			if(!account_db.deposit(new Checking(new Profile(depowith_firstname.getText(),depowith_lastname.getText()),0,
					new Date(""),false),Double.parseDouble(depowith_amount.getText()))) {
				display.appendText("Account does not exist."+"\n");	
				return;
			}
			
		}else if (money_market.isSelected()){
			
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
		
		if(savings.isSelected()) {
			
			int resultChecking = account_db.withdrawal(new Savings(new Profile(depowith_firstname.getText(),depowith_lastname.getText()),
					0,new Date(""),false), Double.parseDouble(depowith_amount.getText()));
			if(resultChecking == 1) {
				
				display.appendText("Insufficient funds."+"\n");
				return;
				
			}else if(resultChecking == -1) {
				
				display.appendText("Account does not exist."+"\n");
				return;
				
			}
			
		}else if(checking.isSelected()) {
			
			int resultChecking = account_db.withdrawal(new Checking(new Profile(depowith_firstname.getText(),depowith_lastname.getText()),
					0,new Date(""),false), Double.parseDouble(depowith_amount.getText()));
			if(resultChecking == 1) {
				
				display.appendText("Insufficient funds."+"\n");
				return;
				
			}else if(resultChecking == -1) {
				
				display.appendText("Account does not exist."+"\n");
				return;
				
			}
			
		}else if(money_market.isSelected()) {
			
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
	
	//print/file input tab
	
	@FXML
	private Button print_accounts;
	@FXML
	private Button by_last_name;
	@FXML
	private Button by_date_open;
	
	public void print_accounts_action() {
		
		display.appendText("--Listing accounts in the database--"+"\n");
		account_db.printAccounts(display);
		display.appendText("--end of listing--"+"\n");
		
	}
	
	public void by_last_name_action() {
		
		display.appendText("--Printing statements by last name--"+"\n");
		account_db.printByLastName(display);
		display.appendText("--end of listing--"+"\n");
		
	}
	
	public void by_date_open_action() {
		
		display.appendText("--Printing statements by date opened--"+"\n");
		account_db.printByDateOpen(display);
		display.appendText("--end of listing--"+"\n");
		
	}
	
	public Controller() {
		
		this.display_string = "";
		this.account_db = new AccountDatabase(5);
//		account_db.add(new Savings(new Profile("a","b"),500,
//					new Date("1/21/2019"),false));
//		account_db.add(new Checking(new Profile("a","b"),20,
//				new Date("1/22/2019"),true));
//		account_db.add(new Savings(new Profile("c","d"),1764.56,
//				new Date("1/21/2005"),false));
//		account_db.add(new MoneyMarket(new Profile("jim","a"),9,
//				new Date("4/21/2005")));
		
	}
	
	
}
