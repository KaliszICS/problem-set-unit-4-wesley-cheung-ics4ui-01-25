import java.util.ArrayList;

/**
	* A class that defines a discard pile of cards
    * Cards are from the Card class
	* @author Wesley Cheung
	* @version 17.0.1
	*/

class DiscardPile {
    private ArrayList<Card> discard;

	/** 
    * Constructor that creates an ArrayList discard pile from a specified Card array
    * Throws exceptions if Card array or cards in the Card array are null
    * @param discard a Card array to be taken in as the discard pile
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
    * Default class constructor that creates an empty discard pile
    */
    public DiscardPile() {
        this.discard = new ArrayList<Card>();
    }

    /**
     * Getter for the discard pile
     * 
	 * @return the discard pile as a Card array
	 */

    public Card[] getDiscardPile(){
        return this.discard.toArray(new Card[this.size()]);
    }

	/**
     * Getter for the size of the discard pile
     * 
	 * @return the size of the discardPile
	 */

	public int size() {
		return this.discard.size();
	}

    /**
     * Method that adds a card to the top of the discard pile, which is index 0
     * Does nothing if the card attempting to be added is null
     * 
     * @param card the Card to be added to the discard pile
	 */

    public void addCard(Card card) {
        if (card == null) {
            return;
        }
        this.discard.add(0, card);
    }

    /**
     * Method that removes a specified card from the discard pile
     * 
     * @param card the Card to be removed from the discard pile
     * @return the Card that was removed, or null if card is not in discard pile
	 */

    public Card removeCard(Card card) {
        if (this.discard.size() == 0) {
            return null;
        }
        if (this.discard.remove(card)) {
            return card;
        } else {
            return null;
        }
    }

    /**
     * Method that removes all the cards from the discard pile and returns them
     * 
     * @return a Card array of all the cards in the discard pile, which can be empty if there are no cards
	 */

    public Card[] removeAll() {
        int size = this.size();
        Card[] removedCards = new Card[size];
        for(int i = 0;i<size;i++) {
            removedCards[i] = discard.get(0);
            this.discard.remove(0);
            
        }
        return removedCards;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0;i<size();i++) {
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