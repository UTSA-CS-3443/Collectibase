package model;

import javafx.collections.ObservableList;

/**
 * The storage class is responsible for temporary storage of the collections when reading and writing 
 * to their respective files. The Observable List is used to keep the TableViews of the fxml files
 * updated. 
 * 
 * 
 * @author Jesus Nieto
 * @author Travis Lawson
 *
 */
public class Storage {
	public static ObservableList<VHSCollection> allVHS;
	public static ObservableList<CDCollection> allCD;
	public static ObservableList<DVDCollection> allDVD;
	public static ObservableList<MTGCollection> allMTG;
	public static ObservableList<YuGiOhCollection> allYGO;
	public static ObservableList<VinylCollection> allVinyl;
	public static ObservableList<CassetteCollection> allCassettes;
	public static ObservableList<LaserDiscCollection> allLD;
	public static ObservableList<PokemonCardCollection> allPoke;
}
