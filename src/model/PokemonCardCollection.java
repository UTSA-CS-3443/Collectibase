package model;

public class PokemonCardCollection extends TCGCollection {

    /*
        TODO: add more variables to the cnstructor
    */
    private String  series;
    /*
        Pokemon cards organized into series since the Beginning cards are 16 total series
    */
    private String set;
    /*
        Team Rocket, Fossil, Gym Heroes, Booster Sets
    */
    private String type;
    /*
        Pokemon, Item, Evolution, Energy
    */


    /***** Constructor *****/
    /*public PokemonCardCollection(String name, String series, String type, boolean criterion, String spineNumber) {
		super(name);
		this.series = series;
		this.type = type;

	}*/

    public PokemonCardCollection() {
        super("","","","");
        this.series="";
        this.set="";
        this.type="";
    }
    
    public PokemonCardCollection(String rarity, String condition, String value, String name,
    						String series, String set, String type){
    	super(rarity, condition, value, name);
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