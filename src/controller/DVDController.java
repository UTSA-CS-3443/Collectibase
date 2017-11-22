package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.DVDCollection;
import model.Storage;
import view.CollectApp;

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
	//ObservableList<DVDCollection> allDVD;
	

	public void initialize() {
		cellValueFactory();
		getDVDFromFile();
	}
	
	public void backButtonHandle() {
		CollectApp.stage.show();
		CollectController.childScene.hide();
		Storage.allDVD = dvdTable.getItems();
		try {
			writeDVDFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void updateButtonHandle() {
		Storage.allDVD = dvdTable.getItems();
		try {
			writeDVDFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public void insertButtonHandle() {
		DVDCollection dvdAdd = new DVDCollection();
		// error checks if text fields are empty
		if (titleField.getText().equals("")) {
			dvdAdd.setTitle("");
		} else {
			dvdAdd.setTitle(titleField.getText());
		}

		if (genreField.getText().equals("")) {
			dvdAdd.setGenre("");
		} else {
			dvdAdd.setGenre(genreField.getText());
		}

		if (formatField.getText().equals("")) {
			dvdAdd.setFormat("");
		} else {
			dvdAdd.setFormat(formatField.getText());
		}

		if (yearField.getText().equals("")) {
			dvdAdd.setYear("0");
		} else {
			dvdAdd.setYear(yearField.getText());
		}

		if (directorField.getText().equals("")) {
			dvdAdd.setDirector("");
		} else {
			dvdAdd.setDirector(directorField.getText());
		}

		if (specialEditionField.getText().equals("")) {
			dvdAdd.setSpecialEdition("");
		} else {
			dvdAdd.setSpecialEdition(specialEditionField.getText());
		}

		if (caseTypeField.getText().equals("")) {
			dvdAdd.setCaseType("");
			dvdAdd.setCaseType(caseTypeField.getText());
		} else {
			dvdAdd.setCaseType(caseTypeField.getText());
		}

		if (criterionField.getText().equals("")) {
			dvdAdd.setCriterion("");
		} else {
			dvdAdd.setCriterion(criterionField.getText());
		}

		if (spineNumberField.getText().equals("")) {
			dvdAdd.setSpineNumber("");
		} else {
			dvdAdd.setSpineNumber(spineNumberField.getText());
		}

		if (specialFeaturingField.getText().equals("")) {
			dvdAdd.setSpecialFeaturing("");
		} else {
			dvdAdd.setSpecialFeaturing(specialFeaturingField.getText());
		}

		// clears the text field when inserting
		dvdTable.getItems().add(dvdAdd);
		titleField.clear();
		genreField.clear();
		formatField.clear();
		yearField.clear();
		directorField.clear();
		specialEditionField.clear();
		caseTypeField.clear();
		criterionField.clear();
		spineNumberField.clear();
		specialFeaturingField.clear();

		// writes to the file to keep table updated
		Storage.allDVD = dvdTable.getItems();
		try {
			writeDVDFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void deleteButtonHandle() {
		ObservableList<DVDCollection> dvdSelected;
		Storage.allDVD = dvdTable.getItems();
		dvdSelected = dvdTable.getSelectionModel().getSelectedItems();
		dvdSelected.forEach(Storage.allDVD::remove);
		Storage.allDVD = dvdTable.getItems();
		try {
			writeDVDFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void cellValueFactory() {
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
		formatColumn.setCellValueFactory(new PropertyValueFactory<>("format"));
		yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
		directorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));
		specialEditionColumn.setCellValueFactory(new PropertyValueFactory<>("specialEdition"));
		caseTypeColumn.setCellValueFactory(new PropertyValueFactory<>("caseType"));
		criterionColumn.setCellValueFactory(new PropertyValueFactory<>("criterion"));
		spineNumberColumn.setCellValueFactory(new PropertyValueFactory<>("spineNumber"));
		specialFeaturingColumn.setCellValueFactory(new PropertyValueFactory<>("specialFeaturing"));

		// the code below gives it the ability to edit info
		dvdTable.setEditable(true);
		titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		yearColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		genreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		formatColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		directorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		specialEditionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		caseTypeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		criterionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		spineNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		specialFeaturingColumn.setCellFactory(TextFieldTableCell.forTableColumn());

	}
	

	/**
	 * when double clicking, you can change the info
	 * 
	 * @param edditedCell
	 */
	public void changeTitleName(CellEditEvent edditedCell) {

		DVDCollection titleSelected = dvdTable.getSelectionModel().getSelectedItem();
		titleSelected.setTitle(edditedCell.getNewValue().toString());

	}
	
	public void changeGenre(CellEditEvent edditedCell1) {
		DVDCollection genreSelected = dvdTable.getSelectionModel().getSelectedItem();
		genreSelected.setGenre(edditedCell1.getNewValue().toString());
	}
	
	public void changeFormat(CellEditEvent edditedCell) {
		DVDCollection formatSelected = dvdTable.getSelectionModel().getSelectedItem();
		formatSelected.setFormat(edditedCell.getNewValue().toString());
	}
	
	/**
	 * makes the year column changable with double clicking it
	 * 
	 * @param edditedCell
	 */
	public void changeYear(CellEditEvent edditedCell) {
		DVDCollection yearSelected = dvdTable.getSelectionModel().getSelectedItem();
		yearSelected.setYear(edditedCell.getNewValue().toString());
	}

	public void changeDirector(CellEditEvent edditedCell) {
		DVDCollection directorSelected = dvdTable.getSelectionModel().getSelectedItem();
		directorSelected.setDirector(edditedCell.getNewValue().toString());
	}

	public void changeSpecialEdition(CellEditEvent edditedCell) {
		DVDCollection specialSelected = dvdTable.getSelectionModel().getSelectedItem();
		specialSelected.setSpecialEdition(edditedCell.getNewValue().toString());
	}

	public void changeCaseType(CellEditEvent edditedCell) {
		DVDCollection caseSelected = dvdTable.getSelectionModel().getSelectedItem();
		caseSelected.setCaseType(edditedCell.getNewValue().toString());
	}

	public void changeCriterion(CellEditEvent edditedCell) {
		DVDCollection criterionSelected = dvdTable.getSelectionModel().getSelectedItem();
		criterionSelected.setCriterion(edditedCell.getNewValue().toString());
	}

	public void changeSpineNumber(CellEditEvent edditedCell) {
		DVDCollection spineNumberSelected = dvdTable.getSelectionModel().getSelectedItem();
		spineNumberSelected.setSpineNumber(edditedCell.getNewValue().toString());
	}

	public void changeSpecialFeaturing(CellEditEvent edditedCell) {
		DVDCollection specialFeaturingSelected = dvdTable.getSelectionModel().getSelectedItem();
		specialFeaturingSelected.setSpecialFeaturing(edditedCell.getNewValue().toString());
	}
	
	private void getDVDFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("dvd.txt")));
			String line;
			String[] array;
			while ((line = br.readLine()) != null) {
				array = line.split(",");
				dvdTable.getItems().add(new DVDCollection(array[0], array[1], array[2], array[3],
						array[4], array[5], array[6], array[7], array[8], array[9]));
			}
			br.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public void writeDVDFile() throws Exception {
		Writer writer = null;
		try {
			File file = new File("dvd.txt");
			writer = new BufferedWriter(new FileWriter(file));
			for (DVDCollection dvd : Storage.allDVD) {
				String text = dvd.getTitle() + "," + dvd.getYear() + "," + dvd.getGenre() + "," + dvd.getFormat() + ","
						+ dvd.getDirector() + "," + dvd.getSpecialEdition() + "," + dvd.getCaseType() + ","
						+ dvd.getSpecialFeaturing() + "," + dvd.getCriterion() + "," + dvd.getSpineNumber() + "\n";
				writer.write(text);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			writer.flush();
			writer.close();

		}
	}
}
