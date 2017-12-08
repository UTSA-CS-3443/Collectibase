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

import model.CDCollection;

import view.CollectApp;

/**
 * 
 * CDController is responsible for connecting the listeners in the CD fxml file
 * to variables in the CDCollection class. CDController is also responsible for
 * updating the cd.txt file to be user for the CD fxml's TableView.
 * 
 * @author Jesus Nieto
 *
 */
public class CDController {
	@FXML
	public Button backButton;
	public Button insertButton;
	public Button deleteButton;
	public Button updateButton;
	public TextField artistField;
	public TextField albumField;
	public TextField runningField;
	public TextField multiField;
	public TextField posterField;
	public TextField enhancedField;
	public TextField yearField;
	@FXML
	TableView<CDCollection> cdTable;
	@FXML
	TableColumn<CDCollection, String> artistColumn;
	@FXML
	TableColumn<CDCollection, String> albumColumn;
	@FXML
	TableColumn<CDCollection, String> yearColumn;
	@FXML
	TableColumn<CDCollection, String> runningColumn;
	@FXML
	TableColumn<CDCollection, String> multiColumn;
	@FXML
	TableColumn<CDCollection, String> posterColumn;
	@FXML
	TableColumn<CDCollection, String> enhancedColumn;
	//ObservableList<CDCollection> allCD;
	
	/******
	 * initialize initializes the cell's in the TableView to their respective variables in
	 * the CDCollection. initialize also pre-populates the TableView with the variables in
	 * CD.txt.
	 */
	public void initialize() {
		cellValueFactory();
		getCDFromFile();
	}
	
