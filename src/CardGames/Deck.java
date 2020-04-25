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
        int cardNum = 0;
        for(int i = 0; i < startDeck.length; i++){
            if(i == cardNum){
                cardNum = random.nextInt(36);
            }
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

