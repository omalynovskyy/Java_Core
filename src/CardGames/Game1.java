package CardGames;

import java.util.concurrent.Callable;

public class Game1 {
    static Deck deck = new Deck();

    static int deckLength = deck.startDeck.length;

    static Card[] player1 = new Card[deckLength];
    static Card[] player2 = new Card[deckLength];

    static int stepCount = 0;
    static int pl1FreePlace = deckLength/2;
    static int pl2FreePlace = deckLength/2;
    

    public static void main(String[] args) {
        deck.newDeck();
        deck.mixDeck();
        System.out.println(deck.toString());

        for (int i = 0; i < deckLength / 2; i++) {
            player1[i] = deck.startDeck[i];
            player2[i] = deck.startDeck[i + deckLength / 2];
        }

        checkPlayersCards();


        mainGame(stepCount, pl1FreePlace, pl2FreePlace);

    }

    static void checkPlayersCards() {
        System.out.print("player1 cards: ");

        for (int i = 0; i < deckLength; i++) {
            if(player1[i] == null){
                continue;
            }
        System.out.print(player1[i]);
    }
        System.out.print("\n" + "player2 cards: ");
        for (int i = 0; i < deckLength; i++) {
            if(player2[i] == null){
                continue;
            }
        System.out.print(player2[i]);
    }
        System.out.println("\n");
}

    
    static void player1TakesCards(int stCount, int p1FreePlace, int p2FreePlace) {
        if (stCount == 0) {
            if (player1[player1.length - 1] != null) {
                player1TakesCards(player1.length - 1, p1FreePlace, p2FreePlace);
            } else {
                player1[p1FreePlace++ % player1.length] = player1[stCount];
                player1[p1FreePlace++ % player1.length] = player2[stCount];
                player1[stCount] = null;
                player2[stCount++] = null;
                System.out.println("player1 takes cards");
                checkPlayersCards();
                mainGame(stCount % deck.startDeck.length, p1FreePlace % deckLength, p2FreePlace % deckLength);
            }
        }
        if (player1[stCount - 1] != null) {
                player1TakesCards(stCount - 1, p1FreePlace, p2FreePlace);
            }
        player1[p1FreePlace++ % player1.length] = player1[stCount];
        player1[p1FreePlace++ % player1.length] = player2[stCount];
        player1[stCount] = null;
        player2[stCount++] = null;
        System.out.println("player1 takes cards");
        checkPlayersCards();
        mainGame(stCount % deck.startDeck.length, p1FreePlace % deckLength, p2FreePlace % deckLength);
    }

    static void player2TakesCards(int stCount, int p1FreePlace, int p2FreePlace){
        if (stCount == 0) {
            if (player2[player2.length - 1] != null) {
                player2TakesCards(player2.length - 1, p1FreePlace, p2FreePlace);
            } else {
                player2[p2FreePlace++ % player1.length] = player1[stCount];
                player2[p2FreePlace++ % player1.length] = player2[stCount];
                player1[stCount] = null;
                player2[stCount++] = null;
                System.out.println("player2 takes cards");
                checkPlayersCards();
                mainGame(stCount % deck.startDeck.length, p1FreePlace % deckLength, p2FreePlace % deckLength);
            }
        }
        if (player2[stCount - 1] != null) {
            player2TakesCards(stCount - 1, p1FreePlace, p2FreePlace);
        }
        player2[p2FreePlace++ % player1.length] = player1[stCount];
        player2[p2FreePlace++ % player1.length] = player2[stCount];
        player1[stCount] = null;
        player2[stCount++] = null;
        System.out.println("player2 takes cards");
        checkPlayersCards();
        mainGame(stCount % deck.startDeck.length, p1FreePlace % deckLength, pl2FreePlace % deckLength);
    }

    static void mainGame(int stepCount, int pl1FreePlace, int pl2FreePlace){
        if(player1[stepCount % deckLength] == null){
            System.out.println("player2 wins");
        } else if (player2[stepCount % deckLength] == null) {
            System.out.println("player1 wins");
        }
        int stepResult = player1[stepCount % deckLength].getPower() - player2[stepCount % deckLength].getPower();
        if (stepResult > 0){
            if(stepResult < 8){
                player1TakesCards(stepCount % deckLength, pl1FreePlace % deckLength, pl2FreePlace % deckLength);
            }
            player2TakesCards(stepCount % deckLength, pl1FreePlace % deckLength, pl2FreePlace % deckLength);
        } else if (stepResult < 0){
            if (stepResult > -8){
                player2TakesCards(stepCount % deckLength, pl1FreePlace % deckLength, pl2FreePlace % deckLength);
            }
            player1TakesCards(stepCount % deckLength, pl1FreePlace % deckLength, pl2FreePlace % deckLength);
        }
        mainGame((stepCount + 2) % deck.startDeck.length, pl1FreePlace % deckLength, pl2FreePlace % deckLength);
        
    }
}
