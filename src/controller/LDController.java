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
import model.LaserDiscCollection;
import model.Storage;
import view.CollectApp;

/**
 * controller for the laserdisc interface
 * @author Travis
 *
 */
public class LDController {

	public Button backButton;
	public Button updateButton;
	public Button deleteButton;
	public Button insertButton;
	
	@FXML
	public TextField titleField; // movie
	@FXML
	public TextField yearField; // movie
	@FXML
	public TextField genreField; // movie
	@FXML
	public TextField formatField; // movie
	@FXML
	public TextField directorField; // movie
	@FXML
	public TextField specialEditionField; // movie
	@FXML
	public TextField encodingFormatField;
	@FXML
	public TextField regionField;
	@FXML
	public TextField sidesField;
	@FXML
	public TextField coverField;
	@FXML
	TableView<LaserDiscCollection> ldTable;
	@FXML
	TableColumn<LaserDiscCollection, String> titleColumn;
	@FXML
	TableColumn<LaserDiscCollection, String> yearColumn;
	@FXML
	TableColumn<LaserDiscCollection, String> genreColumn;
	@FXML
	TableColumn<LaserDiscCollection, String> formatColumn;
	@FXML
	TableColumn<LaserDiscCollection, String> directorColumn;
	@FXML
	TableColumn<LaserDiscCollection, String> specialEditionColumn;
	@FXML
	TableColumn<LaserDiscCollection, String> encodingFormatColumn;
	@FXML
	TableColumn<LaserDiscCollection, String> regionColumn;
	@FXML
	TableColumn<LaserDiscCollection, String> sidesColumn;
	@FXML
	TableColumn<LaserDiscCollection, String> coverColumn;
	

	public void initialize() {
		cellValueFactory();
		getLDFromFile();
	}
	
