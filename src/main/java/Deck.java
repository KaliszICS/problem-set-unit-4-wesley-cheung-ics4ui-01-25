import java.util.ArrayList;
/**
	* Definition of the Deck class
	* @author Wesley Cheung
	* @version 17.0.1
	*/
class Deck {
    private ArrayList<Card> deck;

	/**
	 * This class can only has one variable, the deck of Cards
	 */
    /** 
    * Class constructor specifying a deck of cards
    */
	public Deck(Card[] deck) {
        this.deck = new ArrayList<Card>();
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] == null) {
                throw new NullPointerException("Cards in the deck cannot be null");
            }
            this.deck.add(deck[i]);
        }
	}
    /** 
    * Class constructor without specifying a deck, autofills unshuffled deck with Ace through King of each regular suit (hearts, clubs, diamonds, spades)
    */
    public Deck() {
        this.deck = new ArrayList<Card>();
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                this.deck.add(new Card(names[i], suits[j], i*suits.length+j));
            }
        }
    }

	/**
	 * @return the size of the deck
	 *
	 */

	public int size() {
		return this.deck.size();
	}

	public Card draw() {
        if (this.deck.size() == 0) {
            return null;
        }
		Card card = this.deck.get(0);
        this.deck.remove(0);
        return card;
	}
    public void shuffle() {
        if (this.size() == 0) {
            throw new IllegalArgumentException("Cannot shuffle empty deck");
        }
        int storedIndex;
        int otherIndex;
        for (int i = 0;i<(this.size());i++) {
            storedIndex = (int)(Math.random()*(this.size()));
            otherIndex = (int)(Math.random()*(this.size()));
            Card storedCard = this.deck.get(storedIndex);
            this.deck.set(storedIndex, this.deck.get(otherIndex));
            this.deck.set(otherIndex, storedCard);  
        }
    }
    public void addCard(Card card) {
        if (card == null) {
            return;
        }
        this.deck.add(0, card);
    }
    public void reshuffle(Card[] cards) {
        if (cards.length == 0) {
            throw new IllegalArgumentException("Cannot reshuffle with no new cards");
        }
        for (int i = 0;i<cards.length;i++) {
            this.addCard(cards[i]);
        }

        this.shuffle();
    }
}