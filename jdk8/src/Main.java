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
        //这是（3）问的功能
        String[] f = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}, s = {"黑桃", "红桃", "梅花", "方块"};
        Card[] deck = new Card[52];
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < f.length; j++) {
                deck[count++] = new Card(f[j], s[i]);
            }
        }
        //到此为止是（3）问的功能
        //随机打乱 牌的下标是0-51
        for (int i = 0; i < 10; i++) {
            int j = (int) (Math.random() * 52);
            int k = (int) (Math.random() * 52);
            swap(deck, j, k);
        }
        for (Card card : deck) {
            System.out.println(card);
        }
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
