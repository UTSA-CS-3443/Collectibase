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
import model.CassetteCollection;
import model.Storage;
import view.CollectApp;

/**
 * 
 * 
 * @author Brenda Trejo
 * debugged by:
 * 
 * @author Travis
 * 			initialize was misspelled causing the cellValueFactory and getCassetteFromFile functions not to be called. 
 *
 */
public class CassetteController {

	@FXML
	public Button backButton;
	public Button updateButton;
	public Button deleteButton;
	public Button insertButton;

	@FXML
	public TextField artistField;
	@FXML
	public TextField yearField;
	@FXML
	public TextField albumField;
	@FXML
	public TextField runningTimeField;
	@FXML
	public TextField typeField;
	@FXML
	public TextField writeProtectionField;
	@FXML
	public TextField audioOutputField;
	@FXML
	public TextField endlessLoopField;
	@FXML
	TableView<CassetteCollection> cassTable;
	@FXML
	TableColumn<CassetteCollection, String> artistColumn;
	@FXML
	TableColumn<CassetteCollection, String> yearColumn;
	@FXML
	TableColumn<CassetteCollection, String> albumColumn;
	@FXML
	TableColumn<CassetteCollection, String> runningTimeColumn;
	@FXML
	TableColumn<CassetteCollection, String> typeColumn;
	@FXML
	TableColumn<CassetteCollection, String> writeProtectionColumn;
	@FXML
	TableColumn<CassetteCollection, String> audioOutputColumn;
	@FXML
	TableColumn<CassetteCollection, String> endlessLoopColumn;

	public void initialize() {
		cellValueFactory();
		getCassetteFromFile();
	}

