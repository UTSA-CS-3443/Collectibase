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
import model.PokemonCardCollection;
import view.CollectApp;

public class PokeController {
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
	public TextField seriesField;
	@FXML
	public TextField setField;
	@FXML
	public TextField typeField;
	@FXML
	TableView<PokemonCardCollection> pokeTable;
	@FXML
	TableColumn<PokemonCardCollection, String> rarityColumn;
	@FXML
	TableColumn<PokemonCardCollection, String> conditionColumn;
	@FXML
	TableColumn<PokemonCardCollection, String> valueColumn;
	@FXML
	TableColumn<PokemonCardCollection, String> nameColumn;
	@FXML
	TableColumn<PokemonCardCollection, String> seriesColumn;
	@FXML
	TableColumn<PokemonCardCollection, String> setColumn;
	@FXML
	TableColumn<PokemonCardCollection, String> typeColumn;
	
	public void initialize() {
		cellValueFactory();
		getPokeFromFile();
	} //initialize
	
	public void backButtonHandle() {
		CollectApp.stage.show();
		CollectController.childScene.hide();
		Storage.allPoke = pokeTable.getItems();
		try {
			writePokeFile();
		} catch( Exception ex) {
			ex.printStackTrace();
		}
	} //backButtonHandle
	
	public void updateButtonHandle() {
		Storage.allPoke = pokeTable.getItems();
		try {
			writePokeFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} //updateButtonHandle
	
	public void insertButtonHandle() {
		PokemonCardCollection pokeAdd = new PokemonCardCollection();
		//Error checks if any fields are empty, auto populate
		if (rarityField.getText().equals("")) {
			pokeAdd.setRarity("");
		} else {
			pokeAdd.setRarity(rarityField.getText());
		}
		if (conditionField.getText().equals("")) {
			pokeAdd.setCondition("");
		} else {
			pokeAdd.setCondition(conditionField.getText());
		}
		if (valueField.getText().equals("")) {
			pokeAdd.setValue("");
		} else {
			pokeAdd.setValue(valueField.getText());
		}
		if (nameField.getText().equals("")) {
			pokeAdd.setName("");
		} else {
			pokeAdd.setName(nameField.getText());
		}
		if (seriesField.getText().equals("")) {
			pokeAdd.setSeries("");
		} else {
			pokeAdd.setSeries(seriesField.getText());
		}
		if (setField.getText().equals("")) {
			pokeAdd.setSet("");
		} else {
			pokeAdd.setSet(setField.getText());
		}
		if (typeField.getText().equals("")) {
			pokeAdd.setType("");
		} else {
			pokeAdd.setType(typeField.getText());
		}
		
		//Clears text fields when new item is inserted
		pokeTable.getItems().add(pokeAdd);
		rarityField.clear();
		conditionField.clear();
		valueField.clear();
		nameField.clear();
		seriesField.clear();
		setField.clear();
		typeField.clear();
		
		//Writes to the file to keep the table updated
		Storage.allPoke = pokeTable.getItems();
		try {
			writePokeFile();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	} //insertButtonHandle
	
	public void deleteButtonHandle() {
		ObservableList<PokemonCardCollection> pokeSelected;
		Storage.allPoke = pokeTable.getItems();
		pokeSelected = pokeTable.getSelectionModel().getSelectedItems();
		pokeSelected.forEach(Storage.allPoke::remove);
		Storage.allPoke = pokeTable.getItems();
		try {
			writePokeFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} //deleteButtonHandle
	
	public void cellValueFactory() {
		rarityColumn.setCellValueFactory(new PropertyValueFactory<>("rarity"));
		conditionColumn.setCellValueFactory(new PropertyValueFactory<>("condition"));
		valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		seriesColumn.setCellValueFactory(new PropertyValueFactory<>("series"));
		setColumn.setCellValueFactory(new PropertyValueFactory<>("set"));
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
		
		// The code below gives the ability to edit info
		pokeTable.setEditable(true);
		rarityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		conditionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		valueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		seriesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		setColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());	
	} //cellValueFactory
	
	public void changeRarity(CellEditEvent edditedCell) {
		PokemonCardCollection raritySelected = pokeTable.getSelectionModel().getSelectedItem();
		raritySelected.setRarity(edditedCell.getNewValue().toString());
	}
	public void changeCondition(CellEditEvent edditedCell) {
		PokemonCardCollection conditionSelected = pokeTable.getSelectionModel().getSelectedItem();
		conditionSelected.setCondition(edditedCell.getNewValue().toString());
	}
	public void changeValue(CellEditEvent edditedCell) {
		PokemonCardCollection valueSelected = pokeTable.getSelectionModel().getSelectedItem();
		valueSelected.setValue(edditedCell.getNewValue().toString());
	}
	public void changeName(CellEditEvent edditedCell) {
		PokemonCardCollection nameSelected = pokeTable.getSelectionModel().getSelectedItem();
		nameSelected.setName(edditedCell.getNewValue().toString());
	}
	public void changeSeries(CellEditEvent edditedCell) {
		PokemonCardCollection seriesSelected = pokeTable.getSelectionModel().getSelectedItem();
		seriesSelected.setSeries(edditedCell.getNewValue().toString());
	}
	public void changeSet(CellEditEvent edditedCell) {
		PokemonCardCollection setSelected = pokeTable.getSelectionModel().getSelectedItem();
		setSelected.setSet(edditedCell.getNewValue().toString());
	}
	public void changeType(CellEditEvent edditedCell) {
		PokemonCardCollection typeSelected = pokeTable.getSelectionModel().getSelectedItem();
		typeSelected.setType(edditedCell.getNewValue().toString());
	} 
	
	public void writePokeFile() throws Exception {
		Writer writer = null;
		try {
			File file = new File("poke.txt");
			writer = new BufferedWriter(new FileWriter(file));
			for (PokemonCardCollection poke : Storage.allPoke) {
				String text = poke.getRarity() + "," + poke.getCondition() + "," + poke.getValue() + "," +
						poke.getName() + "," + poke.getSeries() + "," + poke.getSet() + "," + poke.getType() + "\n";
				writer.write(text);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}
	} //writePokeFile
	
	public void getPokeFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("poke.txt")));
			String line;
			String[] array;
			while((line = br.readLine()) != null) {
				array = line.split(",");
				pokeTable.getItems().add(new PokemonCardCollection(array[0], array[1], array[2], array[3], array[4], array[5], array[6]));
			}
			br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
