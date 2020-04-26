package CardGames;

public class Game1 {
    static Deck deck = new Deck();
    public static void main(String[] args) {
        deck.newDeck();
        System.out.println(deck.toString());
        deck.mixDeck();
        System.out.println(deck.toString());
        deck.mixDeck();
        System.out.println(deck.toString());
    }
}
