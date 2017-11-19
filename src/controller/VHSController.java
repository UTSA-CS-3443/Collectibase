package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.util.Collection;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.shape.Line;
import javafx.util.converter.IntegerStringConverter;
import model.VHSCollection;
import model.VHSTestCollection;
import view.CollectApp;


/**
 * Controller for the VHS database.
 * Inserts, delete, and go back to the main menu.
 * 
 * @author jesusnieto
 *
 */
public class VHSController {
	public Button backButton;
	public Button insertButton;
	public Button deleteButton;
	@FXML
	public TextField titleField;
	@FXML
	public TextField genreField;
	@FXML
	public TextField formatField;
	@FXML
	public TextField yearField;
	@FXML
	public TextField directorField;
	@FXML
	public TextField specialEditionField;
	@FXML
	public TextField homeRecordingsField;
	@FXML
	public TextField multiProgramField;
	@FXML
	public TextField multiTapeField;
	@FXML
	public TextField sleeveTypeField;
	@FXML
	TableView<VHSTestCollection> vhsTable;
	@FXML
	TableColumn<VHSTestCollection, String> titleColumn;
	@FXML
	TableColumn<VHSTestCollection, String> genreColumn;
	@FXML
	TableColumn<VHSTestCollection, String> formatColumn;
	@FXML 
	TableColumn<VHSTestCollection, Integer> yearColumn;
	@FXML
	TableColumn<VHSTestCollection, String> directorColumn;
	@FXML
	TableColumn<VHSTestCollection, String> specialEditionColumn;
	@FXML
	TableColumn<VHSTestCollection, String> homeRecordingsColumn;
	@FXML
	TableColumn<VHSTestCollection, String> multiProgramColumn;
	@FXML
	TableColumn<VHSTestCollection, String> multiTapeColumn;
	@FXML
	TableColumn<VHSTestCollection, String> sleeveTypeColumn;
	ObservableList<VHSTestCollection> allVHS;
	
	//VHSTestCollection vhsAdd = new VHSTestCollection();
	
	
	public void initialize() {
		cellValueFactory();
		getVHSFromFile();
				
	}
	
	/**
	 * This function/method handles the back button so it can 
	 * go the the main menu.
	 */
	public void backButtonHandle() {
		CollectApp.stage.show();
		CollectController.childScene.hide();
		allVHS = vhsTable.getItems();
		try {
			writeVHSFile();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	public void insertButtonHandle() {
		VHSTestCollection vhsAdd = new VHSTestCollection();
		
		if(titleField.getText().equals("")) {
			vhsAdd.setTitle("");
		}else {
			vhsAdd.setTitle(titleField.getText());
		}
		
		
		
		vhsAdd.setGenre(genreField.getText());
		vhsAdd.setFormat(formatField.getText());
		if(yearField.getText().equals("")) {
			vhsAdd.setYear(0);
		}else {
			vhsAdd.setYear(Integer.parseInt(yearField.getText()));
		}
		
		vhsAdd.setDirector(directorField.getText());
		vhsAdd.setSpecialEdition(specialEditionField.getText());
		vhsAdd.setHomeRecording(homeRecordingsField.getText());
		vhsAdd.setMultiProgram(multiProgramField.getText());
		vhsAdd.setMultiTape(multiTapeField.getText());
		vhsAdd.setSleeveType(sleeveTypeField.getText());
		vhsTable.getItems().add(vhsAdd);
		titleField.clear();
		genreField.clear();
		formatField.clear();
		yearField.clear();
		directorField.clear();
		specialEditionField.clear();
		homeRecordingsField.clear();
		multiProgramField.clear();
		multiTapeField.clear();
		sleeveTypeField.clear();
		allVHS = vhsTable.getItems();
		try {
			writeVHSFile();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		
	}
	
	public void deleteButtonHandle() {
		ObservableList<VHSTestCollection> vhsSelected;
		allVHS = vhsTable.getItems();
		vhsSelected = vhsTable.getSelectionModel().getSelectedItems();
		vhsSelected.forEach(allVHS::remove);
		allVHS = vhsTable.getItems();
		try {
			writeVHSFile();
		}catch (Exception ex) {
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
		homeRecordingsColumn.setCellValueFactory(new PropertyValueFactory<>("homeRecording"));
		multiProgramColumn.setCellValueFactory(new PropertyValueFactory<>("multiProgram"));
		multiTapeColumn.setCellValueFactory(new PropertyValueFactory<>("multiTape"));
		sleeveTypeColumn.setCellValueFactory(new PropertyValueFactory<>("sleeveType"));
		
		// the code down gives it the ability to edit info
		vhsTable.setEditable(true);
		titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		yearColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
	}
	
	/**
	 * when double clicking, you can change the info
	 * @param edditedCell
	 */
	public void changeTitleName(CellEditEvent edditedCell) {
		VHSTestCollection titleSelected = vhsTable.getSelectionModel().getSelectedItem();
		titleSelected.setTitle(edditedCell.getNewValue().toString());
	}
	
	public void changeYear(CellEditEvent edditedCell) {
		VHSTestCollection yearSelected = vhsTable.getSelectionModel().getSelectedItem();
		yearSelected.setYear((Integer)edditedCell.getNewValue());
		
	}
	
	private void getVHSFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("vhs.txt")));
			String line;
			String[] array;
			while ((line = br.readLine()) != null) {
				array = line.split(",");
				vhsTable.getItems().add(new VHSTestCollection(array[0],array[1],array[2], Integer.parseInt(array[3]),array[4], array[5], array[6], array[7], array[8], array[9]));
				
			}
			br.close();
			
		}catch (Exception ex) {
			ex.printStackTrace();
			
		}
		
		
	}
	
	public void writeVHSFile() throws Exception{
		Writer writer = null;
		try {
			File file = new File("vhs.txt");
			writer = new BufferedWriter(new FileWriter(file));
			for(VHSTestCollection vhs : allVHS) {
				String text = vhs.getTitle() + "," + vhs.getGenre() + "," + vhs.getFormat() + "," + vhs.getYear() + "," + vhs.getDirector() + "," + vhs.getSpecialEdition() + "," + vhs.getHomeRecording() + "," + vhs.getMultiProgram() + "," + vhs.getMultiTape() + "," + vhs.getSleeveType() + "\n";                      
				writer.write(text);
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			writer.flush();
			writer.close();
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
