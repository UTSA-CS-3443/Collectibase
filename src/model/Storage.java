package model;

import java.util.ArrayList;

/*
 * used to hold the lists of specific collections. 
 */
public class Storage {
	// ArrayList set as static because there will be only one of each collection.
	// Array Lists can be accessed by Storage."list type"
	public static ArrayList<VHSCollection> vhs = new ArrayList<VHSCollection>();
	public static ArrayList<DVDCollection> dvd = new ArrayList<DVDCollection>();
	public static ArrayList<CDCollection> cd = new ArrayList<CDCollection>();
	
	
	
	
}
