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

import model.Storage;
import model.VinylCollection;


import view.CollectApp;

/**********
 * VinylController is responsible for connecting listeners in Vinyl.fxml
 * to variables in VinylCollection. VinylController is also responsible for
 * updating the vinyl.txt file to be user for Vinyl.fxml's TableView. 
 * 
 * @author Travis Lawson
 *
 */
public class VinylController {
	@FXML
	public Button backButton;
	public Button insertButton;
	public Button deleteButton;
	public Button updateButton;
	public TextField artistField;
	public TextField albumField;
	public TextField yearField;
	public TextField runningField;
	public TextField sizeField;
	public TextField colorField;
	public TextField speedField;
	
	@FXML
	TableView<VinylCollection> vinylTable;
	@FXML
	TableColumn<VinylCollection, String> artistColumn;
	@FXML
	TableColumn<VinylCollection, String> albumColumn;
	@FXML
	TableColumn<VinylCollection, String> yearColumn;
	@FXML
	TableColumn<VinylCollection, String> runningColumn;
	@FXML
	TableColumn<VinylCollection, String> sizeColumn;
	@FXML
	TableColumn<VinylCollection, String> colorColumn;
	@FXML
	TableColumn<VinylCollection, String> speedColumn;
	
	/*********
	 * initialize initializes the cells in Vinyl.fxml's TableView to their respective
	 * variables in VinylCollection. initialize also pre-populates the TableView with the data
	 * in vinyl.txt.
	 */
	public void initialize() {
		cellValueFactory();
		getVinylFromFile();
	}
	
