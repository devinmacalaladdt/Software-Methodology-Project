package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private ListView lstMain;
	@FXML
	private AnchorPane ancpanOrderLine;
	
	@FXML
	private void btnClose_action() {
		Stage stage = (Stage) btnClose.getScene().getWindow();
	    //stage.close();
		stage.hide();
	}
	
	@FXML
	private void btnClear_action() {
		total = 0.0;
		txtTotal.setText("" + total);
		for(int x = 0; x < lstMain.getItems().size(); x++)
			order.remove(order.Get(0));
		lstMain.getItems().clear();
	}
	
	@FXML
	private void btnCE_action() {
		int row = lstMain.getSelectionModel().getSelectedIndex();
		OrderLine line = order.Get(row);
		total -= line.getPrice();
		setTotal();
		order.remove(line);
		for(int x = row+1; x < lstMain.getItems().size(); x++) {
			OrderLine temp = order.Get(x);
			temp.setLineNo(temp.getLineNo()-1);
		}
		lstMain.getItems().remove(lstMain.getSelectionModel().getSelectedItem());
	}
	
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
					write += order.Get(x).getSandwich().toString() + '\n';
				fout.write(write);
				fout.close();
			}
			catch(IOException ioe) {}
	}
	
	@FXML
	private void btnDup_action() {
		int row = lstMain.getSelectionModel().getSelectedIndex();
		Sandwich sandwich = order.Get(row).getSandwich();
		OrderLine clonewich = new OrderLine(sandwich, sandwich.price());
		order.add(clonewich);
		addEntry(clonewich.getSandwich());
	}
		
	private double total = 0.0;
	
	private void addEntry(Sandwich item) {
		if(item != null) {
			order.add(new OrderLine(item, item.price()));
			lstMain.getItems().addAll(item);
			total += item.price();
			setTotal();
		}
	}
	
	private void setTotal() {
		txtTotal.setText("" + String.format("%.2f", Math.abs(total)));
	}

	Order order;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		order = new Order();	
		addEntry(new Chicken());
	}
}