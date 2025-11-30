import java.util.ArrayList;

/**
	* Definition of the DiscardPile class
	* @author Wesley Cheung
	* @version 17.0.1
	*/
class DiscardPile {
    private ArrayList<Card> discard = new ArrayList<Card>();

	/**
	 * This class can only has one variable, the deck of Cards
	 */
    /** 
    * Class constructor specifying an array of cards
    */
	public DiscardPile(Card[] discard) {
        this.discard = new ArrayList<Card>();
        for (int i = 0; i < discard.length; i++) {
            if (discard[i] == null) {
                throw new NullPointerException("Cards in the discard pile cannot be null");
            }
            this.discard.add(discard[i]);
        }
	}
    /** 
    * Class constructor without specifying an array of cards
    */
    public DiscardPile() {

    }

    public Card[] getDiscardPile(){
        return this.discard.toArray(new Card[this.size()]);
    }

	/**
	 * @return the size of the discardPile
	 *
	 */

	public int size() {
		return this.discard.size();
	}
    public void addCard(Card card) {
        if (card == null) {
            return;
        }
        this.discard.add(0, card);
    }
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
    public Card[] removeAll() {
        Card[] removedCards = new Card[this.size()];
        for(int i = 0;i<this.size();i++) {
            removedCards[i] = discard.get(0);
            this.discard.remove(0);
            
        }
        return removedCards;
    }
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