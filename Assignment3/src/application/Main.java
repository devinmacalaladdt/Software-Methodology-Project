package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.fxml.FXMLLoader;

/**
 * Driver Class to link fxml and set the stage
 * @author Devin Macalalad, David Gasperini
 */
public class Main extends Application {
	@Override
	/**
	 * start method to initialize the GUI and stage
	 * @param primaryStage: stage object to initialize
	 */
	public void start(Stage primaryStage) {
		try {
			FlowPane root = (FlowPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,700,350);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Transaction Manager");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}