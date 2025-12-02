import java.util.ArrayList;

/**
 * Defines a player in a card game.
 * @author Wesley Cheung
 * @version 17.0.1
 */
public class Player {
    private String name;
    private int age;
    private ArrayList<Card> hand;

    /** 
     * Constructs a player with a specified name, age and hand.
     * @param name the name of this player
     * @param age the age of this player
     * @param hand the hand of this player
     * @throws IllegalArgumentException When name is empty, age is negative, hand or cards in hand are null
	 */

    public Player(String name, int age, Card[] hand) {
        if (name == null || name == "") {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
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
     * Constructs a player with the specified name and age.
     * @param name the name of this player
     * @param age the age of this player
     * @throws IllegalArgumentException When name is empty or if age is negative
	 */

    public Player(String name, int age) {
        if (name == null || name == "") {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<Card>();
    }

    /**
     * Getter for the name of this player.
	 * @return This player's name
	 */

    public String getName(){
        return this.name;
    }

    /**
     * Getter for this player's age.
	 * @return This player's age
	 */

    public int getAge(){
        return this.age;
    }

    /**
     * Getter for this player's hand.
	 * @return A Card array which is this player's hand
	 */

    public Card[] getHand(){
        return this.hand.toArray(new Card[this.size()]);
    }

    
    /**
     * Getter for the size of this player's hand.
	 * @return The size of this player's hand
	 */

    public int size() {
        return this.hand.size();
    }

    /**
     * Draws a card from this deck, adding it into the hand.
	 * @param deck Deck which is to be drawn from
     * @throws NullPointerException if deck is empty
	 */

    public void draw(Deck deck) {
        Card card = deck.draw();
        if (card == null) {
            throw new NullPointerException("Cannot draw from an empty deck");
        }
        this.hand.add(card);
    }

    /**
     * Discards a card from this player's hand, adding it to the discardPile.
     * @param card Card that is to be removed from this player's hand
	 * @param discardPile DiscardPile which card is to be discarded into
     * @throws IllegalArgumentException If card is null or card is not in hand
	 */

    public void discardCard(Card card, DiscardPile discardPile) {
        if (card == null) {
            throw new IllegalArgumentException("Cannot discard a null card");
        }
        if (!this.hand.remove(card)) {
            throw new IllegalArgumentException("Card to discard does not exist in hand");
        }
        discardPile.addCard(card);
    }

    /**
     * Returns a card from the hand to the deck.
     * @param card Card that is to be removed from this hand
	 * @param deck Deck which the card is to be added to
     * @return true if the card has been returned, and false if card not in hand
     * @throws IllegalArgumentException If deck is null
	 */

    public boolean returnCard(Card card, Deck deck) {
        if (deck == null) {
            throw new IllegalArgumentException("Cannot return card to a null deck");
        }
        boolean isPresent = this.hand.remove(card);
        if (isPresent) {
            deck.addCard(card);
        }
        return isPresent;
    }

    /**
     * Takes the name and all cards in this discard pile and formats cards in the form of "<code>name</code> of <code>suit</code>" with commas <br>
     * in between for example "Mr.&nbsp; Kalisz, 99, Ace of hearts, King of Hearts, Queen of Hearts, Jack of Hearts, 9 of Spades.&nbsp;"
     * @return All of the cards in the specified format as a single String
	 */
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