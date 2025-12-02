import java.util.ArrayList;

/**
 * Defines a discard pile of cards.
 * @author Wesley Cheung
 * @version 17.0.1
 */

public class DiscardPile {
    private ArrayList<Card> discard;

    /** 
     * Constructs a discard pile from a specified Card array
     * @param discard A Card array to be taken in as the discard pile
     * @throws IllegalArgumentException If Card array or cards in the Card array are null
	 */

	public DiscardPile(Card[] discard) {
        this.discard = new ArrayList<Card>();
        if (discard == null) {
            throw new IllegalArgumentException("Discard pile cannot be null");
        }
        for (int i = 0; i < discard.length; i++) {
            if (discard[i] == null) {
                throw new IllegalArgumentException("Cards in the discard pile cannot be null");
            }
            this.discard.add(discard[i]);
        }
	}

    /** 
     * Constructs a default discard pile that is empty.
     */

    public DiscardPile() {
        this.discard = new ArrayList<Card>();
    }

    /**
     * Getter for this discard pile.
	 * @return This discard pile
	 */

    public Card[] getDiscardPile(){
        return this.discard.toArray(new Card[this.size()]);
    }

	/**
     * Getter for the size of this discard pile.
	 * @return The size of this discardPile
	 */

	public int size() {
		return this.discard.size();
	}

    /**
     * Adds a card to the top of the discard pile.
     * Does nothing if the card attempting to be added is null.
     * @param card The Card to be added to this discard pile
	 */

    public void addCard(Card card) {
        if (card == null) {
            return;
        }
        this.discard.add(0, card);
    }

    /**
     * Removes a specified card from this discard pile.
     * @param card The Card to be removed from this discard pile
     * @return The Card that was removed, or null if card is not in discard pile
	 */

    public Card removeCard(Card card) {
        if (this.discard.remove(card)) {
            return card;
        } else {
            return null;
        }
    }

    /**
     * Removes all the cards from this discard pile and returns them.
     * @return A Card array of all the cards in this discard pile, which can be empty if there are no cards
	 */

    public Card[] removeAll() {
        int size = this.size();
        Card[] removedCards = new Card[size];
        for(int i = 0; i < size; i++) {
            removedCards[i] = this.discard.get(i);
        }
        this.discard.clear();
        return removedCards;
    }

    /**
     * Takes all cards in this discard pile and formats them in the form of "<code>name</code> of <code>suit</code>" with commas <br>
     * in between for example "Ace of hearts, King of Hearts, Queen of Hearts, Jack of Hearts, 9 of Spades.
     * @return All of the cards in the specified format as a single String
	 */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i<size(); i++) {
            result += this.discard.get(i).toString();
            if (i==size()-1) {
                result += ".";
            } else {
                result += ", ";
            }
        }
        return result;
    }
}