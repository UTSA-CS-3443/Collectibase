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
import model.PokemonCardCollection;
import view.CollectApp;

/*********************
 * PokeController is responsible for connecting listeners to the Pokemon.fxml file
 * to variables in the PokemonCollection class. PokeController is also responsible for
 * updating the poke.txt file to be user for Pokemon.fxml's TableView. 
 * 
 * @author Brenda Trejo
 *
 */
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
	
	/**************
	 * initialize initializes the cells in the TableView to their respective variables in
	 * the PokemonCollection. initialize also pre-populates the TableView with the data in poke.txt.
	 */
	public void initialize() {
		cellValueFactory();
		getPokeFromFile();
	} //initialize
	
	/***********
	 * backButtonHandle is responsible for returning to Collectibase's main screen and saves any new
	 * entered information to poke.txt before exiting.
	 */
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
	
	/***********
	 * updateButtonHandle is responsible for updating the TableView and poke.txt file whenever pressed. 
	 */
	public void updateButtonHandle() {
		Storage.allPoke = pokeTable.getItems();
		try {
			writePokeFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} //updateButtonHandle
	
	/************
	 * insertButtonHandle is responsible for inserting any text in the text fields onto the TableView. Empty fields
	 * are also accounted for. After the fields have been inserted they are cleared and poke.txt is updated. 
	 */
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
	
	/************
	 * deleteButtonHandle deletes a selected field or row from the TableView. poke.txt is also updated by
	 * deleting the respective fields from the file. 
	 */
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
	
	/**********
	 * cellValueFactory is responsible for connecting the variable columns with it's respective variable in 
	 * PokemonCollection. cellValueFactory also allows for a single cell to be edited when double clicked. 
	 */
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
	
	/************
	 * The methods below update a single variable of a collection when it's cell is
	 * double clicked. 
	 * @param edditedCell: the cell that was edited in the TableView will be the variable that is
	 * changed in the collection. 
	 */
	public void changeRarity(CellEditEvent<PokemonCardCollection, String>  edditedCell) {
		PokemonCardCollection raritySelected = pokeTable.getSelectionModel().getSelectedItem();
		raritySelected.setRarity(edditedCell.getNewValue().toString());
	}
	public void changeCondition(CellEditEvent<PokemonCardCollection, String>  edditedCell) {
		PokemonCardCollection conditionSelected = pokeTable.getSelectionModel().getSelectedItem();
		conditionSelected.setCondition(edditedCell.getNewValue().toString());
	}
	public void changeValue(CellEditEvent<PokemonCardCollection, String>  edditedCell) {
		PokemonCardCollection valueSelected = pokeTable.getSelectionModel().getSelectedItem();
		valueSelected.setValue(edditedCell.getNewValue().toString());
	}
	public void changeName(CellEditEvent<PokemonCardCollection, String>  edditedCell) {
		PokemonCardCollection nameSelected = pokeTable.getSelectionModel().getSelectedItem();
		nameSelected.setName(edditedCell.getNewValue().toString());
	}
	public void changeSeries(CellEditEvent<PokemonCardCollection, String> edditedCell) {
		PokemonCardCollection seriesSelected = pokeTable.getSelectionModel().getSelectedItem();
		seriesSelected.setSeries(edditedCell.getNewValue().toString());
	}
	public void changeSet(CellEditEvent<PokemonCardCollection, String>  edditedCell) {
		PokemonCardCollection setSelected = pokeTable.getSelectionModel().getSelectedItem();
		setSelected.setSet(edditedCell.getNewValue().toString());
	}
	public void changeType(CellEditEvent<PokemonCardCollection, String>  edditedCell) {
		PokemonCardCollection typeSelected = pokeTable.getSelectionModel().getSelectedItem();
		typeSelected.setType(edditedCell.getNewValue().toString());
	} 
	
	/************
	 * writePokeFile is responsible for writing to the poke.txt file in order to frequently update
	 * the TableView. 
	 * @throws Exception: In the case that the collection has not been created, the poke.txt file is not found. 
	 */
	public void writePokeFile() throws Exception {
		Writer writer = null;
		try {
			File file = new File("poke.txt");
			writer = new BufferedWriter(new FileWriter(file));
			for (PokemonCardCollection poke : Storage.allPoke) {
				String text = poke.getRarity() + "%" + poke.getCondition() + "%" + poke.getValue() + "%" +
						poke.getName() + "%" + poke.getSeries() + "%" + poke.getSet() + "%" + poke.getType() + "\n";
				writer.write(text);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}
	} //writePokeFile
	
	/*************
	 * getPokeFromFile updates the TableView in the Pokemon.fxml by reading what is in poke.txt. 
	 */
	public void getPokeFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("poke.txt")));
			String line;
			String[] array;
			while((line = br.readLine()) != null) {
				array = line.split("%");
				pokeTable.getItems().add(new PokemonCardCollection(array[0], array[1], array[2], array[3], array[4], array[5], array[6]));
			}
			br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
