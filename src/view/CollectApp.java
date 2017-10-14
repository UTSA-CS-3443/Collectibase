package view;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane; currently not used


public class CollectApp extends Application {
	public Stage stage;
	public AnchorPane layout;
	@Override
	public void start(Stage primaryStage) {
		try {
			this.stage = primaryStage;
			this.stage.setTitle("Collectibase Test");
			initLayout();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void initLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( CollectApp.class.getResource("/CollectMainMenu.fxml"));
			this.layout = (AnchorPane) loader.load();
			
			Scene scene = new Scene( layout );
			this.stage.setScene( scene );
			this.stage.show();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}