package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.DVDCollection;

public class DVDController {

	public Button backButton;
	public Button updateButton;
	public Button deleteButton;
	public Button insertButton;
	
	@FXML
	public TextField titleField;
	@FXML
	public TextField yearField;
	@FXML
	public TextField genreField;
	@FXML
	public TextField formatField;
	@FXML
	public TextField directorField;
	@FXML
	public TextField specialEditionField;
	@FXML
	public TextField caseTypeField;
	@FXML
	public TextField criterionField;
	@FXML
	public TextField spineNumberField;
	@FXML
	public TextField specialFeaturingField;
	@FXML
	TableView<DVDCollection> dvdTable;
	@FXML
	TableColumn<DVDCollection, String> titleColumn;
	@FXML
	TableColumn<DVDCollection, String> yearColumn;
	@FXML
	TableColumn<DVDCollection, String> genreColumn;
	@FXML
	TableColumn<DVDCollection, String> formatColumn;
	@FXML
	TableColumn<DVDCollection, String> directorColumn;
	@FXML
	TableColumn<DVDCollection, String> specialEditionColumn;
	@FXML
	TableColumn<DVDCollection, String> caseTypeColumn;
	@FXML
	TableColumn<DVDCollection, String> criterionColumn;
	@FXML
	TableColumn<DVDCollection, String> spineNumberColumn;
	@FXML
	TableColumn<DVDCollection, String> specialFeaturingColumn;
	ObservableList<DVDCollection> allDVD;
	
	public void initialize() {
		
	}
	
	public void backButton() {
		
	}
	
	public void insertButton() {
		
	}
	
	public void updateButton() {
		
		
	}
	
	public void cellValueFactory() {
		
		
	}
	
	
	
	
	
}
