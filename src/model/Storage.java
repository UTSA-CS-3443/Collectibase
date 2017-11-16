package model;

import java.util.ArrayList;

/**
 * This purpose of the Storage class is to hold the Array Lists for each type of collection.
 * Since each array list is static, you are able to access each AL and the contents within it
 * through out the application by calling as "Tools.vhs.get(i).someMethodHere()"
 * 
 * @author Travis
 *
 */
public class Storage {

	public static ArrayList<VHSCollection> vhs = new ArrayList<VHSCollection>();
	public static ArrayList<DVDCollection> dvd = new ArrayList<DVDCollection>();
	public static ArrayList<LaserDiscCollection> ld = new ArrayList<LaserDiscCollection>();
	public static ArrayList<CDCollection> cd = new ArrayList<CDCollection>();
	public static ArrayList<CassetteCollection> cass = new ArrayList<CassetteCollection>();
	public static ArrayList<VinylCollection> vin = new ArrayList<VinylCollection>();
	public static ArrayList<PokemonCardCollection> pkm = new ArrayList<PokemonCardCollection>();
	public static ArrayList<MTGCollection> mtg = new ArrayList<MTGCollection>();
	public static ArrayList<CustomCollection> custom = new ArrayList<CustomCollection>();
	public static ArrayList<YuGiOhCollection> ygo = new ArrayList<YuGiOhCollection>();
	
}
