package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;



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
	@FXML
	private Button btnPickPathExport;
	@FXML
	private Button btnPickPathImport;

	public void deposit_action() {
		
		try {
			
			Double.parseDouble(depowith_amount.getText());
			
		}catch(NumberFormatException e) {
			
			display.appendText("Please enter a valid amount"+"\n");
			return;
			
		}
		
		if(Double.parseDouble(depowith_amount.getText())<0) {
			
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
		
		if(Double.parseDouble(depowith_amount.getText())<0) {
			
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
	/**
	 * helper method to aid in account data collection and validation
	 */
	private Account parseAccountData() {
		Profile holder;
		String firstName = txtOCFirstName.getText();
		String lastName = txtOCLastName.getText();
		if((firstName != null && !firstName.equals("")) && (lastName != null && !lastName.equals("")))
			holder = new Profile(firstName, lastName);
		else {
			display.appendText("Please enter your first and last name.\n");
			return null;
		}
		String strAmount = txtOCAmount.getText();
		double amount;
		if(strAmount != null && !strAmount.equals("")) {
			try {amount = Double.parseDouble(strAmount);}
			catch (NumberFormatException nfe) {
				display.appendText("An exception has occured while reading the amount.\n");
				return null;
			}
		}
		else {
			display.appendText("Please ensure the amount is correct.\n");
			return null;
		}
		Date date;
		String month = txtOCMonth.getText(), day = txtOCDay.getText(), year = txtOCYear.getText();
		if(month != null && day != null && year != null && !month.equals("") && !day.equals("") && !year.equals("") &&
				month.length() < 3 && day.length() < 3 && year.length() < 5)
			date = new Date(month+'/'+day+'/'+year);
		else {
			display.appendText("Please ensure the date is correct.\n");
			return null;
		}
		if(!date.isValid()) {
			display.appendText("Please ensure the date is correct.\n");
			return null;
		}
		Account temp = new MoneyMarket(holder, amount, date); //can't instantiate a generic account so use this to pass the data to the caller
		return temp;
	}
	/**
	 * attempts to add a new account, or states the account already exists
	 */
	public void btnOCOpen_action() 
	{
		int length = account_db.getSize();
		if(radOCSavings.isSelected()) {
			boolean loyal = chkbxOCIsLoyal.isSelected();
			Account temp = parseAccountData();
			if(temp == null)
				return; //error messages handled in callee
			Savings account = new Savings(temp.getHolder(), temp.getBalance(), temp.getDate(), loyal);
			this.account_db.add(account);
			if(account_db.getSize() > length)
				display.appendText("Successfully added the savings account.\n");
			else
				display.appendText("Account already added, nothing to do.\n");
		}
		else if(radOCChecking.isSelected()) {
			boolean directDeposit = chkbxOCIsDirectDeposit.isSelected();
			Account temp = parseAccountData();
			if(temp == null)
				return; //error messages handled in callee
			Checking account = new Checking(temp.getHolder(), temp.getBalance(), temp.getDate(), directDeposit);
			this.account_db.add(account);
			if(account_db.getSize() > length)
				display.appendText("Successfully added the checking account.\n");
			else
				display.appendText("Account already added, nothing to do.\n");
		}
		else if(radOCMoneyMarket.isSelected()) {
			MoneyMarket account = (MoneyMarket) parseAccountData();
			if(account == null)
				return; //error messages handled in callee
			this.account_db.add(account);
			if(account_db.getSize() > length)
				display.appendText("Successfully added the money market account.\n");
			else
				display.appendText("Account already added, nothing to do.\n");
		}
		else {
			display.appendText("Please select an account type and try again.\n");
		}
	}
	/**
	 * searches for and terminates the given account
	 */
	public void btnOCClose_action() 
	{
		Account temp = parseAccountData();
		if(temp == null) return; //handled by callee
		Account account;
		if(radOCSavings.isSelected()) {
			account = new Savings(temp.getHolder(), temp.getBalance(), temp.getDate(), chkbxOCIsLoyal.isSelected());
		}
		else if(radOCChecking.isSelected()) {
			account = new Checking(temp.getHolder(), temp.getBalance(), temp.getDate(), chkbxOCIsDirectDeposit.isSelected());
		}
		else if(radOCMoneyMarket.isSelected()) {
			account = temp; //already money market
		}
		else {
			display.appendText("Please select an account type.\n");
			return;
		}
		if(account_db.remove(account)) {
			display.appendText("Account successfully deleted.\n");
		}
		else {
			display.appendText("Account not found.\n");
		}
	}
	/**
	 * toggle changes to checkboxes based on radio button account type selected
	 */
	public void isSavings_event(ActionEvent event)
	{
		if(radOCSavings.isArmed()) {
			chkbxOCIsDirectDeposit.setDisable(true);
			chkbxOCIsLoyal.setDisable(false);
			chkbxOCIsDirectDeposit.setSelected(false);
			chkbxOCIsLoyal.setSelected(false);
		}
	}
	/**
	 * toggle changes to checkboxes based on radio button account type selected
	 */
	public void isChecking_event(ActionEvent event)
	{
		if(radOCChecking.isArmed()) {
			chkbxOCIsDirectDeposit.setDisable(false);
			chkbxOCIsLoyal.setDisable(true);
			chkbxOCIsDirectDeposit.setSelected(false);
			chkbxOCIsLoyal.setSelected(false);
		}
	}
	/**
	 * toggle changes to checkboxes based on radio button account type selected
	 */
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
	
	@FXML
	private AnchorPane ancpanInOut;
	/**
	 * Opens a file explorer to aid in typing the path
	 */
	public void btnPickPathExport_action() {
		 FileChooser fileChooser = new FileChooser();
		 fileChooser.setTitle("Open Resource File");
		 fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		 File temp = fileChooser.showOpenDialog(ancpanInOut.getScene().getWindow());
		 String path;
		 if(temp == null) path = "";
		 else path = temp.getPath();
		 txtFileOut.setText("" + path);
	}
	/**
	 * Opens a file explorer to aid in typing the path
	 */
	public void btnPickPathImport_action() {
		 FileChooser fileChooser = new FileChooser();
		 fileChooser.setTitle("Open Resource File");
		 fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		 File temp = fileChooser.showOpenDialog(ancpanInOut.getScene().getWindow());
		 String path;
		 if(temp == null) path = "";
		 else path = temp.getPath();
		 txtFile.setText("" + path);
	}
	/**
	 * Action when pressing import file; handles file IO
	 */
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
	/**
	 * Action when pressing export file; handles file IO
	 */
	public void btnFileOut_action() {
		String path = txtFileOut.getText();
		try{
			File f = new File(path);
			if(!f.exists()) {
				display.appendText("File not found, creating new file.\n");
				f.createNewFile();
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
		
		this.account_db = new AccountDatabase(5);
		
	}
	
	
}