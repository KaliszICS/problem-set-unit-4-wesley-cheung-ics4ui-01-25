import java.util.ArrayList;

/**
 * Defines a deck of cards.
 * @author Wesley Cheung
 * @version 1.0.0
 */

public class Deck {
    private ArrayList<Card> deck;

	/** 
     * Constructs a Deck from a specified Card array.
     * @param deck A Card array to be taken in as this deck
     * @throws IllegalArgumentException If Card array or cards in the Card array are null
	 */

	public Deck(Card[] deck) {
        this.deck = new ArrayList<Card>();
        if (deck == null) {
            throw new IllegalArgumentException("Deck cannot be null");
        }
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] == null) {
                throw new IllegalArgumentException("Cards in the deck cannot be null");
            }
            this.deck.add(deck[i]);
        }
	}

    /** 
     * Constructs a default Deck, 52 playing cards with suits from Hearts to Spades and names from Ace to King.&nbsp;<br>
     * Values increase from Ace to King, and for the same card names, the values are higher from Hearts to Spades.&nbsp;
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
     * Getter for the size of this deck.
	 * @return The size of this deck
	 */

	public int size() {
		return this.deck.size();
	}

    /**
     * Draws a card from the top of this deck.
	 * @return The card that was drawn, null if deck is empty
	 */

	public Card draw() {
        if (this.deck.size() == 0) {
            return null;
        }
		Card card = this.deck.get(0);
        this.deck.remove(0);
        return card;
	}

     /**
     * Shuffles this deck.
	 */

    public void shuffle() {
        int storedIndex;
        int otherIndex;
        for (int i = 0; i < (this.size()); i++) {
            storedIndex = (int)(Math.random()*(this.size()));
            otherIndex = (int)(Math.random()*(this.size()));
            Card storedCard = this.deck.get(storedIndex);
            this.deck.set(storedIndex, this.deck.get(otherIndex));
            this.deck.set(otherIndex, storedCard);  
        }
    }

    /**
     * Adds a card to the top of this deck, does nothing if the card is null.
     * @param card The card to be added to this deck
	 */

    public void addCard(Card card) {
        if (card == null) {
            return;
        }
        this.deck.add(0, card);
    }

    /**
     * Adds an array of cards to this deck, and then shuffles this deck.
     * This ignores any null cards.
     * @param cards Cards to be added to this deck before shuffling
	 */

    public void reshuffle(Card[] cards) {
        if (cards == null) {
            throw new IllegalArgumentException("Card array to add to deck cannot be null");
        }
        for (int i = 0; i < cards.length; i++) {
            this.addCard(cards[i]);
        }

        this.shuffle();
    }
}