	/************
	 * backButtonHandle is responsible for returning to Collectibase's main screen and saves any new entered
	 * information to CD.txt before exiting. 
	 */
	public void backButtonHandle(){
		CollectApp.stage.show();
		CollectController.childScene.hide();
		Storage.allCD = cdTable.getItems();
		try {
			writeCDFile();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	/***********
	 * updateButtonHandle is responsible for updating the TableView and CD.txt file whenever pressed.
	 */
	public void insertButtonHandle() {
		CDCollection cdAdd = new CDCollection();
		if(artistField.getText().equals("")) {
			cdAdd.setArtist("");
		}else {
			cdAdd.setArtist(artistField.getText());
		}
		
		if(albumField.getText().equals("")) {
			cdAdd.setAlbum("");
		}else {
			cdAdd.setAlbum(albumField.getText());
		}
		
		if(runningField.getText().equals("")) {
			cdAdd.setRunningTime("0");
		}else {
			cdAdd.setRunningTime(runningField.getText());
		}
		
		if(multiField.getText().equals("")) {
			cdAdd.setMultiCD("");
		}else {
			cdAdd.setMultiCD(multiField.getText());
		}
		
		if(posterField.getText().equals("")) {
			cdAdd.setPoster("");
		}else {
			cdAdd.setPoster(posterField.getText());
		}
		
		if(enhancedField.getText().equals("")) {
			cdAdd.setEnhancedCD("");
		}else {
			cdAdd.setEnhancedCD(enhancedField.getText());
		}
		
		if(yearField.getText().equals("")) {
			cdAdd.setYear("");
		}else {
			cdAdd.setYear(yearField.getText());
		}
		
		cdTable.getItems().add(cdAdd);
		artistField.clear();
		albumField.clear();
		runningField.clear();
		multiField.clear();
		posterField.clear();
		enhancedField.clear();
		yearField.clear();
		
		Storage.allCD = cdTable.getItems();
		try {
			writeCDFile();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	/**************
	 * deleteButtonHandle deletes a selected field or row from the TableView. CD.txt is also updated by deleting the respective
	 * fields from the file. 
	 */
	public void deleteButtonHandle() {
		ObservableList<CDCollection> cdSelected;
		Storage.allCD = cdTable.getItems();
		cdSelected = cdTable.getSelectionModel().getSelectedItems();
		cdSelected.forEach(Storage.allCD::remove);
		
		Storage.allCD = cdTable.getItems();
		try {
			writeCDFile();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	public void updateButtonHandle() {
		Storage.allCD = cdTable.getItems();
		try {
			writeCDFile();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	/*************8
	 * cellValueFactory is responsible for connecting the variable columns with it's respective variable in 
	 * CDCollection. cellValueFactory also allows for a single cell to be edited when double clicked. 
	 */
	public void cellValueFactory() {
		artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
		albumColumn.setCellValueFactory(new PropertyValueFactory<>("album"));
		runningColumn.setCellValueFactory(new PropertyValueFactory<>("runningTime"));
		multiColumn.setCellValueFactory(new PropertyValueFactory<>("multiCD"));
		posterColumn.setCellValueFactory(new PropertyValueFactory<>("poster"));
		enhancedColumn.setCellValueFactory(new PropertyValueFactory<>("enhancedCD"));
		yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
		
		// code below lets you edit table cells
		cdTable.setEditable(true);
		artistColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		albumColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		runningColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		multiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		posterColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		enhancedColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	}
	
	/**************88
	 * The following methods below update a single variable of a collectible when it's cell
	 * is double clicked. 
	 * @param edditedCell: the cell that was edited in the TableView
	 */
	public void changeArtist(CellEditEvent<CDCollection, String> edditedCell) {
		CDCollection artistSelected = cdTable.getSelectionModel().getSelectedItem();
		artistSelected.setArtist(edditedCell.getNewValue().toString());
		
	}
	
	public void changeAlbum(CellEditEvent<CDCollection, String> edditedCell) {
		CDCollection albumSelected = cdTable.getSelectionModel().getSelectedItem();
		albumSelected.setAlbum(edditedCell.getNewValue().toString());
	}
	
	public void changeRunning(CellEditEvent<CDCollection, String> edditedCell) {
		CDCollection runSelected = cdTable.getSelectionModel().getSelectedItem();
		runSelected.setRunningTime(edditedCell.getNewValue().toString());
	}
	
	public void changeMulti(CellEditEvent<CDCollection, String> edditedCell) {
		CDCollection multiSelected = cdTable.getSelectionModel().getSelectedItem();
		multiSelected.setMultiCD(edditedCell.getNewValue().toString());
	}
	
	public void changePoster(CellEditEvent<CDCollection, String> edditedCell) {
		CDCollection posterSelected = cdTable.getSelectionModel().getSelectedItem();
		posterSelected.setPoster(edditedCell.getNewValue().toString());
	}
	
	public void changeEnhanced(CellEditEvent<CDCollection, String> edditedCell) {
		CDCollection enhancedSelected = cdTable.getSelectionModel().getSelectedItem();
		enhancedSelected.setEnhancedCD(edditedCell.getNewValue().toString());
	}
	
	public void changeYear(CellEditEvent<CDCollection, String> edditedCell) {
		CDCollection yearSelected = cdTable.getSelectionModel().getSelectedItem();
		yearSelected.setYear(edditedCell.getNewValue().toString());
	}
	
	/*********
	 * getCDFromFile updates the TableView in the CD fxml file by reading
	 * what is in CD.txt
	 */
	private void getCDFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("cd.txt")));
			String line;
			String[] array;
			while ((line = br.readLine()) != null) {
				array = line.split("%");
				cdTable.getItems().add(new CDCollection(array[0],array[1],array[2],array[3],array[4], array[5], array[6] ));	
			}
			br.close();
			
		}catch (Exception ex) {
			ex.printStackTrace();
			
		}
		
	}
	
	/*****
	 * writeCDFile is responsible for writing to the Cd.txt file in order to frequently update 
	 * the Table View.
	 * @throws Exception: In the case that the collection has not been previously created, the cassette.txt file is not found.
	 */
	private void writeCDFile() throws Exception{
		Writer write = null;
		try {
			File file = new File("cd.txt");
			write = new BufferedWriter(new FileWriter(file));
			for(CDCollection cd : Storage.allCD) {
				String text = cd.getArtist() + "%" + cd.getAlbum() + "%" + cd.getYear() + "%"  + cd.getRunningTime() + "%" + cd.getMultiCD() + "%" + cd.getPoster() + "%" + cd.getEnhancedCD() + "\n";
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