	public void backButtonHandle() {
		CollectApp.stage.show();
		CollectController.childScene.hide();
		Storage.allLD = ldTable.getItems();
		try {
			writeLDFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void updateButtonHandle() {
		Storage.allLD = ldTable.getItems();
		try {
			writeLDFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public void insertButtonHandle() {
		LaserDiscCollection ldAdd = new LaserDiscCollection();
		// error checks if text fields are empty
		if (titleField.getText().equals("")) {
			ldAdd.setTitle("");
		} else {
			ldAdd.setTitle(titleField.getText());
		}

		if (genreField.getText().equals("")) {
			ldAdd.setGenre("");
		} else {
			ldAdd.setGenre(genreField.getText());
		}

		if (formatField.getText().equals("")) {
			ldAdd.setFormat("");
		} else {
			ldAdd.setFormat(formatField.getText());
		}

		if (yearField.getText().equals("")) {
			ldAdd.setYear("0");
		} else {
			ldAdd.setYear(yearField.getText());
		}

		if (directorField.getText().equals("")) {
			ldAdd.setDirector("");
		} else {
			ldAdd.setDirector(directorField.getText());
		}

		if (specialEditionField.getText().equals("")) {
			ldAdd.setSpecialEdition("");
		} else {
			ldAdd.setSpecialEdition(specialEditionField.getText());
		}

		if (encodingFormatField.getText().equals("")) {
			ldAdd.setEncodingFormat("");
			ldAdd.setEncodingFormat(encodingFormatField.getText());
		} else {
			ldAdd.setEncodingFormat(encodingFormatField.getText());
		}

		if (regionField.getText().equals("")) {
			ldAdd.setRegion("");
		} else {
			ldAdd.setRegion(regionField.getText());
		}

		if (sidesField.getText().equals("")) {
			ldAdd.setSides("");
		} else {
			ldAdd.setSides(sidesField.getText());
		}

		if (coverField.getText().equals("")) {
			ldAdd.setCover("");
		} else {
			ldAdd.setCover(coverField.getText());
		}

		// clears the text field when inserting
		ldTable.getItems().add(ldAdd);
		titleField.clear();
		genreField.clear();
		formatField.clear();
		yearField.clear();
		directorField.clear();
		specialEditionField.clear();
		encodingFormatField.clear();
		regionField.clear();
		sidesField.clear();
		coverField.clear();

		// writes to the file to keep table updated
		Storage.allLD = ldTable.getItems();
		try {
			writeLDFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void deleteButtonHandle() {
		ObservableList<LaserDiscCollection> ldSelected;
		Storage.allLD = ldTable.getItems();
		ldSelected = ldTable.getSelectionModel().getSelectedItems();
		ldSelected.forEach(Storage.allLD::remove);
		Storage.allLD = ldTable.getItems();
		try {
			writeLDFile();
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
		encodingFormatColumn.setCellValueFactory(new PropertyValueFactory<>("encodingFormat"));
		regionColumn.setCellValueFactory(new PropertyValueFactory<>("region"));
		sidesColumn.setCellValueFactory(new PropertyValueFactory<>("sides"));
		coverColumn.setCellValueFactory(new PropertyValueFactory<>("cover"));

		// the code below gives it the ability to edit info
		ldTable.setEditable(true);
		titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		yearColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		genreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		formatColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		directorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		specialEditionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		encodingFormatColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		regionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		sidesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		coverColumn.setCellFactory(TextFieldTableCell.forTableColumn());

	}
	

	/**
	 * when double clicking, you can change the info
	 * 
	 * @param edditedCell
	 */
	public void changeTitleName(CellEditEvent<LaserDiscCollection, String> edditedCell) {
		LaserDiscCollection titleSelected = ldTable.getSelectionModel().getSelectedItem();
		titleSelected.setTitle(edditedCell.getNewValue().toString());

	}
	
	public void changeGenre(CellEditEvent<LaserDiscCollection, String> edditedCell1) {
		LaserDiscCollection genreSelected = ldTable.getSelectionModel().getSelectedItem();
		genreSelected.setGenre(edditedCell1.getNewValue().toString());
	}
	
	public void changeFormat(CellEditEvent<LaserDiscCollection, String> edditedCell) {
		LaserDiscCollection formatSelected = ldTable.getSelectionModel().getSelectedItem();
		formatSelected.setFormat(edditedCell.getNewValue().toString());
	}
	
	/**
	 * makes the year column changable with double clicking it
	 * 
	 * @param edditedCell
	 */
	public void changeYear(CellEditEvent<LaserDiscCollection, String> edditedCell) {
		LaserDiscCollection yearSelected = ldTable.getSelectionModel().getSelectedItem();
		yearSelected.setYear(edditedCell.getNewValue().toString());
	}

	public void changeDirector(CellEditEvent<LaserDiscCollection, String> edditedCell) {
		LaserDiscCollection directorSelected = ldTable.getSelectionModel().getSelectedItem();
		directorSelected.setDirector(edditedCell.getNewValue().toString());
	}

	public void changeSpecialEdition(CellEditEvent<LaserDiscCollection, String> edditedCell) {
		LaserDiscCollection specialSelected = ldTable.getSelectionModel().getSelectedItem();
		specialSelected.setSpecialEdition(edditedCell.getNewValue().toString());
	}

	public void changeEncodingFormat(CellEditEvent<LaserDiscCollection, String> edditedCell) {
		LaserDiscCollection encodingFormatSelected = ldTable.getSelectionModel().getSelectedItem();
		encodingFormatSelected.setEncodingFormat(edditedCell.getNewValue().toString());
	}

	public void changeCriterion(CellEditEvent<LaserDiscCollection, String> edditedCell) {
		LaserDiscCollection regionSelected = ldTable.getSelectionModel().getSelectedItem();
		regionSelected.setRegion(edditedCell.getNewValue().toString());
	}

	public void changeSpineNumber(CellEditEvent<LaserDiscCollection, String> edditedCell) {
		LaserDiscCollection sidesSelected = ldTable.getSelectionModel().getSelectedItem();
		sidesSelected.setSides(edditedCell.getNewValue().toString());
	}

	public void changeSpecialFeaturing(CellEditEvent<LaserDiscCollection, String> edditedCell) {
		LaserDiscCollection coverSelected = ldTable.getSelectionModel().getSelectedItem();
		coverSelected.setCover(edditedCell.getNewValue().toString());
	}
	
	private void getLDFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("laserdisc.txt")));
			String line;
			String[] array;
			while ((line = br.readLine()) != null) {
				array = line.split(",");
				ldTable.getItems().add(new LaserDiscCollection(array[0], array[1], array[2], array[3],
						array[4], array[5], array[6], array[7], array[8], array[9]));
			}
			br.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public void writeLDFile() throws Exception {
		Writer writer = null;
		try {
			File file = new File("laserdisc.txt");
			writer = new BufferedWriter(new FileWriter(file));
			for (LaserDiscCollection dvd : Storage.allLD) {
				String text = dvd.getTitle() + "," + dvd.getYear() + "," + dvd.getGenre() + "," + dvd.getFormat() + ","
						+ dvd.getDirector() + "," + dvd.getSpecialEdition() + "," + dvd.getEncodingFormat() + ","
						+ dvd.getRegion() + "," + dvd.getSides() + "," + dvd.getCover() + "\n";
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
