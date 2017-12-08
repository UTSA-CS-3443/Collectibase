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

/*************
 * YGOController is responsible for connecting listeners in
 * Yu-Gi-Oh.fxml to variables in YuGiOhCollection. YGOController is also
 * responsible for updating the ygo.txt file to be user for Yu-Gi-Oh.fxml's TableView.
 *  
 * @author Brenda Trejo
 *
 */
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
	
	/*******
	 * initialize initializes the cells in Yu-Gi-Oh.fxml's TableView to their respective
	 * variables in the YuGiOhCollection. initialize also pre-populates the TableView with the data in
	 * ygo.txt.
	 */
	public void initialize() {
		cellValueFactory();
		getYGOFromFile();
	} //initialize
	
	/***********
	 * backButtonHandle is responsible for returning to Collectibase's main screen and saves any
	 * new entered information to ygo.txt before exiting. 
	 */
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
	
	/***********
	 * updateButtonHandle is responsible for updating Yu-Gi-Oh.fxml's TableView and ygo.txt whenever pressed.
	 */
	public void updateButtonHandle() {
		Storage.allYGO = ygoTable.getItems();
		try {
			writeYGOFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} //updateButtonHandle
	
	/***************
	 * insertButtonHandle is responsible for inserting any text in Yu-Gi-Oh.fxml's TextFields
	 * onto the TableView. Empty cells are also accounted for. After the fields have been inserted
	 * they are cleared and ygo.txt is updated. 
	 */
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
	
	/******************
	 * deleteButtonHandle deletes a selected field or row from Yu-Gi-Oh.fxml's TableView. 
	 * ygo.txt is also update by deleting the respective variable 
	 * fields from the file. 
	 */
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
	
	/*****************
	 * cellValueFactory is responsible for connecting the variable columns with it's respective
	 * variable in YuGiOhCollection. cellValueFactory also allows for a single cell to be edited 
	 * when double clicked. 
	 */
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
	
	/***********8
	 * The methods below updates a single variable of a collectible when it's cell
	 * is double clicked. 
	 * @param edditedCell: the cell that was edited in Yu-Gi-Oh.fxml's TableView will be the 
	 * variable that is changed in YuGiOhCollection.
	 */
	public void changeRarity(CellEditEvent<YuGiOhCollection, String> edditedCell) {
		YuGiOhCollection raritySelected = ygoTable.getSelectionModel().getSelectedItem();
		raritySelected.setRarity(edditedCell.getNewValue().toString());
	}
	
	public void changeCondition(CellEditEvent<YuGiOhCollection, String> edditedCell) {
		YuGiOhCollection conditionSelected = ygoTable.getSelectionModel().getSelectedItem();
		conditionSelected.setCondition(edditedCell.getNewValue().toString());
	}
	
	public void changeValue(CellEditEvent<YuGiOhCollection, String> edditedCell) {
		YuGiOhCollection valueSelected = ygoTable.getSelectionModel().getSelectedItem();
		valueSelected.setValue(edditedCell.getNewValue().toString());
	}
	
	public void changeName(CellEditEvent<YuGiOhCollection, String> edditedCell) {
		YuGiOhCollection nameSelected = ygoTable.getSelectionModel().getSelectedItem();
		nameSelected.setName(edditedCell.getNewValue().toString());
	}
	
	public void changeCardType(CellEditEvent<YuGiOhCollection, String> edditedCell) {
		YuGiOhCollection cardTypeSelected = ygoTable.getSelectionModel().getSelectedItem();
		cardTypeSelected.setCardType(edditedCell.getNewValue().toString());
	}
	
	public void changeAttack(CellEditEvent<YuGiOhCollection, String> edditedCell) {
		YuGiOhCollection attackSelected = ygoTable.getSelectionModel().getSelectedItem();
		attackSelected.setAttack(edditedCell.getNewValue().toString());
	}
	
	public void changeDefense(CellEditEvent<YuGiOhCollection, String> edditedCell) {
		YuGiOhCollection defenseSelected = ygoTable.getSelectionModel().getSelectedItem();
		defenseSelected.setDefense(edditedCell.getNewValue().toString());
	}
	
	public void changeSerialNumber(CellEditEvent<YuGiOhCollection, String> edditedCell) {
		YuGiOhCollection serialNumberSelected = ygoTable.getSelectionModel().getSelectedItem();
		serialNumberSelected.setSerialNumber(edditedCell.getNewValue().toString());
	}
	
	/***********
	 * getYGOFromFile updates Yu-Gi-Oh.fxml's TableView by reading the data in ygo.txt.
	 */
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
	
	/***********
	 * writeYGOFile is responsible for writing to ygo.txt in order to update Yu-Gi-Oh.fxml's TableView.
	 * @throws Exception: In the case that the collection has not been previously created, the ygo.txt file is not found. 
	 */
	public void writeYGOFile() throws Exception {
		Writer writer = null;
		try {
			File file = new File("ygo.txt");
			writer = new BufferedWriter(new FileWriter(file));
			for (YuGiOhCollection ygo : Storage.allYGO) {
				String text = ygo.getRarity() + "%" + ygo.getCondition() + "%" + ygo.getValue() + "%" + ygo.getName() +
						"%" + ygo.getCardType() + "%" + ygo.getAttack() + "%" + ygo.getDefense() + "%" + ygo.getSerialNumber() + "\n";
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
