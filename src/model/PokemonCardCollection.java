package model;

/**
 * 
 * Basic outline for a pokemon card for the TCG. PokemonCardCollection is a
 * child class of TCGCollection, this class contains more specific attributes
 * for the Pokemon Trading Card Game.
 * 
 * @author Cesar
 * 
 * Debuggers:
 * @author Travis
 *
 */
public class PokemonCardCollection extends TCGCollection {

	private String series;
	/*
	 * Pokemon cards organized into series since the Beginning cards are 16 total
	 * series
	 */
	private String set;
	/*
	 * Team Rocket, Fossil, Gym Heroes, Booster Sets
	 */
	private String type;
	/*
	 * Pokemon, Item, Evolution, Energy
	 */

	/***** Constructor *****/
	public PokemonCardCollection() {
		super(" ", " ", " ", " ");
		this.series = " ";
		this.set = " ";
		this.type = " ";
	}

	public PokemonCardCollection(String rarity, String condition, String value, String name, String series, String set,
			String type) {
		super(name, condition, rarity, value);
		this.series = series;
		this.set = set;
		this.type = type;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getSet() {
		return set;
	}

	public void setSet(String set) {
		this.set = set;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}