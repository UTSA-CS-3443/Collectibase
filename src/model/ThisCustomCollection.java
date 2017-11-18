package model;
import java.util.*;

/**************
 * ThisCustomCollection is a specific custom collection created by the user
 * which includes a HashMap of variables and their values for the collection.
 * 
 * @author brendatrejo
 *
 */

public class ThisCustomCollection extends CustomCollection{

	Map<String,String> variables;
	
	/*********
	 * The constructor only requires a name for each item in the collection.
	 * @param name the name of the item being added
	 */
	public ThisCustomCollection(String name) {
		super(name);
		variables = new HashMap<String, String>();
	}
	
	/************
	 * Since ThisCustomCollection is a class, I dont think you can use
	 * HashMap methods on it. (i.e put, get, etc). Some declared methods just in case
	 */
	
	/********
	 * When the user adds something to their custom collection, ThisCustomCollection.add(key, value)
	 * should be used. 
	 * 
	 * @param key is the variable name for the item
	 * @param value is teh value for the variable for the item
	 */
	public void add(String key, String value) {
		variables.put(key, value);
	}
	
	/*****
	 * Returns the value for the specified variable
	 * @param key is the variable being passed in
	 * @return is the value for the variable for this item
	 */
	public String get(String key) {
		return variables.get(key);
	} 
	
	/******
	 * This method can be used to grab all variable names for an item in a 
	 * custom collection. 
	 * @return a Set<String> containing all the keys in the HashMap
	 */
	public Set<String> returnAllKeys() {
		return variables.keySet();
	}
}
