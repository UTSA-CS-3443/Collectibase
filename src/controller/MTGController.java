package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.MTGCollection;
import model.Storage;
import model.VHSCollection;
import view.CollectApp;
/**
 * 
 * 
 * 
 * Debugged by Jesus and Travis.
 * 
 * @author Jesus
 * @author Travis
 *
 */
public class MTGController {
	public Button backButton;
	public Button insertButton;
	public Button deleteButton;
	public Button updateButton;
	
	@FXML
	public TextField nameField;
	@FXML
	public TextField conditionField;
	@FXML
	public TextField rarityField;
	@FXML
	public TextField valueField;
	@FXML
	public TextField manaField;
	@FXML
	public TextField cardTypeField;
	@FXML
	public TextField cardSetField;
	@FXML
	public TextField artistField;
	@FXML
	public TextField powerField;
	@FXML
	public TextField cardColorField;
	
	@FXML
	public TableView<MTGCollection> mtgTable;
	@FXML
	public TableColumn<MTGCollection, String> nameColumn;
	@FXML
	public TableColumn<MTGCollection, String> conditionColumn;
	@FXML
	public TableColumn<MTGCollection, String> rarityColumn;
	@FXML
	public TableColumn<MTGCollection, String> valueColumn;
	@FXML
	public TableColumn<MTGCollection, String> manaColumn;
	@FXML
	public TableColumn<MTGCollection, String> cardTypeColumn;
	@FXML
	public TableColumn<MTGCollection, String> cardSetColumn;
	@FXML
	public TableColumn<MTGCollection, String> artistColumn;
	@FXML
	public TableColumn<MTGCollection, String> powerColumn;
	@FXML
	public TableColumn<MTGCollection, String> cardColorColumn;
	
	
	
	public void initialize() {
		cellValueFactory();
		getMTGFromFile();

	}
	
