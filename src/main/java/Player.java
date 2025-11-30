import java.util.ArrayList;

/**
	* Definition of the Player class
	* @author Wesley Cheung
	* @version 17.0.1
	*/
class Player {
    private String name;
    private int age;
    private ArrayList<Card> hand;

	/**
	 * This class can be configured with 3 variables, name, age, and hand
	 * @param name String that is the name of the player
	 * @param age integer that is the age of the player
     * @param hand Card[] that is the hand of the player
	 */
    /** 
    * Class constructor specifying name, age, and hand
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
    * Class constructor specifying name and age, creates a default empty hand
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
	 * @return the value of name
	 *
	 */

    public String getName(){
        return this.name;
    }

    /**
	 * @return the value of age
	 *
	 */
    public int getAge(){
        return this.age;
    }

     /**
	 * @return the value of hand (array)
	 *
	 */
    public Card[] getHand(){
        return this.hand.toArray(new Card[this.size()]);
    }
    public int size() {
        return this.hand.size();
    }
    public void draw(Deck deck) {
        Card card = deck.draw();
        if (card == null) {
            throw new NullPointerException("Cannot draw from an empty deck");
        }
        this.hand.add(card);
    }
    public void discardCard(Card card, DiscardPile discardPile) {
        if (card == null) {
            throw new NullPointerException("Cannot discard a null card");
        }
        discardPile.addCard(card);
        if (!(this.hand.remove(card))) {
            throw new IllegalArgumentException("Card to discard does not exist in hand");
        }
    }
    public boolean returnCard(Card card, Deck deck) {
        if (this.hand.indexOf(card) != -1) {
            deck.addCard(card);
        }
        return this.hand.remove(card);
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