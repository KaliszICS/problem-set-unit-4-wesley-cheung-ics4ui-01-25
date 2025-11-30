import java.util.Scanner;
public class HighCard {
    public static void main(String[] args) {
        Deck deck = new Deck();
        if (deck.size()<10) {
            System.out.println("Insufficient cards in deck to play.");
            return;
        }
        int points = 0;
        deck.shuffle();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to High Card! Enter your names to start: ");
        System.out.println("Player 1: ");
        String name1 = input.nextLine();
        System.out.println("Player 2: ");
        String name2 = input.nextLine();
        Player player1 = new Player(name1, 20);
        Player player2 = new Player(name2, 20);
        input.close();
        for (int i = 0;i<5;i++) {
            player1.draw(deck);
            player2.draw(deck);
        }
        for (int i = 0;i<5;i++) {
            int maxIndex1 = 0;
            int maxIndex2 = 0;
            Card[] hand1 = player1.getHand();
            Card[] hand2 = player2.getHand();
            for (int j = 0;j<player1.size();j++) {
                if (hand1[j].getValue() > hand1[maxIndex1].getValue()){
                    maxIndex1 = j;
                }
            }
            for (int j = 0;j<player2.size();j++) {
                if (hand2[j].getValue() > hand2[maxIndex2].getValue()){
                    maxIndex2 = j;
                }
            }
            System.out.println(name1 + " drew a: "+hand1[maxIndex1]);
            System.out.println(name2 + " drew a: " +hand2[maxIndex2]);
            if (hand1[maxIndex1].getValue()>hand2[maxIndex2].getValue()) {
                System.out.println(name1 + " wins this round.");
                points += 1;
            }   else {
                System.out.println(name2 + " wins this round.");
                points -= 1;
            }
            player1.discardCard(hand1[maxIndex1], new DiscardPile());
            player2.discardCard(hand2[maxIndex2], new DiscardPile());
        }
        if (points > 0) {
                System.out.println(name1+" WINS!");
            } else {
                System.out.println(name2+" WINS!");
            }
    }
}
