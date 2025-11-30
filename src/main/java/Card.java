/**
	* A class that defines a playing card
	* @author Wesley Cheung
	* @version 17.0.1
	*/

class Card {
    private String name;
    private String suit;
    private int value;

    /** 
    * Constructor that specifies a name, suit, and value
    * Throws exceptions if names or suits are empty, and if values are negative
    * @param name String that is the name of the card
	* @param suit String that is the suit of the card
    * @param value integer that is the value of the card
	*/

    public Card(String name, String suit, int value) {
        if (name == null || name == "") {
            throw new IllegalArgumentException("Card name cannot be empty");
        } else if (suit == null || suit == "") {
            throw new IllegalArgumentException("Card suit cannot be empty");
        } else if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    /**
     * Getter for the name of the card
     * 
	 * @return the name of the card
	 */

    public String getName(){
        return this.name;
    }

    /**
     * Getter for the suit of the card
     * 
	 * @return the suit of the card
	 */
    
    public String getSuit(){
        return this.suit;
    }

     /**
     * Getter for the value of the card
     * 
	 * @return the value of the card
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