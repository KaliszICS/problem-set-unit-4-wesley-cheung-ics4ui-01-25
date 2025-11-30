/**
	* Definition of the Card class
	* @author Wesley Cheung
	* @version 17.0.1
	*/
class Card {
    private String name;
    private String suit;
    private int value;

	/**
	 * This class can be configured with 3 variables, name, suit, and value
	 * @param name String that is the name of the card
	 * @param suit String that is the suit of the card
     * @param value integer that is the value of the card
	 */
    /** 
    * Class constructor specifying name, suit, value
    */
    public Card(String name, String suit, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    /**
	 * @return the value of name
	 *
	 */

    public String getName(){
        return this.name;
    }

    /**
	 * @return the value of suit
	 *
	 */
    public String getSuit(){
        return this.suit;
    }

     /**
	 * @return the value of value
	 *
	 */
    public int getValue(){
        return this.value;
    }

    @Override
    public String toString() {
    return this.name + " of " + this.suit;
    }

    @Override
    public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    } else if (this.getClass() != obj.getClass()) {
        return false;
    }
    Card other = (Card)obj;
    return this.name.equals(other.getName()) && this.suit.equals(other.getSuit()) && this.value == other.getValue();
    }
}