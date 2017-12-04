package view;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * 
 * load the actual app
 * @author jesusnieto
 *
 */
public class CollectApp extends Application {
	public static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/CollectMainMenu.fxml"));
			primaryStage.setScene(new Scene(root, 500, 575));
			primaryStage.setTitle("Collectibase");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.stage = primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	
	
}