package CardGames;

import java.util.Arrays;

public class Deck {
    private int value;
    Card[] emptyDeck = new Card[36];

    void newDeck() {
        value = 1;
        for (int i = 0; i < emptyDeck.length; ) {
            for (Suite suite: Suite.values()) {
                emptyDeck[i++] = new Card(suite, value);
            }
            value++;
        }
    }

    @Override
    public String toString() {
        String deckCards = "";
        for(int i = 0; i < emptyDeck.length; i++){
            deckCards += emptyDeck[i].getPower() + " & " + emptyDeck[i].getSuite() + "; ";
        }
        return deckCards;
    }
}

