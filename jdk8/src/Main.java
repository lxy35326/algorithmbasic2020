//import static System.out;
import static java.lang.System.out;
class Card {
    private String face,suit;
    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }
    public Card() {
    }
    public String getFace() {
        return face;
    }
    public String getSuit() {
        return suit;
    }

    public String toString() {
        return suit+face;
    }
}

public class Main {
    public static void main(String[] args) {
        out.println(1);
    }
    //完成任意两张牌的交换功能
    static void swap(Card[] card, int i, int j) {
        if (i != j) {
            Card c = card[i];
            card[i] = card[j];
            card[j] = c;
        }
    }
}
