package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import view.CollectApp;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

/**
 * CollectController is the main screen of Collectibase and allows the
 * user to navigate between collection pages.
 * @author Jesus Nieto
 *
 */
public class CollectController{
	
	@FXML
	public ChoiceBox<String> musicChoice = new ChoiceBox<>();
	
	@FXML
	public ChoiceBox<String> movieChoice = new ChoiceBox<>();
	@FXML
	public ChoiceBox<String> cardChoice = new ChoiceBox<>();
	
	@FXML
	public Button nextButton;
	@FXML
	public String getChoiceValue;
	
	@FXML
	public String passString;
	@FXML 
	public String fxmlString;
	@FXML
	public AnchorPane rootPane;
	
	@FXML
	public static Stage childScene = new Stage();
	@FXML 
	public static String path;
	
	
	/**
	 * initialize initialized all drop-down menu boxes along with the collections 
	 * that are contained inside them.
	 */
	@FXML
	public void initialize() {
		musicChoice.getItems().addAll("CD","Vinyl","Cassette");	
		movieChoice.getItems().addAll("VHS","DVD","Laserdisc");
		cardChoice.getItems().addAll("MTG", "Pokemon","Yu-Gi-Oh");
		//nextButton.setTooltip(new Tooltip("Next"));
		musicChoice.setTooltip(new Tooltip("Select a music collection"));
		movieChoice.setTooltip(new Tooltip("Select a movie collection"));
		cardChoice.setTooltip(new Tooltip("Select a card collection"));
	}
	
	
	/**
	 * This function handles everything from reseting choice box values 
	 * to passing strings, to alert messages, to changing scene
	 * 1) when it resets the choice box value, the purpose of it is to 
	 * make it easier for the back button for the next scene
	 * 
	 */
	@FXML
	public void handleButton(){
		getChoice(movieChoice);
		passString(getChoiceValue);
		resetChoiceBoxValue(movieChoice);
		
		if(getChoiceValue == null) {
			getChoice(musicChoice);
			passString(getChoiceValue);
			resetChoiceBoxValue(musicChoice);
			if(getChoiceValue == null) {
				getChoice(cardChoice);
				passString(getChoiceValue);
				resetChoiceBoxValue(cardChoice);
				if(getChoiceValue == null) {
					alert();
				}
			}
		}
		
		
		if(getChoiceValue != null) {
			changeScene(passString);
		}
		getChoiceValue = null;
		System.out.println(getChoiceValue);
		System.out.println(passString);
		
	}
	
	/**
	 * getChoice is responsible for initializing the choiceValue which is the collection
	 * that the user selected. 
	 * 
	 * @param choiceBox choice: The user's selected collection from the drop-down boxes.
	 */
	public void getChoice(ChoiceBox<String> choice) {
		getChoiceValue = choice.getValue();
		
		
	}
	
	/**
	 * alert is responsible for displaying an alert message if no collection
	 * was selected. 
	 * 
	 */
	public void alert() {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Warning");
		alert.setContentText("Please select type of databse collection you want to fill!");
		alert.setHeaderText(null);
		alert.showAndWait();
		
	}
	
	/**
	 * passString initializes the passString to be used when deciding which
	 * collection stage to open. 
	 * 
	 * @param String y: The collection to be opened
	 */
	public void passString(String y) {
		this.passString = y;
	}
	
	/**
	 * resetChoiceBoxValue is responsible for clearing the user's choice once selected. 
	 * @param choiceBox
	 */
	public void resetChoiceBoxValue(ChoiceBox<String> choiceBox) {
		choiceBox.setValue(null);
		
	}
	
	/**
	 * 
	 * changeScene switches to a collection's scene page respective to user's choice. 
	 * @param a: the user's selected collection
	 */
	public void changeScene(String a){
		if(a == "VHS") {
			fxmlString = "/fxml/VHS.fxml";
			path = "/vhs.txt";
			childScene.setTitle("Collectibase - VHS");
		}else if(a == "DVD") {
			fxmlString = "/fxml/DVD.fxml";
			childScene.setTitle("Collectibase - DVD");
		}else if(a == "Laserdisc") {
			fxmlString = "/fxml/LaserDisc.fxml";
			childScene.setTitle("Collectibase - Laserdisc");
		}else if(a == "CD") {
			fxmlString = "/fxml/CD.fxml";
			childScene.setTitle("Collectibase - CD");
		}else if(a == "Vinyl") {
			fxmlString = "/fxml/Vinyl.fxml";
			childScene.setTitle("Collectibase - Vinyl");
		}else if(a == "Cassette") {
			fxmlString = "/fxml/Cassette.fxml";
			childScene.setTitle("Collectibase - Cassette");
		}else if(a == "Pokemon") {
			fxmlString = "/fxml/Pokemon.fxml";
			childScene.setTitle("Collectibase - Pokemon Cards");
		}else if(a == "MTG") {
			fxmlString = "/fxml/MTG.fxml";
			childScene.setTitle("Collectibase - Magic the Gathering Cards");
		}else if(a == "Yu-Gi-Oh") {
			fxmlString = "/fxml/Yu-Gi-Oh.fxml";
			childScene.setTitle("Collectibase - Yu-Gi-Oh Cards");
		}
		
		try {
		Parent root = FXMLLoader.load(getClass().getResource(fxmlString));
		childScene.setScene(new Scene(root,1280,720));
		childScene.show();
		CollectApp.stage.hide(); // closes the main menu
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
