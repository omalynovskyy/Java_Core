package CardGames;

import javax.swing.*;
import java.util.Random;

public class Deck {
    private int value;
    Card[] startDeck = new Card[36];

    void newDeck() {
        value = 1;
        for (int i = 0; i < startDeck.length; ) {
            for (Suite suite: Suite.values()) {
                startDeck[i++] = new Card(suite, value);
            }
            value++;
        }
    }

    void mixDeck(){
        Random random = new Random();
        int swapCard;
        Card tempCard = new Card();
        for(int i = 0; i < startDeck.length; i++){
            swapCard = random.nextInt(36);
            tempCard.setSuite(startDeck[swapCard].getSuite());
            tempCard.setPower(startDeck[swapCard].getPower());
            startDeck[swapCard].setSuite(startDeck[i].getSuite());
            startDeck[swapCard].setPower(startDeck[i].getPower());
            startDeck[i].setSuite(tempCard.getSuite());
            startDeck[i].setPower(tempCard.getPower());

        }
    }

    @Override
    public String toString() {
        String deckCards = "";
        for(int i = 0; i < startDeck.length; i++){
            deckCards += startDeck[i].getPower() + " & " + startDeck[i].getSuite() + "; ";
        }
        return deckCards;
    }
}

