package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * Class that initializes and displays the Sandwich Order Stage
 * @author Devin Macalalad, David Gasperini
 */
public class Main extends Application {
	/**
	 * Starts the Sandwich Order stage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sandwich.fxml"));
			Scene scene = new Scene(root,850,674);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Sandwich Order");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