	public void backButtonHandle() {
		CollectApp.stage.show();
		CollectController.childScene.hide();
		Storage.allCassettes = cassTable.getItems();
		try {
			writeCassetteFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // backButtonHandle

	public void updateButtonHandle() {
		Storage.allCassettes = cassTable.getItems();
		try {
			writeCassetteFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // updateButtonHandle

	public void insertButtonHandle() {
		CassetteCollection cassAdd = new CassetteCollection();
		// Accounts for empty fields
		if (artistField.getText().equals("")) {
			cassAdd.setArtist("");
		} else {
			cassAdd.setArtist(artistField.getText());
		}

		if (yearField.getText().equals("")) {
			cassAdd.setYear("");
		} else {
			cassAdd.setYear(yearField.getText());
		}

		if (albumField.getText().equals("")) {
			cassAdd.setAlbum("");
		} else {
			cassAdd.setAlbum(albumField.getText());
		}

		if (runningTimeField.getText().equals("")) {
			cassAdd.setRunningTime("");
		} else {
			cassAdd.setRunningTime(runningTimeField.getText());
		}

		if (typeField.getText().equals("")) {
			cassAdd.setType("");
		} else {
			cassAdd.setType(typeField.getText());
		}

		if (writeProtectionField.getText().equals("")) {
			cassAdd.setWriteProtection("");
		} else {
			cassAdd.setWriteProtection(writeProtectionField.getText());
		}

		if (audioOutputField.getText().equals("")) {
			cassAdd.setAudioOutput("");
		} else {
			cassAdd.setAudioOutput(audioOutputField.getText());
		}

		if (endlessLoopField.getText().equals("")) {
			cassAdd.setEndlessLoop("");
		} else {
			cassAdd.setEndlessLoop(endlessLoopField.getText());
		}

		// Clear all fields after inserting a new item
		cassTable.getItems().add(cassAdd);
		artistField.clear();
		yearField.clear();
		albumField.clear();
		runningTimeField.clear();
		typeField.clear();
		writeProtectionField.clear();
		audioOutputField.clear();
		endlessLoopField.clear();

		// Writes to the cassette file to keep the table updated
		Storage.allCassettes = cassTable.getItems();
		try {
			writeCassetteFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // insertButtonHandle

	public void deleteButtonHandle() {
		ObservableList<CassetteCollection> cassSelected;
		Storage.allCassettes = cassTable.getItems();
		cassSelected = cassTable.getSelectionModel().getSelectedItems();
		cassSelected.forEach(Storage.allCassettes::remove);
		Storage.allCassettes = cassTable.getItems();
		try {
			writeCassetteFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // deleteButtonHandle

	public void cellValueFactory() {
		artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
		yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
		albumColumn.setCellValueFactory(new PropertyValueFactory<>("album"));
		runningTimeColumn.setCellValueFactory(new PropertyValueFactory<>("runningTime"));
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
		writeProtectionColumn.setCellValueFactory(new PropertyValueFactory<>("writeProtection"));
		audioOutputColumn.setCellValueFactory(new PropertyValueFactory<>("audioOutput"));
		endlessLoopColumn.setCellValueFactory(new PropertyValueFactory<>("endlessLoop"));

		cassTable.setEditable(true);
		artistColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		yearColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		albumColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		runningTimeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		writeProtectionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		audioOutputColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		endlessLoopColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	} // cellValueFactory

	/****
	 * The methods below allow you to edit an item by double clicking the cell.
	 */
	public void changeArtist(CellEditEvent edditedCell) {
		CassetteCollection artistSelected = cassTable.getSelectionModel().getSelectedItem();
		artistSelected.setArtist(edditedCell.getNewValue().toString());
	}

	public void changeYear(CellEditEvent edditedCell) {
		CassetteCollection yearSelected = cassTable.getSelectionModel().getSelectedItem();
		yearSelected.setYear(edditedCell.getNewValue().toString());
	}

	public void changeAlbum(CellEditEvent edditedCell) {
		CassetteCollection albumSelected = cassTable.getSelectionModel().getSelectedItem();
		albumSelected.setAlbum(edditedCell.getNewValue().toString());
	}

	public void changeRunningTime(CellEditEvent edditedCell) {
		CassetteCollection runningTimeSelected = cassTable.getSelectionModel().getSelectedItem();
		runningTimeSelected.setRunningTime(edditedCell.getNewValue().toString());
	}

	public void changeType(CellEditEvent edditedCell) {
		CassetteCollection typeSelected = cassTable.getSelectionModel().getSelectedItem();
		typeSelected.setType(edditedCell.getNewValue().toString());
	}

	public void changeWriteProtection(CellEditEvent edditedCell) {
		CassetteCollection writeProtectionSelected = cassTable.getSelectionModel().getSelectedItem();
		writeProtectionSelected.setWriteProtection(edditedCell.getNewValue().toString());
	}

	public void changeAudioOutput(CellEditEvent edditedCell) {
		CassetteCollection audioOutputSelected = cassTable.getSelectionModel().getSelectedItem();
		audioOutputSelected.setAudioOutput(edditedCell.getNewValue().toString());
	}

	public void changeEndlessLoop(CellEditEvent edditedCell) {
		CassetteCollection endlessLoopSelected = cassTable.getSelectionModel().getSelectedItem();
		endlessLoopSelected.setEndlessLoop(edditedCell.getNewValue().toString());
	}

	private void getCassetteFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("cassette.txt")));
			String line;
			String[] array;
			while ((line = br.readLine()) != null) {
				array = line.split("%");
				cassTable.getItems().add(new CassetteCollection(array[0], array[1], array[2], array[3], array[4],
						array[5], array[6], array[7]));
			}
			br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // getCassFromFile

	/* public */ private void writeCassetteFile() throws Exception {
		Writer writer = null;
		try {
			File file = new File("cassette.txt");
			writer = new BufferedWriter(new FileWriter(file));
			for (CassetteCollection cass : Storage.allCassettes) {
				String text = cass.getArtist() + "%" + cass.getYear() + "%" + cass.getAlbum() + "%"
						+ cass.getRunningTime() + "%" + cass.getType() + "%" + cass.getWriteProtection() + "%"
						+ cass.getAudioOutput() + "%" + cass.getEndlessLoop() + "\n";
				writer.write(text);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}
	} // writeCassFile

} // CassetteController
