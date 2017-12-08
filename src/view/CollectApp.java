package view;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * 
 * CollectApp loads the application. 
 * 
 * @author Jesus Nieto
 *
 */
public class CollectApp extends Application {
	public static Stage stage;
	
	/*********
	 * start loads the primary stage used for the application. 
	 * 
	 * @param Stage primaryStage: The main stage to be used for the application. 
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/CollectMainMenu.fxml"));
			//primaryStage.setScene(new Scene(root, 500, 575));
			primaryStage.setScene(new Scene(root, 500, 246));
			primaryStage.setTitle("Collectibase");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.stage = primaryStage;
	}
	
	/*************
	 * Main method launches the application. 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/*********
	 * getStage returns the current stage. 
	 * 
	 * @return the current stage
	 */
	public static Stage getStage() {
		return stage;
	}
	
	
	
}