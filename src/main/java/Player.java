import java.util.ArrayList;

   /**
	* A class that defines a player in a card game
    * Uses the Card, DiscardPile, and Deck classes
	* @author Wesley Cheung
	* @version 17.0.1
	*/
class Player {
    private String name;
    private int age;
    private ArrayList<Card> hand;

    /** 
     * Constructor that specifies a name, age and hand
     * Throws exceptions if name are empty or if age is unrealistic
     *  Also throws exceptions if hand or cards in hand are null
     * 
     * @param name String that is the name of the player
     * @param age integer that is the age of the player
     * @param hand Card array that the hand of the player
	 */

    public Player(String name, int age, Card[] hand) {
        if (name == null || name == "") {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        } else if (age > 150) {
            throw new IllegalArgumentException("Age must be realistic");
        } else if (hand == null) {
            throw new IllegalArgumentException("Hand cannot be null");
        }
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<Card>();
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) {
                throw new IllegalArgumentException("Cards in the hand cannot be null");
            }
            this.hand.add(hand[i]);
        }
    }
    
    /** 
     * Constructor that specifies a name and age
     * Throws exceptions if name is empty or if age is unrealistic
     * 
     * @param name String that is the name of the player
     * @param age integer that is the age of the player
	 */

    public Player(String name, int age) {
        if (name == null || name == "") {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        } else if (age > 150) {
            throw new IllegalArgumentException("Age must be realistic");
        }
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<Card>();
    }

    /**
     * Getter for the name of the player
     * 
	 * @return the player's name
	 */

    public String getName(){
        return this.name;
    }

    /**
     * Getter for the player's age
     * 
	 * @return the player's age
	 */

    public int getAge(){
        return this.age;
    }

    /**
     * Getter for the player's hand
     * 
	 * @return a Card array which is the player's hand
	 */

    public Card[] getHand(){
        return this.hand.toArray(new Card[this.size()]);
    }

    
    /**
     * Getter for the size of the player's hand
     * 
	 * @return the size of the player's hand
	 */

    public int size() {
        return this.hand.size();
    }

    /**
     * Method that draws a card from the deck, adding it into the hand
     * 
	 * @param deck Deck which is to be drawn from
	 */

    public void draw(Deck deck) {
        Card card = deck.draw();
        if (card == null) {
            throw new NullPointerException("Cannot draw from an empty deck");
        }
        this.hand.add(card);
    }

    /**
     * Method that discards a card from the hand, adding it to the discardPile
     * Throws exception if card is null or card is not in hand
     * 
     * @param card Card that is to be removed from the hand
	 * @param discardPile DiscardPile which card is to be discarded into
	 */

    public void discardCard(Card card, DiscardPile discardPile) {
        if (card == null) {
            throw new IllegalArgumentException("Cannot discard a null card");
        }
        if (!(this.hand.remove(card))) {
            throw new IllegalArgumentException("Card to discard does not exist in hand");
        }
        discardPile.addCard(card);
    }

    /**
     * Method that returns a card from the hand to the deck
     * 
     * @param card Card that is to be removed from the hand
	 * @param deck Deck which the card is to be added to
     * @return a boolean, true when the card has been returned, and false if not
	 */

    public boolean returnCard(Card card, Deck deck) {
        boolean isPresent = this.hand.remove(card);
        if (isPresent) {
            deck.addCard(card);
        }
        return isPresent;
    }
    
    @Override
    public String toString() {
        String result = "";
        Card[] hand = this.getHand();
        result += (this.name + ", " + this.age);
        for (int i = 0; i < this.size(); i++) {
            result += (", " + hand[i].toString());
        }
        result += ".";
        return result; 
    }
}