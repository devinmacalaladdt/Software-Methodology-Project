package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SandwichController {
	
	@FXML
	private ComboBox<String> meat;
	@FXML
	private TextArea basicIngredients;
	@FXML
	private ImageView sandwichPicture;
	@FXML
	private ListView<String> extraIngredients;
	@FXML
	private ListView<String> addedIngredients;
	@FXML
	private Button addIngredients;
	@FXML
	private Button removeIngredients;
	@FXML
	private Button addToOrder;
	@FXML
	private Button showOrder;
	@FXML
	private TextField price;
	@FXML
	private TextArea display;
	@FXML
	private Button clear;
	
	private Sandwich currentSandwich;
	
	@FXML
	public void selectMeat() {
		
		basicIngredients.clear();
		
		if(meat.getValue().equals("Chicken")) {
			
		    InputStream stream = null;
			try {
				stream = new FileInputStream("src/application/chicken.jpg");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      Image image = new Image(stream);
		      sandwichPicture.setImage(image);
			
			for(String basic:Chicken.basicIngredients) {
				
				basicIngredients.appendText(basic+"\n");
				
			}
			
			currentSandwich = new Chicken();
			
		}else if(meat.getValue().equals("Beef")) {
			
		    InputStream stream = null;
			try {
				stream = new FileInputStream("src/application/beef.jpg");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      Image image = new Image(stream);
		      sandwichPicture.setImage(image);
			
			for(String basic:Beef.basicIngredients) {
				
				basicIngredients.appendText(basic+"\n");
				
			}
			
			currentSandwich = new Beef();
			
		}else if(meat.getValue().equals("Fish")) {
			
		    InputStream stream = null;
			try {
				stream = new FileInputStream("src/application/fish.jpg");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      Image image = new Image(stream);
		      sandwichPicture.setImage(image);
			
			for(String basic:Fish.basicIngredients) {
				
				basicIngredients.appendText(basic+"\n");
				
			}
			
			currentSandwich = new Fish();
			
		}
		
		updatePrice();
		resetListViews();
		
	}
	@FXML
	public void addIngredients() {
		
		List<String> selectedItemsCopy = new ArrayList<>(extraIngredients.getSelectionModel().getSelectedItems());
		
		if(currentSandwich.extras.size() + selectedItemsCopy.size() > Sandwich.MAX_EXTRAS) {
			
			display.appendText("cannot add ingredients: max extras will be exceeded\n");
			return;
			
		}
		
		addedIngredients.getItems().addAll(selectedItemsCopy);
		extraIngredients.getItems().removeAll(selectedItemsCopy);
		for(String s: selectedItemsCopy) {
			
			currentSandwich.add(new Extra(s));
			
		}
		updatePrice();
		
	}
	@FXML
	public void removeIngredients() {
		
		List<String> selectedItemsCopy = new ArrayList<>(addedIngredients.getSelectionModel().getSelectedItems());
		
		extraIngredients.getItems().addAll(selectedItemsCopy);
		addedIngredients.getItems().removeAll(selectedItemsCopy);
		for(String s: selectedItemsCopy) {
			
			currentSandwich.remove(new Extra(s));
			
		}
		updatePrice();
		
	}
	@FXML
	public void addToOrder() {
		
		
		
	}
	@FXML
	public void showOrder() {
		
		
		
	}
	
	public void updatePrice() {
		
		price.clear();
		this.price.appendText("$"+String.format("%.2f", currentSandwich.price()));
		
	}
	@FXML
	public void resetListViews() {
		
		ObservableList<String> extras = FXCollections.observableArrayList("styrofoam","broken glass","G-fuel","trombone spit",
				"aquarium gravel","paper towel","2004 Honda Civic", "Nerf darts","antibacterial soap","used medical syringe");
		extraIngredients.getItems().clear();
		addedIngredients.getItems().clear();
		extraIngredients.getItems().addAll(extras);
		currentSandwich.extras.clear();
		updatePrice();
		
	}
	
    @FXML
    public void initialize() {
    	
    	basicIngredients.setEditable(false);
		price.setEditable(false);
		display.setEditable(false);
		extraIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		addedIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		currentSandwich = new Chicken();
		meat.setValue("Chicken");
		selectMeat();
		
    }
	
}