	public void backButtonHandle() {
		CollectApp.stage.show();
		CollectController.childScene.hide();
		Storage.allMTG = mtgTable.getItems();
		try {
			writeMTGFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public void updateButtonHandle() {
		Storage.allMTG = mtgTable.getItems();
		try {
			writeMTGFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public void insertButtonHandle() {
		MTGCollection mtgAdd = new MTGCollection();
		// error checks if text fields are empty
		
		if (nameField.getText().equals("")) {
			mtgAdd.setName("");
		} else {
			mtgAdd.setName(nameField.getText());
		}
		
		if(conditionField.getText().equals("")) {
			mtgAdd.setCondition("");
		}else {
			mtgAdd.setCondition(conditionField.getText());
		}
		
		if(rarityField.getText().equals("")) {
			mtgAdd.setRarity("");
		}else {
			mtgAdd.setRarity(rarityField.getText());
		}
		
		if(valueField.getText().equals("")) {
			mtgAdd.setValue("");
		}else {
			mtgAdd.setValue(valueField.getText());
		}
		
		if(manaField.getText().equals("")) {
			mtgAdd.setManaCost("");
		}else {
			mtgAdd.setManaCost(manaField.getText());
		}
		
		if(cardTypeField.getText().equals("")) {
			mtgAdd.setCardType("");
		}else {
			mtgAdd.setCardType(cardTypeField.getText());
		}
		
		if(cardSetField.getText().equals("")) {
			mtgAdd.setCardSet("");
		}else {
			mtgAdd.setCardSet(cardSetField.getText());
		}
		
		if(artistField.getText().equals("")) {
			mtgAdd.setArtistInfo("");
		}else {
			mtgAdd.setArtistInfo(artistField.getText());
		}
		
		if(powerField.getText().equals("")) {
			mtgAdd.setPowerToughness("");
		}else {
			mtgAdd.setPowerToughness(powerField.getText());
		}
		
		if(cardColorField.getText().equals("")) {
			mtgAdd.setCardColor("");
		}else {
			mtgAdd.setCardColor(cardColorField.getText());
		}
		
		mtgTable.getItems().add(mtgAdd);
		nameField.clear();
		cardColorField.clear();
		powerField.clear();
		artistField.clear();
		cardSetField.clear();
		cardTypeField.clear();
		manaField.clear();
		valueField.clear();
		rarityField.clear();
		conditionField.clear();
		
		Storage.allMTG = mtgTable.getItems();
		try {
			writeMTGFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		

	}
	
	
	public void deleteButtonHandle() {
		ObservableList<MTGCollection> mtgSelected;
		Storage.allMTG = mtgTable.getItems();
		mtgSelected = mtgTable.getSelectionModel().getSelectedItems();
		mtgSelected.forEach(Storage.allMTG::remove);
		Storage.allMTG = mtgTable.getItems();
		try {
			writeMTGFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void cellValueFactory() {
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		conditionColumn.setCellValueFactory(new PropertyValueFactory<>("condition"));
		rarityColumn.setCellValueFactory(new PropertyValueFactory<>("rarity"));
		valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
		manaColumn.setCellValueFactory(new PropertyValueFactory<>("manaCost"));
		cardTypeColumn.setCellValueFactory(new PropertyValueFactory<>("cardType"));
		cardSetColumn.setCellValueFactory(new PropertyValueFactory<>("cardSet"));
		artistColumn.setCellValueFactory(new PropertyValueFactory<>("artistInfo"));
		powerColumn.setCellValueFactory(new PropertyValueFactory<>("powerToughness"));
		cardColorColumn.setCellValueFactory(new PropertyValueFactory<>("cardColor"));
		
		mtgTable.setEditable(true);
		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		conditionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		rarityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		valueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		manaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		cardTypeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		cardSetColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		artistColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		powerColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		cardColorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	}
	
	public void changeName(CellEditEvent edittedCell) {
		MTGCollection name = mtgTable.getSelectionModel().getSelectedItem();
		name.setName(edittedCell.getNewValue().toString());
	}
	
	public void changeCondition(CellEditEvent edittedCell) {
		MTGCollection condition = mtgTable.getSelectionModel().getSelectedItem();
		condition.setCondition(edittedCell.getNewValue().toString());
		
	}
	
	public void changeRarity(CellEditEvent edittedCell) {
		MTGCollection rarity = mtgTable.getSelectionModel().getSelectedItem();
		rarity.setRarity(edittedCell.getNewValue().toString());
		
	}
	
	public void changeValue(CellEditEvent edittedCell) {
		MTGCollection value = mtgTable.getSelectionModel().getSelectedItem();
		value.setValue(edittedCell.getNewValue().toString());
	}
	
	public void changeMana(CellEditEvent edittedCell) {
		MTGCollection mana = mtgTable.getSelectionModel().getSelectedItem();
		mana.setManaCost(edittedCell.getNewValue().toString());
	}
	
	public void changeCardType(CellEditEvent edittedCell) {
		MTGCollection type = mtgTable.getSelectionModel().getSelectedItem();
		type.setCardType(edittedCell.getNewValue().toString());
		
	}
	
	public void changeCardSet(CellEditEvent edittedCell) {
		MTGCollection set = mtgTable.getSelectionModel().getSelectedItem();
		set.setCardSet(edittedCell.getNewValue().toString());
		
	}
	
	public void changeArtist(CellEditEvent edittedCell) {
		MTGCollection artist = mtgTable.getSelectionModel().getSelectedItem();
		artist.setArtistInfo(edittedCell.getNewValue().toString());
		
	}
	
	public void changePower(CellEditEvent edittedCell) {
		
		MTGCollection power = mtgTable.getSelectionModel().getSelectedItem();
		power.setPowerToughness(edittedCell.getNewValue().toString());
	}
	
	public void changeColor(CellEditEvent edittedCell) {
		MTGCollection color = mtgTable.getSelectionModel().getSelectedItem();
		color.setCardColor(edittedCell.getNewValue().toString());
		
	}
	
	public void writeMTGFile() throws Exception {
		Writer writer = null;
		try {
			File file = new File("mtg.txt");
			writer = new BufferedWriter(new FileWriter(file));
			for (MTGCollection mtg : Storage.allMTG) {
				String text =  mtg.getName() + "," + mtg.getCondition() + "," + mtg.getRarity() + "," + mtg.getValue() + ","
						+ mtg.getManaCost() + "," + mtg.getCardType() + "," + mtg.getCardSet() + ","
						+ mtg.getArtistInfo() + "," + mtg.getPowerToughness() + "," + mtg.getCardColor() + "\n";
				writer.write(text);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			writer.flush();
			writer.close();

		}
	}
	
	private void getMTGFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("mtg.txt")));
			String line;
			String[] array;
			while ((line = br.readLine()) != null) {
				array = line.split(",");
				mtgTable.getItems().add(new MTGCollection(array[0], array[1], array[2], array[3],
						array[4], array[5], array[6], array[7], array[8], array[9]));
			}
			br.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

}
