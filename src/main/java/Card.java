/**
 * Defines a playing card.
 * @author Wesley Cheung
 * @version 17.0.1
 */

public class Card {
    private String name;
    private String suit;
    private int value;

    /** 
     * Constructor that specifies a name, suit, and value.
     * @param name Name of this card
	 * @param suit Suit of this card
     * @param value Value of this card
     * @throws IllegalArgumentException If names or suits are empty
	 */

    public Card(String name, String suit, int value) {
        if (name == null || name == "") {
            throw new IllegalArgumentException("Card name cannot be empty");
        } else if (suit == null || suit == "") {
            throw new IllegalArgumentException("Card suit cannot be empty");
        }
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    /**
     * Getter for the name of this card.
	 * @return The name of this card
	 */

    public String getName(){
        return this.name;
    }

    /**
     * Getter for the suit of this card.
	 * @return The suit of this card
	 */
    
    public String getSuit(){
        return this.suit;
    }

    /**
     * Getter for the value of this card.
	 * @return The value of this card
	 */

    public int getValue(){
        return this.value;
    }
    
    /**
     * Takes the name and suit of this card and formats them as "<code>name</code> of <code>suit</code>", for example "Ace of Spades".
     * @return A String of the card formatted as "<code>name</code> of <code>suit</code>"
	 */
    @Override
    public String toString() {
        return this.name + " of " + this.suit;
    }

    /**
     * Takes an object and checks if it is a card.
     * Compares the name, suit and value, if all are the same then the cards are equal.
     * @param obj Card that is to be compared to this card
     * @return true if <code>card</code> is equal to this card, otherwise false
	 */
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