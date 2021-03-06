package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
/**
 * Controller Class to link functionality to buttons/input on GUI for orderline
 * Contains action methods and helper methods for each input source
 * @author Devin Macalalad, David Gasperini
 */
public class OrderLineController implements Initializable{
	@FXML
	private Button btnClear;
	@FXML
	private Button btnCE;
	@FXML
	private Button btnClose;
	@FXML
	private Button btnExport;
	@FXML
	private Button btnDup;
	@FXML
	private TextArea txtTotal;
	@FXML
	private ListView<String> lstMain;
	@FXML
	private AnchorPane ancpanOrderLine;
	
	private Alert alert;
	
	
	/**
	 * Hides stage on close button press
	 */
	@FXML
	private void btnClose_action() {
		Stage stage = (Stage) btnClose.getScene().getWindow();
		stage.hide();
	}
	
	/**
	 * Clears listview and order on button press
	 */
	@FXML
	private void btnClear_action() {
		total = 0.0;
		txtTotal.setText("" + total);
		order.getOrderLine().clear();
		Order.lineNumber = 0;
		updateOrder();
		
	}
	
	
	/**
	 * Clears selected entry on button press
	 */
	@FXML
	private void btnCE_action() {
		try {
			
			int row = lstMain.getSelectionModel().getSelectedIndex();
			OrderLine line = order.getOrderLine().get(row);
			total -= line.getPrice();
			setTotal();
			order.remove(line);
			Order.lineNumber = 0;
			for(int x = 0; x < order.getOrderLine().size(); x++) {
				OrderLine temp = order.getOrderLine().get(x);
				temp.setLineNo(Order.lineNumber++);
			}
			updateOrder();
			
		}catch(Exception e) {
			
			alert.setContentText("Please select a sandwich to clear");
			alert.showAndWait();
			
		}
	}
	
	/**
	 * Writes order to file on button press
	 */
	@FXML
	private void btnExport_action() {
		FileChooser fileChooser = new FileChooser();
		 fileChooser.setTitle("Save Order File");
		 fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		 File f = fileChooser.showOpenDialog(ancpanOrderLine.getScene().getWindow());
		 try{
				if(!f.exists()) {
					f.createNewFile();
				}
				BufferedWriter fout = new BufferedWriter(new FileWriter(f));
				String write = "";
				for(int x = 0; x < lstMain.getItems().size(); x++)
					write += order.getOrderLine().get(x).getSandwich().toString() + '\n';
				fout.write(write);
				fout.close();
			}
			catch(IOException ioe) {}
	}
	
	/**
	 * Duplicates selected entry on button press
	 */
	@FXML
	private void btnDup_action() {
		
		try {
			
			int row = lstMain.getSelectionModel().getSelectedIndex();
			Sandwich sandwich = order.getOrderLine().get(row).getSandwich();
			OrderLine clonewich = new OrderLine(sandwich, sandwich.price());
			order.add(clonewich);
			updateOrder();
			
		}catch(Exception e) {
			
			alert.setContentText("Please select a sandwich to duplicate");
			alert.showAndWait();
			
		}
		
	}
		
	private static double total = 0.0;
	
	/***
	 * Formats total and sets the textbox
	 */
	private void setTotal() {
		txtTotal.setText("" + String.format("%.2f", Math.abs(total)));
	}

	static Order order;
	
	/**
	 * Initializes form
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		order = SandwichController.order;
		alert = new Alert(Alert.AlertType.ERROR);
		
		updateOrder();
		
	}
	
	/**
	 * Updates the order list 
	 */
	public void updateOrder() {
		
		ObservableList<String> orders = FXCollections.observableArrayList();
		total = 0;
		
		for(int c = 0; c < order.getOrderLine().size(); c++) {
			
			orders.add(order.getOrderLine().get(c).getLineNo()+" "+order.getOrderLine().get(c).getSandwich().toString());
			total += order.getOrderLine().get(c).getSandwich().price();
			setTotal();
			
		}
		
		lstMain.getItems().clear();
		lstMain.getItems().addAll(orders);
		
	}
}