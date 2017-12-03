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
import model.Storage;
import model.YuGiOhCollection;
import view.CollectApp;

public class YGOController {

	public Button backButton;
	public Button updateButton;
	public Button deleteButton;
	public Button insertButton;
	
	@FXML
	public TextField rarityField;
	@FXML
	public TextField conditionField;
	@FXML
	public TextField valueField;
	@FXML 
	public TextField nameField;
	@FXML
	public TextField cardTypeField;
	@FXML
	public TextField attackField;
	@FXML
	public TextField defenseField;
	@FXML
	public TextField serialNumberField;
	@FXML
	public TableView<YuGiOhCollection> ygoTable;
	@FXML
	public TableColumn<YuGiOhCollection, String> rarityColumn;
	@FXML
	public TableColumn<YuGiOhCollection, String> conditionColumn;
	@FXML
	public TableColumn<YuGiOhCollection, String> valueColumn;
	@FXML
	public TableColumn<YuGiOhCollection, String> nameColumn;
	@FXML
	public TableColumn<YuGiOhCollection, String> cardTypeColumn;
	@FXML
	public TableColumn<YuGiOhCollection, String> attackColumn;
	@FXML
	public TableColumn<YuGiOhCollection, String> defenseColumn;
	@FXML
	public TableColumn<YuGiOhCollection, String> serialNumberColumn;
	
	public void initialize() {
		cellValueFactory();
		getYGOFromFile();
	} //initialize
	
	public void backButtonHandle() {
		CollectApp.stage.show();
		CollectController.childScene.hide();
		Storage.allYGO = ygoTable.getItems();
		try {
			writeYGOFile();
		} catch( Exception ex) {
			ex.printStackTrace();
		}
	} //backButtonHandle
	
