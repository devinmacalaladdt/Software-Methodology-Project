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
	
	public Controller() {
		
		this.display_string = "";
		this.account_db = new AccountDatabase(5);
		
	}
	
	
}
