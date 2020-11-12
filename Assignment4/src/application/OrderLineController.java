package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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
	private TableColumn tblcolQuantity;
	@FXML
	private TableColumn tblcolSandwich;
	@FXML
	private TableColumn tblcolExtras;
	@FXML
	private TableColumn tblcolTotal;
	@FXML
	private TableView tblMain;
	
	@FXML
	private void btnClose_action() {
		Stage stage = (Stage) btnClose.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	private void btnClear_action() {
		tblMain.getItems().clear();
		total = 0.0;
		txtTotal.setText("" + total);
		lineNumber = 0;
	}
	
	@FXML
	private void btnCE_action() {
		TablePosition pos = (TablePosition) tblMain.getSelectionModel().getSelectedCells().get(0);
		int row = pos.getRow();
		Sandwich sandwich = (Sandwich) tblMain.getItems().get(row);
		total -= sandwich.price();
		setTotal();
		lineNumber--;
		for(int x = row+1; x < tblMain.getItems().size(); x++) {
			Sandwich temp = (Sandwich) tblMain.getItems().get(x);
			temp.setLineNo(temp.getLineNo()-1);
		}
		tblMain.getItems().removeAll(tblMain.getSelectionModel().getSelectedItem());
	}
	
	@FXML
	private void btnExport_action() {
		
	}
	
	@FXML
	private void btnDup_action() {
		TablePosition pos = (TablePosition) tblMain.getSelectionModel().getSelectedCells().get(0);
		int row = pos.getRow();
		Sandwich sandwich = (Sandwich) tblMain.getItems().get(row);
		Sandwich clonewich = (Sandwich) sandwich.copy();
		addEntry(clonewich);
	}
	
	private void init() {
		tblcolQuantity.setCellValueFactory(new PropertyValueFactory<Sandwich, Integer>("lineNo"));
		tblcolSandwich.setCellValueFactory(new PropertyValueFactory<Sandwich, String>("Sandwich"));
		tblcolExtras.setCellValueFactory(new PropertyValueFactory<Sandwich, String>("Extras"));
		tblcolTotal.setCellValueFactory(new PropertyValueFactory<Sandwich, Double>("Total"));
		addEntry(new Chicken());
	}
	
	private double total = 0.0;
	private int lineNumber = 0;
	
	private void addEntry(Sandwich item) {
		if(item != null) {
			item.setLineNo(lineNumber);
			lineNumber++;
			tblMain.getItems().addAll(item);
			total += item.price();
			setTotal();
		}
	}
	
	private void setTotal() {
		double roundedTotal = (double)(Math.round(total * 100)) / 100;
		txtTotal.setText("" + roundedTotal);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		init();
	}
}