	public void updateButtonHandle() {
		Storage.allYGO = ygoTable.getItems();
		try {
			writeYGOFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} //updateButtonHandle
	
	public void insertButtonHandle() {
		YuGiOhCollection ygoAdd = new YuGiOhCollection();
		//Error checks if any fields are empty, auto populate with null
		if (rarityField.getText().equals("")) {
			ygoAdd.setRarity("");
		} else {
			ygoAdd.setRarity(rarityField.getText());
		}
		
		if (conditionField.getText().equals("")) {
			ygoAdd.setCondition("");
		} else {
			ygoAdd.setCondition(conditionField.getText());
		}
		
		if (valueField.getText().equals("")) {
			ygoAdd.setValue("");
		} else {
			ygoAdd.setValue(valueField.getText());
		}
		
		if (nameField.getText().equals("")) {
			ygoAdd.setName("");
		} else {
			ygoAdd.setName(nameField.getText());
		}
		
		if (cardTypeField.getText().equals("")) {
			ygoAdd.setCardType("");
		} else {
			ygoAdd.setCardType(cardTypeField.getText());
		}
		
		if (attackField.getText().equals("")) {
			ygoAdd.setAttack("");
		} else {
			ygoAdd.setAttack(attackField.getText());
		}
		
		if (defenseField.getText().equals("")) {
			ygoAdd.setDefense("");
		} else {
			ygoAdd.setDefense(defenseField.getText());
		}
		
		if (serialNumberField.getText().equals("")) {
			ygoAdd.setSerialNumber("");
		} else {
			ygoAdd.setSerialNumber(serialNumberField.getText());
		}
		
		// Clears text fields when new item is inserted
		ygoTable.getItems().add(ygoAdd);
		rarityField.clear();
		conditionField.clear();
		valueField.clear();
		nameField.clear();
		cardTypeField.clear();
		attackField.clear();
		defenseField.clear();
		serialNumberField.clear();
		
		// Writes to the file to keep the table updated
		Storage.allYGO = ygoTable.getItems();
		try {
			writeYGOFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} //insertButtonHandle
	
	public void deleteButtonHandle() {
		ObservableList<YuGiOhCollection> ygoSelected;
		Storage.allYGO = ygoTable.getItems();
		ygoSelected = ygoTable.getSelectionModel().getSelectedItems();
		ygoSelected.forEach(Storage.allYGO::remove);
		Storage.allYGO = ygoTable.getItems();
		try {
			writeYGOFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} //deleteButtonHandle
	
	public void cellValueFactory() {
		rarityColumn.setCellValueFactory(new PropertyValueFactory<>("rarity"));
		conditionColumn.setCellValueFactory(new PropertyValueFactory<>("condition"));
		valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		cardTypeColumn.setCellValueFactory(new PropertyValueFactory<>("cardType"));
		attackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));
		defenseColumn.setCellValueFactory(new PropertyValueFactory<>("defense"));
		serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
		
		// The code below gives the ability to edit info
		ygoTable.setEditable(true);
		rarityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		conditionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		valueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		cardTypeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		attackColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		defenseColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		serialNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	} //cellValueFactory
	
	/****
	 * Double clicking the the cell alows you to edit info
	 */
	public void changeRarity(CellEditEvent edditedCell) {
		YuGiOhCollection raritySelected = ygoTable.getSelectionModel().getSelectedItem();
		raritySelected.setRarity(edditedCell.getNewValue().toString());
	}
	
	public void changeCondition(CellEditEvent edditedCell) {
		YuGiOhCollection conditionSelected = ygoTable.getSelectionModel().getSelectedItem();
		conditionSelected.setCondition(edditedCell.getNewValue().toString());
	}
	
	public void changeValue(CellEditEvent edditedCell) {
		YuGiOhCollection valueSelected = ygoTable.getSelectionModel().getSelectedItem();
		valueSelected.setValue(edditedCell.getNewValue().toString());
	}
	
	public void changeName(CellEditEvent edditedCell) {
		YuGiOhCollection nameSelected = ygoTable.getSelectionModel().getSelectedItem();
		nameSelected.setName(edditedCell.getNewValue().toString());
	}
	
	public void changeCardType(CellEditEvent edditedCell) {
		YuGiOhCollection cardTypeSelected = ygoTable.getSelectionModel().getSelectedItem();
		cardTypeSelected.setCardType(edditedCell.getNewValue().toString());
	}
	
	public void changeAttack(CellEditEvent edditedCell) {
		YuGiOhCollection attackSelected = ygoTable.getSelectionModel().getSelectedItem();
		attackSelected.setAttack(edditedCell.getNewValue().toString());
	}
	
	public void changeDefense(CellEditEvent edditedCell) {
		YuGiOhCollection defenseSelected = ygoTable.getSelectionModel().getSelectedItem();
		defenseSelected.setDefense(edditedCell.getNewValue().toString());
	}
	
	public void changeSerialNumber(CellEditEvent edditedCell) {
		YuGiOhCollection serialNumberSelected = ygoTable.getSelectionModel().getSelectedItem();
		serialNumberSelected.setSerialNumber(edditedCell.getNewValue().toString());
	}
	
	private void getYGOFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("ygo.txt")));
			String line;
			String[] array;
			while ((line = br.readLine()) != null) {
				array = line.split("%");
				ygoTable.getItems().add(new YuGiOhCollection(array[0], array[1], array[2], array[3],
						array[4], array[5], array[6], array[7]));
			}
			br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} //getYGOFromFile
	
	public void writeYGOFile() throws Exception {
		Writer writer = null;
		try {
			File file = new File("ygo.txt");
			writer = new BufferedWriter(new FileWriter(file));
			for (YuGiOhCollection ygo : Storage.allYGO) {
				String text = ygo.getRarity() + "% " + ygo.getCondition() + "% " + ygo.getValue() + "% " + ygo.getName() +
						"% " + ygo.getCardType() + "% " + ygo.getAttack() + "% " + ygo.getDefense() + "% " + ygo.getSerialNumber() + "\n";
				writer.write(text);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}
	} //writeYGOFile
} //ygoCollection