	/************
	 * backButtonHandle is responsible for returning to Collectibase's main screen and saves any new
	 * entered information to vinyl.txt before exiting. 
	 */
	public void backButtonHandle(){
		CollectApp.stage.show();
		CollectController.childScene.hide();
		Storage.allVinyl = vinylTable.getItems();
		try {
			writeVinylFile();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	/************
	 * insertButtonHandle is responsible for inserting any text in the Vinyl.fxml's TextField's onto the TableView.
	 * Empty also accounted for. After the fields have been inserted they are cleared and vinyl.txt is updated. 
	 */
	public void insertButtonHandle() {
		VinylCollection vinylAdd = new VinylCollection();
		if(artistField.getText().equals("")) {
			vinylAdd.setArtist("");
		}else {
			vinylAdd.setArtist(artistField.getText());
		}
		
		if(albumField.getText().equals("")) {
			vinylAdd.setAlbum("");
		}else {
			vinylAdd.setAlbum(albumField.getText());
		}
		
		if(runningField.getText().equals("")) {
			vinylAdd.setRunningTime("0");
		}else {
			vinylAdd.setRunningTime(runningField.getText());
		}
		
		if(sizeField.getText().equals("")) {
			vinylAdd.setSize("");
		}else {
			vinylAdd.setSize(sizeField.getText());
		}
		
		if(colorField.getText().equals("")) {
			vinylAdd.setColor("");
		}else {
			vinylAdd.setColor(colorField.getText());
		}
		
		if(speedField.getText().equals("")) {
			vinylAdd.setSpeed("");
		}else {
			vinylAdd.setSpeed(speedField.getText());
		}
		
		if(yearField.getText().equals("")) {
			vinylAdd.setYear("");
		}else {
			vinylAdd.setYear(yearField.getText());
		}
		
		vinylTable.getItems().add(vinylAdd);
		artistField.clear();
		albumField.clear();
		runningField.clear();
		sizeField.clear();
		colorField.clear();
		speedField.clear();
		yearField.clear();
		
		Storage.allVinyl = vinylTable.getItems();
		try {
			writeVinylFile();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	/**********
	 * deleteButtonhandle deletes a selected field or row from vinyl.fxml's TableView. vinyl.txt is also updated 
	 * by deleting the respective fields from the file. 
	 */
	public void deleteButtonHandle() {
		ObservableList<VinylCollection> cdSelected;
		Storage.allVinyl = vinylTable.getItems();
		cdSelected = vinylTable.getSelectionModel().getSelectedItems();
		cdSelected.forEach(Storage.allVinyl::remove);
		
		Storage.allVinyl = vinylTable.getItems();
		try {
			writeVinylFile();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	/*************
	 * updateButtonHandle is responsible for updating vinyl.fxml's TableView and vinyl.txt file whenever pressed. 
	 */
	public void updateButtonHandle() {
		Storage.allVinyl = vinylTable.getItems();
		try {
			writeVinylFile();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	/*************
	 * cellValueFactory is responsible for connecting the variable columns with it's respective variable in
	 * VinylCollection. cellValueFactory also allows for a single cell to be edited when double clicked. 
	 */
	public void cellValueFactory() {
		artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
		albumColumn.setCellValueFactory(new PropertyValueFactory<>("album"));
		runningColumn.setCellValueFactory(new PropertyValueFactory<>("runningTime"));
		sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
		colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
		speedColumn.setCellValueFactory(new PropertyValueFactory<>("speed"));
		yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
		
		// code below lets you edit table cells
		vinylTable.setEditable(true);
		artistColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		albumColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		runningColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		sizeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		colorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		speedColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		yearColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	}
	
	/*************
	 * The methods below updates a single variable of a collectible when it's cell is
	 * double clicked. 
	 * @param edditedCell: the cell that was edited in vinyl.fxml's TableView will be the variable that is 
	 * changed in VinylCollection. 
	 */
	public void changeArtist(CellEditEvent<Integer, String> edditedCell) {
		VinylCollection artistSelected = vinylTable.getSelectionModel().getSelectedItem();
		artistSelected.setArtist(edditedCell.getNewValue().toString());
		
	}
	
	public void changeAlbum(CellEditEvent<Integer, String> edditedCell) {
		VinylCollection albumSelected = vinylTable.getSelectionModel().getSelectedItem();
		albumSelected.setAlbum(edditedCell.getNewValue().toString());
	}
	
	public void changeRunning(CellEditEvent<VinylCollection, String> edditedCell) {
		VinylCollection runSelected = vinylTable.getSelectionModel().getSelectedItem();
		runSelected.setRunningTime(edditedCell.getNewValue().toString());
	}
	
	public void changeSize(CellEditEvent<VinylCollection, String> edditedCell) {
		VinylCollection sizeSelected = vinylTable.getSelectionModel().getSelectedItem();
		sizeSelected.setSize(edditedCell.getNewValue().toString());
	}
	
	public void changeColor(CellEditEvent<VinylCollection, String> edditedCell) {
		VinylCollection colorSelected = vinylTable.getSelectionModel().getSelectedItem();
		colorSelected.setColor(edditedCell.getNewValue().toString());
	}
	
	public void changeSpeed(CellEditEvent<VinylCollection, String> edditedCell) {
		VinylCollection speedSelected = vinylTable.getSelectionModel().getSelectedItem();
		speedSelected.setSpeed(edditedCell.getNewValue().toString());
	}
	
	public void changeYear(CellEditEvent<VinylCollection, String> edditedCell) {
		VinylCollection yearSelected = vinylTable.getSelectionModel().getSelectedItem();
		yearSelected.setYear(edditedCell.getNewValue().toString());
	}
	
	/************
	 * getVinylFromFile updates Vinyl.fxml's TableView in the in the Vinyl.fxml file by reading the data in
	 * vinyl.txt
	 */
	private void getVinylFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("vinyl.txt")));
			String line;
			String[] array;
			while ((line = br.readLine()) != null) {
				array = line.split("%");
				vinylTable.getItems().add(new VinylCollection(array[0],array[1],array[2],array[3],array[4], array[5], array[6] ));	
			}
			br.close();
			
		}catch (Exception ex) {
			ex.printStackTrace();
			
		}
		
	}
	
	/**************8
	 * writeVinylFile is responsible for writing to vinyl.txt in order to update
	 * Vinyl.fxml's TableView.
	 * @throws Exception: In the case that the collection has not been previously created, the vinyl.txt file is not found. 
	 */
	private void writeVinylFile() throws Exception{
		Writer write = null;
		try {
			File file = new File("vinyl.txt");
			write = new BufferedWriter(new FileWriter(file));
			for(VinylCollection vin : Storage.allVinyl) {
				String text = vin.getArtist() + "%" + vin.getYear() + "%" + vin.getAlbum() + "%"  + vin.getRunningTime() + "%" + vin.getSize() + "%" + vin.getColor() + "%" + vin.getSpeed() + "\n";
				write.write(text);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
			
		}finally {
			write.flush();
			write.close();
		}
		
		
		
	}

}
