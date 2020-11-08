package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 * Controller Class to link functionality to buttons/input on GUI for orderline
 * Contains action methods and helper methods for each input source
 * @author Devin Macalalad, David Gasperini
 */
public class OrderLineController {
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
	private void btnClose_action() {
		Stage stage = (Stage) btnClose.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	private void btnClear_action() {
		
	}
	
	@FXML
	private void btnCE_action() {
		
	}
	
	@FXML
	private void btnExport_action() {
		
	}
	
	@FXML
	private void btnDup_action() {
		
	}
	
	private void addEntry() {
		
	}
}