import java.util.ArrayList;

/**
 * A class that defines a deck of cards
 * Cards are from the Card class
 * @author Wesley Cheung
 * @version 17.0.1
 */

class Deck {
    private ArrayList<Card> deck;

	/** 
     * Constructor that creates an ArrayList deck from a specified Card array
     * @param deck a Card array to be taken in as the deck
     * @throws IllegalArgumentException if Card array or cards in the Card array are null
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
     * Default constructor that creates a 52-card deck with the suits from Hearts to Spades and has the names from Ace to King
     * The values higher from Ace to King, and for the same card names, the values are higher from Hearts to Spades
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
     * Getter for the size of the deck
	 * @return the size of the deck
	 */

	public int size() {
		return this.deck.size();
	}

    /**
     * Method that draws a card from the top of the deck
	 * @return the card that was drawn, null if no card is drawn
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
     * Method that shuffles the deck
     * Swaps any two values, and the amount of times this occurs corresponds the the size of the array
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
     * Method that adds a card to the top of the deck
     * Does nothing if the card is null
     * @param card the card to be added to the deck
	 */

    public void addCard(Card card) {
        if (card == null) {
            return;
        }
        this.deck.add(0, card);
    }

    /**
     * Method that adds an array of cards to the deck, and then shuffles the deck
     * Uses the shuffle and addCard methods
     * @param cards Card array to added to the deck before shuffling
	 */

    public void reshuffle(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            this.addCard(cards[i]);
        }

        this.shuffle();
    }
}